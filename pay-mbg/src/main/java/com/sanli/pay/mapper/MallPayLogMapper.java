package com.sanli.pay.mapper;

import com.sanli.pay.model.MallPayLog;
import com.sanli.pay.model.MallPayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallPayLogMapper {
    long countByExample(MallPayLogExample example);

    int deleteByExample(MallPayLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallPayLog row);

    int insertSelective(MallPayLog row);

    List<MallPayLog> selectByExample(MallPayLogExample example);

    MallPayLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallPayLog row, @Param("example") MallPayLogExample example);

    int updateByExample(@Param("row") MallPayLog row, @Param("example") MallPayLogExample example);

    int updateByPrimaryKeySelective(MallPayLog row);

    int updateByPrimaryKey(MallPayLog row);
}