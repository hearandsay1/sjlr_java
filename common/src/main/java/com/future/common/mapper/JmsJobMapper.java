package com.future.common.mapper;

import com.future.common.model.JmsJob;
import com.future.common.model.JmsJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsJobMapper {
    long countByExample(JmsJobExample example);

    int deleteByExample(JmsJobExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsJob row);

    int insertSelective(JmsJob row);

    List<JmsJob> selectByExample(JmsJobExample example);

    JmsJob selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") JmsJob row, @Param("example") JmsJobExample example);

    int updateByExample(@Param("row") JmsJob row, @Param("example") JmsJobExample example);

    int updateByPrimaryKeySelective(JmsJob row);

    int updateByPrimaryKey(JmsJob row);
}