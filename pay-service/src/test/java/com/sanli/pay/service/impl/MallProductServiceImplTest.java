package com.sanli.pay.service.impl;

import com.sanli.pay.PayServiceApplicationTests;
import com.sanli.pay.model.MallProduct;
import com.sanli.pay.service.MallProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MallProductServiceImplTest extends PayServiceApplicationTests {

    @Autowired
    private MallProductService mallProductService;

    @Test
    public void addProduct() {
        MallProduct mallProduct = new MallProduct();
        mallProduct.setProductId(101);
        mallProduct.setProductName("测试商品");
        mallProduct.setCategoryId(10001);
        mallProduct.setStatus(1);
        mallProductService.addProduct(mallProduct);
    }
}