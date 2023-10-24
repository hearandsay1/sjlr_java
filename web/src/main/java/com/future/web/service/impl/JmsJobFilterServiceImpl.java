package com.future.web.service.impl;

import com.future.common.mapper.JmsFilterItemMapper;
import com.future.common.mapper.JmsFilterMapper;
import com.future.common.model.JmsFilter;
import com.future.common.model.JmsFilterExample;
import com.future.common.model.JmsFilterItem;
import com.future.common.model.JmsFilterItemExample;
import com.future.web.dto.JmsJobFilterVo;
import com.future.web.service.JmsJobFilterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JmsJobFilterServiceImpl implements JmsJobFilterService {

    @Autowired
    private JmsFilterMapper filterMapper;

    @Autowired
    private JmsFilterItemMapper filterItemMapper;

    @Override
    public List<JmsJobFilterVo> list() {
        JmsFilterExample example = new JmsFilterExample();
        List<JmsFilter> filterList = filterMapper.selectByExample(example);
        List<JmsJobFilterVo> res = new ArrayList<>(filterList.size());
        for(JmsFilter filter: filterList){
            JmsJobFilterVo filterVo = new JmsJobFilterVo();
            BeanUtils.copyProperties(filter,filterVo);
            JmsFilterItemExample itemExample = new JmsFilterItemExample();
            JmsFilterItemExample.Criteria criteria = itemExample.createCriteria();
            criteria.andFidEqualTo(filter.getId());
            List<JmsFilterItem> filterItems = filterItemMapper.selectByExample(itemExample);
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0;i<filterItems.size();i++){
//                sb.append(filterItems.get(i).getName());
//                if(i<filterItems.size()-1){
//                    sb.append(",");
//                }
//            }
            filterVo.setFilterItems(filterItems);
            res.add(filterVo);
        }
        return res;
    }
}
