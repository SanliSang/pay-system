package com.sanli.pay.mapper;

import com.sanli.pay.model.MallProduct;
import com.sanli.pay.model.MallProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallProductMapper {
    long countByExample(MallProductExample example);

    int deleteByExample(MallProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallProduct row);

    int insertSelective(MallProduct row);

    List<MallProduct> selectByExampleWithBLOBs(MallProductExample example);

    List<MallProduct> selectByExample(MallProductExample example);

    MallProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") MallProduct row, @Param("example") MallProductExample example);

    int updateByExampleWithBLOBs(@Param("row") MallProduct row, @Param("example") MallProductExample example);

    int updateByExample(@Param("row") MallProduct row, @Param("example") MallProductExample example);

    int updateByPrimaryKeySelective(MallProduct row);

    int updateByPrimaryKeyWithBLOBs(MallProduct row);

    int updateByPrimaryKey(MallProduct row);
}