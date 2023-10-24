package com.future.web.service.impl;

import com.future.common.mapper.JmsCommentMapper;
import com.future.common.model.JmsComment;
import com.future.common.model.JmsCommentExample;
import com.future.common.model.UmsMember;
import com.future.web.dto.JmsCommentParam;
import com.future.web.dto.JmsCommentVo;
import com.future.web.dto.JmsJobItemVo;
import com.future.web.service.JmsCommentService;
import com.future.web.service.UmsMemberService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JmsCommentServiceImpl implements JmsCommentService {

    @Autowired
    private JmsCommentMapper commentMapper;

    @Autowired
    private UmsMemberService memberService;

    @Override
    public List<JmsCommentVo> listByJid(Long jid, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        JmsCommentExample example = new JmsCommentExample();
        JmsCommentExample.Criteria criteria = example.createCriteria();
        criteria.andJidEqualTo(jid);
        List<JmsComment> jmsComments = commentMapper.selectByExample(example);
        List<JmsCommentVo> res = new ArrayList<>(jmsComments.size());
        for(JmsComment jmsComment : jmsComments){
            JmsCommentVo commentVo = new JmsCommentVo();
            BeanUtils.copyProperties(jmsComment,commentVo);
            criteria.andPidEqualTo(jmsComment.getId());
            List<JmsComment> reply = commentMapper.selectByExample(example);
            if(reply.size()>0){
                //TODO 前期最多允许一条评论
                List<JmsCommentVo> commentVoList =new ArrayList<>(1);
                JmsCommentVo replyVo = new JmsCommentVo();
                BeanUtils.copyProperties(reply.get(0),replyVo);
                commentVoList.add(replyVo);
                commentVo.setReplies(commentVoList);
            }
            res.add(commentVo);
        }
        return res;
    }

    @Override
    public int comment(JmsCommentParam commentParam) {
        JmsComment comment = new JmsComment();
        if(commentParam.getCid()!=0){
            JmsComment check = commentMapper.selectByPrimaryKey(commentParam.getCid());
            if(check==null){
                return 0;
            }else{
                comment.setPid(commentParam.getCid());
            }
        }
        UmsMember member = memberService.getCurrentMember();
        comment.setContent(commentParam.getContent());
        comment.setJid(commentParam.getJid());
        comment.setCreateTime(new Date());
        comment.setStatus(true);
        comment.setMemberName(member.getNickname());
        comment.setMenberAvatar(member.getAvatar());

        return commentMapper.insert(comment);
    }
}
