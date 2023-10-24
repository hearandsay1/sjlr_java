package com.future.common.mapper;

import com.future.common.model.JmsRecord;
import com.future.common.model.JmsRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsRecordMapper {
    long countByExample(JmsRecordExample example);

    int deleteByExample(JmsRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsRecord row);

    int insertSelective(JmsRecord row);

    List<JmsRecord> selectByExample(JmsRecordExample example);

    JmsRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") JmsRecord row, @Param("example") JmsRecordExample example);

    int updateByExample(@Param("row") JmsRecord row, @Param("example") JmsRecordExample example);

    int updateByPrimaryKeySelective(JmsRecord row);

    int updateByPrimaryKey(JmsRecord row);
}