package com.sanli.pay.service.impl;

import com.sanli.pay.mapper.MallProductMapper;
import com.sanli.pay.model.MallProduct;
import com.sanli.pay.service.MallProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MallProductServiceImpl implements MallProductService {

    @Autowired
    private MallProductMapper mallProductMapper;

    @Override
    public void addProduct(MallProduct product) {
        mallProductMapper.insertSelective(product);
    }
}
