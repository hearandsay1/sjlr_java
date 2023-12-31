package com.future.ms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.future.common.mapper.JmsJobMapper;
import com.future.common.model.JmsJob;
import com.future.common.model.JmsJobExample;
import com.future.ms.service.JmsJobService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class JmsJobServiceImpl implements JmsJobService {

    @Autowired
    private JmsJobMapper jobMapper;

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
    public int create(JmsJob jmsJob) {
        jmsJob.setCreateTime(new Date());
        jmsJob.setCollectNum(0);
        jmsJob.setLikeNum(0);
        jmsJob.setCommentNum(0);
        jmsJob.setDel(0);
        return jobMapper.insert(jmsJob);
    }

    @Override
    public JmsJob getItem(Long id) {
        return jobMapper.selectByPrimaryKey(id);
    }
}
