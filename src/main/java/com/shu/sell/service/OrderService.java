package com.shu.sell.service;

import com.shu.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <h1>Order服务</h1>
 *
 * @author yang
 * @date 2019/6/14 16:41
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderDTO {@link OrderDTO}
     * @return {@link OrderDTO}
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     *
     * @param orderId id
     * @return {@link OrderDTO}
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     *
     * @param buyOpenId id
     * @param pageable  {@link Pageable}
     * @return {@link OrderDTO}
     */
    Page<OrderDTO> findList(String buyOpenId, Pageable pageable);

    /**
     * 取消订单
     *
     * @param orderDTO {@link OrderDTO}
     * @return {@link OrderDTO}
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     *
     * @param orderDTO {@link OrderDTO}
     * @return {@link OrderDTO}
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     *
     * @param orderDTO {@link OrderDTO}
     * @return {@link OrderDTO}
     */
    OrderDTO paid(OrderDTO orderDTO);
}
