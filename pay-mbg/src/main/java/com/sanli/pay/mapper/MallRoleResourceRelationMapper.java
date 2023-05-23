package com.sanli.pay.mapper;

import com.sanli.pay.model.MallRoleResourceRelation;
import com.sanli.pay.model.MallRoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallRoleResourceRelationMapper {
    long countByExample(MallRoleResourceRelationExample example);

    int deleteByExample(MallRoleResourceRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallRoleResourceRelation row);

    int insertSelective(MallRoleResourceRelation row);

    List<MallRoleResourceRelation> selectByExample(MallRoleResourceRelationExample example);

    MallRoleResourceRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallRoleResourceRelation row, @Param("example") MallRoleResourceRelationExample example);

    int updateByExample(@Param("row") MallRoleResourceRelation row, @Param("example") MallRoleResourceRelationExample example);

    int updateByPrimaryKeySelective(MallRoleResourceRelation row);

    int updateByPrimaryKey(MallRoleResourceRelation row);
}