package com.future.ms.service;

import com.future.common.model.JmsJob;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JmsJobService {

    /**
     * 根据工作名称分页获取工作列表
     */
    List<JmsJob> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 添加工作信息
     */
    @Transactional
    int create(JmsJob jmsJob);

    /**
     * 根据id获取工作信息
     */
    JmsJob getItem(Long id);
}
