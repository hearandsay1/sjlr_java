package com.future.ms.dto;

import com.future.common.model.JmsJob;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JmsJobParam extends JmsJob {

    private List<JmsJobFilterVo> filter;
}
