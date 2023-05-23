package com.sanli.pay.mapper;

import com.sanli.pay.model.MallOrderItem;
import com.sanli.pay.model.MallOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallOrderItemMapper {
    long countByExample(MallOrderItemExample example);

    int deleteByExample(MallOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallOrderItem row);

    int insertSelective(MallOrderItem row);

    List<MallOrderItem> selectByExample(MallOrderItemExample example);

    MallOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallOrderItem row, @Param("example") MallOrderItemExample example);

    int updateByExample(@Param("row") MallOrderItem row, @Param("example") MallOrderItemExample example);

    int updateByPrimaryKeySelective(MallOrderItem row);

    int updateByPrimaryKey(MallOrderItem row);
}