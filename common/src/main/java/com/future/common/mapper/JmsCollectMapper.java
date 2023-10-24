package com.future.common.mapper;

import com.future.common.model.JmsCollect;
import com.future.common.model.JmsCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsCollectMapper {
    long countByExample(JmsCollectExample example);

    int deleteByExample(JmsCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsCollect row);

    int insertSelective(JmsCollect row);

    List<JmsCollect> selectByExample(JmsCollectExample example);

    JmsCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") JmsCollect row, @Param("example") JmsCollectExample example);

    int updateByExample(@Param("row") JmsCollect row, @Param("example") JmsCollectExample example);

    int updateByPrimaryKeySelective(JmsCollect row);

    int updateByPrimaryKey(JmsCollect row);
}