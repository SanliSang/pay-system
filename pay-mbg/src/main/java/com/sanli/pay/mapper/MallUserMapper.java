package com.sanli.pay.mapper;

import com.sanli.pay.model.MallUser;
import com.sanli.pay.model.MallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallUserMapper {
    long countByExample(MallUserExample example);

    int deleteByExample(MallUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(MallUser row);

    int insertSelective(MallUser row);

    List<MallUser> selectByExample(MallUserExample example);

    MallUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("row") MallUser row, @Param("example") MallUserExample example);

    int updateByExample(@Param("row") MallUser row, @Param("example") MallUserExample example);

    int updateByPrimaryKeySelective(MallUser row);

    int updateByPrimaryKey(MallUser row);
}