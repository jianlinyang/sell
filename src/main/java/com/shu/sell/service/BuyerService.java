package com.shu.sell.service;

import com.shu.sell.dto.OrderDTO;

/**
 * <h1>买家service</h1>
 *
 * @author yang
 * @date 2019/6/27 16:06
 */
public interface BuyerService {
    /**
     * 查询一个订单
     *
     * @param openid  openid
     * @param orderId orderId;
     * @return {@link OrderDTO}
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid  openid
     * @param orderId orderId
     * @return {@link OrderDTO}
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
