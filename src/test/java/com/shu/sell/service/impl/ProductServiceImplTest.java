package com.shu.sell.service.impl;

import com.shu.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yang
 * @date 2019/6/13 23:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<ProductInfo> all = service.findAll(pageRequest);
        System.out.println(all.getTotalElements());
    }

    @Test
    public void findOne() {
        ProductInfo one = service.findOne(String.valueOf(10000));
        System.out.println(one.getProductDescription());
    }

    @Test
    public void findUpAll() {
    }

    @Test
    public void save() {
    }
}