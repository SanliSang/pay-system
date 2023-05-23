package com.sanli.pay.mapper;

import com.sanli.pay.model.MallRole;
import com.sanli.pay.model.MallRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallRoleMapper {
    long countByExample(MallRoleExample example);

    int deleteByExample(MallRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(MallRole row);

    int insertSelective(MallRole row);

    List<MallRole> selectByExample(MallRoleExample example);

    MallRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("row") MallRole row, @Param("example") MallRoleExample example);

    int updateByExample(@Param("row") MallRole row, @Param("example") MallRoleExample example);

    int updateByPrimaryKeySelective(MallRole row);

    int updateByPrimaryKey(MallRole row);
}