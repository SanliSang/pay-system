package com.sanli.pay.mapper;

import com.sanli.pay.model.MallProductAttributeKey;
import com.sanli.pay.model.MallProductAttributeKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallProductAttributeKeyMapper {
    long countByExample(MallProductAttributeKeyExample example);

    int deleteByExample(MallProductAttributeKeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallProductAttributeKey row);

    int insertSelective(MallProductAttributeKey row);

    List<MallProductAttributeKey> selectByExample(MallProductAttributeKeyExample example);

    MallProductAttributeKey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallProductAttributeKey row, @Param("example") MallProductAttributeKeyExample example);

    int updateByExample(@Param("row") MallProductAttributeKey row, @Param("example") MallProductAttributeKeyExample example);

    int updateByPrimaryKeySelective(MallProductAttributeKey row);

    int updateByPrimaryKey(MallProductAttributeKey row);
}