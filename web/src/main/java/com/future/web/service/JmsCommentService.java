package com.future.web.service;

import com.future.web.dto.JmsCommentParam;
import com.future.web.dto.JmsCommentVo;
import com.future.web.dto.JmsJobItemVo;

import java.util.List;

public interface JmsCommentService {


    List<JmsCommentVo> listByJid(Long jid, Integer pageSize, Integer pageNum);

    int comment(JmsCommentParam commentParam);
}
