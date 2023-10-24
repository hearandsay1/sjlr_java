package com.future.web.service;

import com.future.web.dto.SmsAdvertiseVo;

import java.awt.*;
import java.util.List;

public interface SmsAdvertiseService {
    List<SmsAdvertiseVo> list(Integer pageSize, Integer pageNum);
}
