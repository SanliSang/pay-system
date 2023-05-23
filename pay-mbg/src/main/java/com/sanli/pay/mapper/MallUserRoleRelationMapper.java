package com.sanli.pay.mapper;

import com.sanli.pay.model.MallUserRoleRelation;
import com.sanli.pay.model.MallUserRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserRoleRelationMapper {
    long countByExample(MallUserRoleRelationExample example);

    int deleteByExample(MallUserRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallUserRoleRelation row);

    int insertSelective(MallUserRoleRelation row);

    List<MallUserRoleRelation> selectByExample(MallUserRoleRelationExample example);

    MallUserRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallUserRoleRelation row, @Param("example") MallUserRoleRelationExample example);

    int updateByExample(@Param("row") MallUserRoleRelation row, @Param("example") MallUserRoleRelationExample example);

    int updateByPrimaryKeySelective(MallUserRoleRelation row);

    int updateByPrimaryKey(MallUserRoleRelation row);
}