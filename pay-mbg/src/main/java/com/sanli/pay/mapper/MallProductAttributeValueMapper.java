package com.sanli.pay.mapper;

import com.sanli.pay.model.MallProductAttributeValue;
import com.sanli.pay.model.MallProductAttributeValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallProductAttributeValueMapper {
    long countByExample(MallProductAttributeValueExample example);

    int deleteByExample(MallProductAttributeValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallProductAttributeValue row);

    int insertSelective(MallProductAttributeValue row);

    List<MallProductAttributeValue> selectByExample(MallProductAttributeValueExample example);

    MallProductAttributeValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallProductAttributeValue row, @Param("example") MallProductAttributeValueExample example);

    int updateByExample(@Param("row") MallProductAttributeValue row, @Param("example") MallProductAttributeValueExample example);

    int updateByPrimaryKeySelective(MallProductAttributeValue row);

    int updateByPrimaryKey(MallProductAttributeValue row);
}