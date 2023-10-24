package com.future.web.service.impl;

import com.future.common.mapper.SmsAdvertiseMapper;
import com.future.common.model.SmsAdvertise;
import com.future.common.model.SmsAdvertiseExample;
import com.future.web.dto.SmsAdvertiseVo;
import com.future.web.service.SmsAdvertiseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmsAdvertiseServiceImpl implements SmsAdvertiseService {

    @Autowired
    private SmsAdvertiseMapper advertiseMapper;


    @Override
    public List<SmsAdvertiseVo> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsAdvertiseExample example = new SmsAdvertiseExample();
        List<SmsAdvertise> smsAdvertises = advertiseMapper.selectByExample(example);
        List<SmsAdvertiseVo> advertiseVoList = new ArrayList<>(smsAdvertises.size());
        for(SmsAdvertise advertise:smsAdvertises){
            SmsAdvertiseVo smsAdvertiseVo = new SmsAdvertiseVo();
            smsAdvertiseVo.setId(advertise.getId());
            smsAdvertiseVo.setPic(advertise.getPic());
            smsAdvertiseVo.setUrl(advertise.getUrl());
            smsAdvertiseVo.setSort(advertise.getSort());
            advertiseVoList.add(smsAdvertiseVo);
        }
        return advertiseVoList;
    }
}
