package com.shu.sell.repository;

import com.shu.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author yang
 * @date 2019/6/14 16:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12355");
        orderDetail.setOrderId("2133");
        orderDetail.setProductPrice(new BigDecimal(8.1));
        orderDetail.setProductIcon("sdadsa");
        orderDetail.setProductId("sd");
        orderDetail.setProductName("name");
        orderDetail.setProductQuantity(1);
        repository.save(orderDetail);

    }
}