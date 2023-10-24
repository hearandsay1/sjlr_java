package com.future.web.service.impl;

import com.future.common.mapper.JmsJobMapper;
import com.future.common.mapper.JmsRecordMapper;
import com.future.common.model.JmsJob;
import com.future.common.model.JmsRecord;
import com.future.common.model.JmsRecordExample;
import com.future.common.model.UmsMember;
import com.future.web.service.JmsJobService;
import com.future.web.service.JmsRecordService;
import com.future.web.service.UmsMemberService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JmsRecordServiceImpl implements JmsRecordService {


    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private JmsRecordMapper recordMapper;

    @Autowired
    private JmsJobMapper jobMapper;

    @Override
    public List<JmsRecord> recordList(Integer status,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JmsRecordExample example = new JmsRecordExample();
        JmsRecordExample.Criteria criteria = example.createCriteria();
        if(status!=null){
            criteria.andStatusEqualTo(status);
        }
        UmsMember member = memberService.getCurrentMember();
        criteria.andMidEqualTo(member.getId());
        return recordMapper.selectByExample(example);
    }

    @Override
    public int signup(Long jid) {
        JmsJob jmsJob = jobMapper.selectByPrimaryKey(jid);
        if(jmsJob==null){
            return 0;
        }
        //检验是否重复报名
        JmsRecordExample example = new JmsRecordExample();
        JmsRecordExample.Criteria criteria = example.createCriteria();
        criteria.andJidEqualTo(jid);
        criteria.andMidEqualTo(memberService.getCurrentMember().getId());
        List<JmsRecord> jmsRecords = recordMapper.selectByExample(example);
        if(jmsRecords.size()!=0){
            return 0;
        }
        JmsRecord record = new JmsRecord();
        record.setArea(jmsJob.getArea());
        record.setJid(jid);
        record.setStatus(0);
        record.setMid(memberService.getCurrentMember().getId());
        record.setTitle(jmsJob.getTitle());
        switch (jmsJob.getSalaryUnit()){
            case 0:
                record.setSalary(jmsJob.getSalary()+"元/每小时");
                break;
            case 1:
                record.setSalary(jmsJob.getSalary()+"元/每天");
                break;
            case 2:
                record.setSalary(jmsJob.getSalary()+"元/每周");
                break;
            case 3:
                record.setSalary(jmsJob.getSalary()+"元/每月");
                break;
            case 4:
                record.setSalary(jmsJob.getSalary()+"元/每年");
                break;
        }
        record.setCreateTime(new Date());
        return recordMapper.insert(record);
    }
}
