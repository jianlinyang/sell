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

    PRODUCT_STOCK_ERROR(11,"库存不正确");
    private Integer code;
    private String message;
}
