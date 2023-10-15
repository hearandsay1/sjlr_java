package com.future.common.mapper;

import com.future.common.model.SmsAdvertise;
import com.future.common.model.SmsAdvertiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsAdvertiseMapper {
    long countByExample(SmsAdvertiseExample example);

    int deleteByExample(SmsAdvertiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsAdvertise row);

    int insertSelective(SmsAdvertise row);

    List<SmsAdvertise> selectByExample(SmsAdvertiseExample example);

    SmsAdvertise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SmsAdvertise row, @Param("example") SmsAdvertiseExample example);

    int updateByExample(@Param("row") SmsAdvertise row, @Param("example") SmsAdvertiseExample example);

    int updateByPrimaryKeySelective(SmsAdvertise row);

    int updateByPrimaryKey(SmsAdvertise row);
}