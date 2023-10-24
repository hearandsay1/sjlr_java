package com.future.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class JmsJobItemVo {

    @ApiModelProperty
    private Long id;

    @ApiModelProperty(value = "工作的标题")
    private String title;

    @ApiModelProperty(value = "工作的标签：json格式保存")
    private String tag;

    @ApiModelProperty(value = "雇佣的企业名称")
    private String company;

    @ApiModelProperty(value = "工作的区域")
    private String area;

    @ApiModelProperty(value = "点赞数")
    private Integer likeNum;

    @ApiModelProperty(value = "评论数")
    private Integer commentNum;

    @ApiModelProperty(value = "收藏数")
    private Integer collectNum;

    @ApiModelProperty(value = "薪水数值")
    private BigDecimal salary;

    @ApiModelProperty(value = "薪水时间单位：0->每小时，1->每天，2->每周，3->每月，4->每年")
    private Integer salaryUnit;

//    @ApiModelProperty(value = "发布时间")
//    private Date pubTime;
}
