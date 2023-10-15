package com.future.common.mapper;

import com.future.common.model.JmsFilterItem;
import com.future.common.model.JmsFilterItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsFilterItemMapper {
    long countByExample(JmsFilterItemExample example);

    int deleteByExample(JmsFilterItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsFilterItem row);

    int insertSelective(JmsFilterItem row);

    List<JmsFilterItem> selectByExample(JmsFilterItemExample example);

    JmsFilterItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") JmsFilterItem row, @Param("example") JmsFilterItemExample example);

    int updateByExample(@Param("row") JmsFilterItem row, @Param("example") JmsFilterItemExample example);

    int updateByPrimaryKeySelective(JmsFilterItem row);

    int updateByPrimaryKey(JmsFilterItem row);
}