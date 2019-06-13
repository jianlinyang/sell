package com.shu.sell.repository;

import com.shu.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @date 2019/6/13 22:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
    }

    @Test
    public void save() {
        List<ProductInfo> productInfos = new ArrayList<>();
        for (int i = 10000; i < 11000; i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductName("皮蛋粥");
            productInfo.setProductPrice(new BigDecimal(3.2));
            productInfo.setProductStock(100);
            productInfo.setProductDescription("很好喝的粥");
            productInfo.setProductIcon("http://xx");
            productInfo.setProductStatus(0);
            productInfo.setCategoryType(3);
            productInfo.setProductId(String.valueOf(i));
            productInfos.add(productInfo);
        }
        repository.save(productInfos);
    }
}