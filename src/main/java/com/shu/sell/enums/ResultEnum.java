package com.shu.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h1>错误类型枚举</h1>
 *
 * @author yang
 * @date 2019/6/14 17:03
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {
    /**
     * 商品不存在
     */
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    /**
     * 库存不正确
     */
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    /**
     * 订单不存在
     */
    ORDER_NOT_EXIST(12, "订单不存在"),
    /**
     * 订单详情不存在
     */
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    /**
     * 订单状态不正确
     */
    ORDER_STATUS_ERROR(14, "订单状态不正确"),

    /**
     * 订单状态不正确
     */
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    /**
     * 订单状态不正确
     */
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ;
    private Integer code;
    private String message;
}
