package com.future.web.service;

import com.future.common.api.CommonResult;
import com.future.common.model.JmsRecord;

import java.util.List;

public interface JmsRecordService {



    int signup(Long jid);

    List<JmsRecord> recordList(Integer status, Integer pageNum, Integer pageSize);
}
