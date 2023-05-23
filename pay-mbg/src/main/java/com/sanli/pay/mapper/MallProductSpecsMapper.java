package com.sanli.pay.mapper;

import com.sanli.pay.model.MallProductSpecs;
import com.sanli.pay.model.MallProductSpecsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallProductSpecsMapper {
    long countByExample(MallProductSpecsExample example);

    int deleteByExample(MallProductSpecsExample example);

    int deleteByPrimaryKey(Integer specsId);

    int insert(MallProductSpecs row);

    int insertSelective(MallProductSpecs row);

    List<MallProductSpecs> selectByExample(MallProductSpecsExample example);

    MallProductSpecs selectByPrimaryKey(Integer specsId);

    int updateByExampleSelective(@Param("row") MallProductSpecs row, @Param("example") MallProductSpecsExample example);

    int updateByExample(@Param("row") MallProductSpecs row, @Param("example") MallProductSpecsExample example);

    int updateByPrimaryKeySelective(MallProductSpecs row);

    int updateByPrimaryKey(MallProductSpecs row);
}