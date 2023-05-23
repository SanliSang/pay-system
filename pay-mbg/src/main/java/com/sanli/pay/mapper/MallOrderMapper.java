package com.sanli.pay.mapper;

import com.sanli.pay.model.MallOrder;
import com.sanli.pay.model.MallOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallOrderMapper {
    long countByExample(MallOrderExample example);

    int deleteByExample(MallOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallOrder row);

    int insertSelective(MallOrder row);

    List<MallOrder> selectByExample(MallOrderExample example);

    MallOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallOrder row, @Param("example") MallOrderExample example);

    int updateByExample(@Param("row") MallOrder row, @Param("example") MallOrderExample example);

    int updateByPrimaryKeySelective(MallOrder row);

    int updateByPrimaryKey(MallOrder row);
}