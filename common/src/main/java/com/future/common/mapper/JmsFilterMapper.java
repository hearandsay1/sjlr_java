package com.future.common.mapper;

import com.future.common.model.JmsFilter;
import com.future.common.model.JmsFilterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsFilterMapper {
    long countByExample(JmsFilterExample example);

    int deleteByExample(JmsFilterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsFilter row);

    int insertSelective(JmsFilter row);

    List<JmsFilter> selectByExample(JmsFilterExample example);

    JmsFilter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") JmsFilter row, @Param("example") JmsFilterExample example);

    int updateByExample(@Param("row") JmsFilter row, @Param("example") JmsFilterExample example);

    int updateByPrimaryKeySelective(JmsFilter row);

    int updateByPrimaryKey(JmsFilter row);
}