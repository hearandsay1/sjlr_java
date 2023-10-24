package com.future.ms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.future.common.mapper.JmsFilterItemMapper;
import com.future.common.mapper.JmsFilterMapper;
import com.future.common.model.JmsFilter;
import com.future.common.model.JmsFilterExample;
import com.future.common.model.JmsFilterItem;
import com.future.common.model.JmsFilterItemExample;
import com.future.ms.dto.JmsFilterParam;
import com.future.ms.dto.JmsJobFilterVo;
import com.future.ms.service.JmsFilterService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JmsFilterServiceImpl implements JmsFilterService {

    @Autowired
    private JmsFilterMapper filterMapper;

    @Autowired
    private JmsFilterItemMapper filterItemMapper;

    @Override
    public List<JmsJobFilterVo> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        JmsFilterExample example = new JmsFilterExample();
        JmsFilterExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        List<JmsFilter> filterList = filterMapper.selectByExample(example);
        List<JmsJobFilterVo> filterVos = new ArrayList<>(filterList.size());
        for(JmsFilter filter: filterList){
            JmsJobFilterVo filterVo = new JmsJobFilterVo();
            BeanUtils.copyProperties(filter,filterVo);
            JmsFilterItemExample example1 = new JmsFilterItemExample();
            JmsFilterItemExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andFidEqualTo(filter.getId());
            List<JmsFilterItem> filterItems = filterItemMapper.selectByExample(example1);
            filterVo.setValues(filterItems);
            filterVos.add(filterVo);
        }
        return filterVos;
    }

    @Override
    public int create(JmsFilterParam jmsFilterParam) {
        //判断是否存在相同的筛选条件
        JmsFilterExample example = new JmsFilterExample();
        JmsFilterExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(jmsFilterParam.getName());
        List<JmsFilter> filterList = filterMapper.selectByExample(example);
        if(filterList.size()==0){
            //可添加
            JmsFilter filter = new JmsFilter();
            BeanUtils.copyProperties(jmsFilterParam,filter);
            Long fid = (long)filterMapper.insert(filter);
            if(fid>0){
                //添加成功，开始解析添加筛选条件项
                String itemString = jmsFilterParam.getItems();
                List<String> items = Arrays.asList(itemString.split(","));
                for(String item : items){
                    JmsFilterItem filterItem = new JmsFilterItem();
                    filterItem.setFid(fid);
                    filterItem.setName(item);
                    filterItemMapper.insert(filterItem);
                };
                return 1;
            }
            return 0;

        }else {
            //不可添加报错
            return 0;
        }
    }

    @Override
    public JmsFilterParam getItem(Long id) {
        JmsFilter filter = filterMapper.selectByPrimaryKey(id);
        JmsFilterItemExample example = new JmsFilterItemExample();
        JmsFilterItemExample.Criteria criteria = example.createCriteria();
        criteria.andFidEqualTo(id);
        List<JmsFilterItem> filterItems = filterItemMapper.selectByExample(example);
        JmsFilterParam filterParam = new JmsFilterParam();
        BeanUtils.copyProperties(filter,filterParam);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<filterItems.size();i++){
            sb.append(filterItems.get(i).getName());
            if(i<filterItems.size()-1){
                sb.append(",");
            }
        }
        filterParam.setItems(sb.toString());
        return filterParam;
    }
}
