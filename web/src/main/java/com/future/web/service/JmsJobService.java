package com.future.web.service;

import com.future.common.model.JmsJob;
import com.future.web.dto.JmsJobItemVo;
import com.future.web.dto.JmsJobListConditionParams;

import java.util.List;

public interface JmsJobService {


    List<JmsJobItemVo> list(JmsJobListConditionParams filterParams, Integer pageSize, Integer pageNum);

    JmsJob detail(Long id);

    int like(Long jid);

    int collect(Long jid);
}
