package com.future.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JmsCommentVo {

    private Long id;

    @ApiModelProperty(value = "父级id")
    private Long pid;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "用户id")
    private Long mid;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "用户头像（冗余作用）")
    private String menberAvatar;

    @ApiModelProperty(value = "用户昵称（冗余作用）")
    private String memberName;

    @ApiModelProperty(value = "回复内容列表")
    List<JmsCommentVo> replies;
}
