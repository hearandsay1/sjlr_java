package com.future.ms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.future.common.mapper.SmsAdvertiseMapper;
import com.future.common.model.SmsAdvertise;
import com.future.common.model.SmsAdvertiseExample;
import com.future.ms.service.SmsAdvertiseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class SmsAdvertiseServiceImpl implements SmsAdvertiseService {

    @Autowired
    private SmsAdvertiseMapper advertiseMapper;

    @Override
    public int create(SmsAdvertise advertise) {
        return 0;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        return 0;
    }

    @Override
    public SmsAdvertise getItem(Long id) {
        return null;
    }

    @Override
    public int update(Long id, SmsAdvertise advertise) {
        return 0;
    }

    @Override
    public List<SmsAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsAdvertiseExample example = new SmsAdvertiseExample();
        SmsAdvertiseExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        if (!StrUtil.isEmpty(endTime)) {
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            try {
                start = sdf.parse(startStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date end = null;
            try {
                end = sdf.parse(endStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (start != null && end != null) {
                criteria.andEndTimeBetween(start, end);
            }
        }
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }
}
