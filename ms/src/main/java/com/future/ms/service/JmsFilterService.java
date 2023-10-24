package com.future.ms.service;

import com.future.ms.dto.JmsFilterParam;
import com.future.ms.dto.JmsJobFilterVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JmsFilterService {

    /**
     * 根据名称分页获取筛选条件列表
     */
    List<JmsJobFilterVo> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 添加筛选条件
     */
    @Transactional
    int create(JmsFilterParam jmsFilterParam);

    /**
     * 根据id筛选条件详情
     */
    JmsFilterParam getItem(Long id);
}
