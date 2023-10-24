package com.future.web.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.future.common.mapper.JmsCollectMapper;
import com.future.common.mapper.JmsJobMapper;
import com.future.common.model.JmsCollect;
import com.future.common.model.JmsCollectExample;
import com.future.common.model.JmsJob;
import com.future.common.model.JmsJobExample;
import com.future.web.dto.JmsJobItemVo;
import com.future.web.dto.JmsJobListConditionParams;
import com.future.web.service.JmsJobService;
import com.future.web.service.UmsMemberService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JmsJobServiceImpl implements JmsJobService {

    @Autowired
    private JmsJobMapper jobMapper;

    @Autowired
    private JmsCollectMapper collectMapper;

    @Autowired
    private UmsMemberService memberService;

    @Override
    public List<JmsJobItemVo> list(JmsJobListConditionParams filterParams, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        JmsJobExample example = new JmsJobExample();
        JmsJobExample.Criteria criteria = example.createCriteria();
        //TODO 根据筛选条件查询
        if(StrUtil.isNotEmpty(filterParams.getArea())){
            criteria.andAreaEqualTo(filterParams.getArea());
        }
        if(filterParams.getSort()!=null){
            if(filterParams.getSort()==0){
                //最新发布
                example.setOrderByClause("pub_time desc");
            }else{
                //点赞数
                example.setOrderByClause("like_num desc");
            }
        }

        List<JmsJob> jobList = jobMapper.selectByExample(example);
        List<JmsJobItemVo> jobVoList = new ArrayList<>(jobList.size());
        for(JmsJob job:jobList){
            //查出来后进行过滤
            if(CollectionUtil.isNotEmpty(filterParams.getJobFilterParams())){
//                String filter = job.getFilter();
            }
            JmsJobItemVo jobVo = new JmsJobItemVo();
            BeanUtils.copyProperties(job,jobVo);
            jobVoList.add(jobVo);
        }
        return jobVoList;
    }

    @Override
    public JmsJob detail(Long id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public int like(Long jid) {
        JmsJob jmsJob = jobMapper.selectByPrimaryKey(jid);
        if(jmsJob==null){
            return 0;
        }
        jmsJob.setLikeNum(jmsJob.getLikeNum()+1);
        return jobMapper.insertSelective(jmsJob);
    }

    @Override
    public int collect(Long jid) {
        JmsCollectExample example = new JmsCollectExample();
        JmsCollectExample.Criteria criteria = example.createCriteria();
        criteria.andJidEqualTo(jid);
        criteria.andJidEqualTo(memberService.getCurrentMember().getId());
        List<JmsCollect> jmsCollects = collectMapper.selectByExample(example);
        if(CollectionUtil.isEmpty(jmsCollects)){
            //收藏
            JmsCollect collect = new JmsCollect();
            collect.setJid(jid);
            collect.setMid(memberService.getCurrentMember().getId());
            collect.setCreateTime(new Date());
            return collectMapper.insert(collect);
        }else{
               //取消收藏
            return collectMapper.deleteByPrimaryKey(jmsCollects.get(0).getId());
        }
    }
}
