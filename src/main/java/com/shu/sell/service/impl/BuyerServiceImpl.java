package com.shu.sell.service.impl;

import com.shu.sell.dto.OrderDTO;
import com.shu.sell.enums.ResultEnum;
import com.shu.sell.exception.SellException;
import com.shu.sell.service.BuyerService;
import com.shu.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>BuyerService 实现</h1>
 *
 * @author yang
 * @date 2019/6/27 16:10
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    private final OrderService orderService;

    public BuyerServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("取消订单 查不到该订单orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if (!orderDTO.getBuyerOpenId().equalsIgnoreCase(openid)) {
            log.error("查询订单 订单的openid不一致 openid={},orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
