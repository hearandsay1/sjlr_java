package com.future.common.mapper;

import com.future.common.model.JmsJobFilterRelation;
import com.future.common.model.JmsJobFilterRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsJobFilterRelationMapper {
    long countByExample(JmsJobFilterRelationExample example);

    int deleteByExample(JmsJobFilterRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsJobFilterRelation row);

    int insertSelective(JmsJobFilterRelation row);

    List<JmsJobFilterRelation> selectByExample(JmsJobFilterRelationExample example);

    JmsJobFilterRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") JmsJobFilterRelation row, @Param("example") JmsJobFilterRelationExample example);

    int updateByExample(@Param("row") JmsJobFilterRelation row, @Param("example") JmsJobFilterRelationExample example);

    int updateByPrimaryKeySelective(JmsJobFilterRelation row);

    int updateByPrimaryKey(JmsJobFilterRelation row);
}