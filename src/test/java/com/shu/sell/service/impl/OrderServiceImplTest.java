package com.shu.sell.service.impl;

import com.shu.sell.dataobject.OrderDetail;
import com.shu.sell.dto.OrderDTO;
import com.shu.sell.enums.OrderStatusEnum;
import com.shu.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author yang
 * @date 2019/6/14 20:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;
    private final String BUYER_OPENID = "2145325";
    private final String ORDER_ID = "7101951560517230052";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("shui");
        orderDTO.setBuyerAddress("上海大学");
        orderDTO.setBuyerPhone("1234556894");
        orderDTO.setBuyerOpenId(BUYER_OPENID);
        //购物车
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail.setProductId("10001");
        orderDetail.setProductQuantity(9);
        orderDetail2.setProductId("10003");
        orderDetail2.setProductQuantity(8);
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);
        orderDTO.setOrderDetailList(orderDetails);
        OrderDTO orderDTO1 = service.create(orderDTO);
        log.info("创建订单成功:{}", orderDTO1);
    }

    @Test
    public void findOne() {
        OrderDTO one = service.findOne(ORDER_ID);
        log.info("查找一个order:{}", one);
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
        OrderDTO one = service.findOne(ORDER_ID);
        OrderDTO cancel = service.cancel(one);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), cancel.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO one = service.findOne(ORDER_ID);
        OrderDTO finish = service.finish(one);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), finish.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO one = service.findOne(ORDER_ID);
        OrderDTO finish = service.paid(one);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), finish.getPayStatus());
    }
}