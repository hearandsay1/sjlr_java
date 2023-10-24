package com.future.web.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JmsJobFilterParam {

    @ApiModelProperty("筛选条件名称id")
    private Long fid;
    @ApiModelProperty("筛选条件项的id")
    private String fiids;

}
