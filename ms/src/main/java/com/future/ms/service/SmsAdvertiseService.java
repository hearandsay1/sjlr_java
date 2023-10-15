package com.future.ms.service;

import com.future.common.model.SmsAdvertise;

import java.util.List;

public interface SmsAdvertiseService {
    /**
     * 添加广告
     */
    int create(SmsAdvertise advertise);

    /**
     * 批量删除广告
     */
    int delete(List<Long> ids);

    /**
     * 修改上、下线状态
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取广告详情
     */
    SmsAdvertise getItem(Long id);

    /**
     * 更新广告
     */
    int update(Long id, SmsAdvertise advertise);

    /**
     * 分页查询广告
     */
    List<SmsAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);

}
