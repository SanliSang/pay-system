package com.sanli.pay.mapper;

import com.sanli.pay.model.MallResource;
import com.sanli.pay.model.MallResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallResourceMapper {
    long countByExample(MallResourceExample example);

    int deleteByExample(MallResourceExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(MallResource row);

    int insertSelective(MallResource row);

    List<MallResource> selectByExample(MallResourceExample example);

    MallResource selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("row") MallResource row, @Param("example") MallResourceExample example);

    int updateByExample(@Param("row") MallResource row, @Param("example") MallResourceExample example);

    int updateByPrimaryKeySelective(MallResource row);

    int updateByPrimaryKey(MallResource row);
}