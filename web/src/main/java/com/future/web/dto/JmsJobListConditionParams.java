package com.future.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JmsJobListConditionParams {

    @ApiModelProperty("要筛选的地区,不需要时传null")
    private String area;

    @ApiModelProperty("排序条件：0->最新发布，1->热门，默认值为0")
    private Integer sort=0;
    @ApiModelProperty("筛选条件列表")
    private List<JmsJobFilterParam> jobFilterParams;
}
