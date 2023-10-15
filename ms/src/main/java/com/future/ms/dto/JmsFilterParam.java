package com.future.ms.dto;

import com.future.common.model.JmsFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JmsFilterParam extends JmsFilter {

    @ApiModelProperty(value = "筛选条件项")
    private String items;
}
