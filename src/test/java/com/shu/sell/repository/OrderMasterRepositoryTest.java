package com.shu.sell.repository;

import com.shu.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author yang
 * @date 2019/6/14 14:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void findByBuyerOpenId() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345");
        orderMaster.setBuyerName("yang");
        orderMaster.setBuyerPhone("13724283483");
        orderMaster.setBuyerAddress("上海");
        orderMaster.setBuyerOpenId("11111");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        repository.save(orderMaster);
    }
}