package com.future.common.mapper;

import com.future.common.model.UmsRoleResourceRelation;
import com.future.common.model.UmsRoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRoleResourceRelationMapper {
    long countByExample(UmsRoleResourceRelationExample example);

    int deleteByExample(UmsRoleResourceRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleResourceRelation row);

    int insertSelective(UmsRoleResourceRelation row);

    List<UmsRoleResourceRelation> selectByExample(UmsRoleResourceRelationExample example);

    UmsRoleResourceRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UmsRoleResourceRelation row, @Param("example") UmsRoleResourceRelationExample example);

    int updateByExample(@Param("row") UmsRoleResourceRelation row, @Param("example") UmsRoleResourceRelationExample example);

    int updateByPrimaryKeySelective(UmsRoleResourceRelation row);

    int updateByPrimaryKey(UmsRoleResourceRelation row);
}