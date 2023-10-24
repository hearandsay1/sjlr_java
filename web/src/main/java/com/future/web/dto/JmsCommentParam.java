package com.future.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JmsCommentParam {

    @ApiModelProperty(value = "要回复的工作的id")
    private Long jid;

    @ApiModelProperty(value = "要回复的评论的id;0代表首条评论")
    private Long cid;


    @ApiModelProperty(value = "评论内容")
    private String content;


}
