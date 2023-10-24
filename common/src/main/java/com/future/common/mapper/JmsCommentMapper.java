package com.future.common.mapper;

import com.future.common.model.JmsComment;
import com.future.common.model.JmsCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsCommentMapper {
    long countByExample(JmsCommentExample example);

    int deleteByExample(JmsCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsComment row);

    int insertSelective(JmsComment row);

    List<JmsComment> selectByExample(JmsCommentExample example);

    JmsComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") JmsComment row, @Param("example") JmsCommentExample example);

    int updateByExample(@Param("row") JmsComment row, @Param("example") JmsCommentExample example);

    int updateByPrimaryKeySelective(JmsComment row);

    int updateByPrimaryKey(JmsComment row);
}