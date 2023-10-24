package com.future.ms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.future.common.mapper.JmsJobFilterRelationMapper;
import com.future.common.mapper.JmsJobMapper;
import com.future.common.model.JmsFilterItem;
import com.future.common.model.JmsJob;
import com.future.common.model.JmsJobExample;
import com.future.common.model.JmsJobFilterRelation;
import com.future.ms.dto.JmsJobFilterVo;
import com.future.ms.dto.JmsJobParam;
import com.future.ms.service.JmsJobService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class JmsJobServiceImpl implements JmsJobService {

    @Autowired
    private JmsJobMapper jobMapper;
    @Autowired
    private JmsJobFilterRelationMapper jmsJobFilterRelationMapper;

    @Override
    public List<JmsJob> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        JmsJobExample example = new JmsJobExample();
        JmsJobExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        return jobMapper.selectByExample(example);
    }

    @Override
    public int create(JmsJobParam jmsJobParam) {
        JmsJob jmsJob = new JmsJob();
        BeanUtils.copyProperties(jmsJobParam,jmsJob);
        jmsJob.setCreateTime(new Date());
        jmsJob.setCollectNum(0);
        jmsJob.setLikeNum(0);
        jmsJob.setCommentNum(0);
        jmsJob.setDel(0);
        if(jmsJobParam.getStatus()==1){
            jmsJob.setPubTime(new Date());
        }
        int count = jobMapper.insert(jmsJob);
        //新增筛选条件
        for(JmsJobFilterVo filterVo: jmsJobParam.getFilter()){
            if(filterVo.getChecked()){
                JmsJobFilterRelation relation = new JmsJobFilterRelation();
                relation.setJid(jmsJob.getId());
                relation.setFid(filterVo.getId());
                relation.setType(filterVo.getType());
                List<JmsFilterItem> values = filterVo.getValues();

                relation.setVals(values.toString());
                jmsJobFilterRelationMapper.insert(relation);
                count++;
            }
        }
        return count;
    }

    @Override
    public JmsJob getItem(Long id) {
        return jobMapper.selectByPrimaryKey(id);
    }
}
