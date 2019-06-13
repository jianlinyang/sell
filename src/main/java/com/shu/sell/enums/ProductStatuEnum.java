package com.shu.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h1>商品枚举状态</h1>
 *
 * @author yang
 * @date 2019/6/13 23:21
 */
@Getter
@AllArgsConstructor
public enum ProductStatuEnum {
    /**
     * 商品状态
     */
    UP(0, "在架"),
    DOWN(1, "下架");
    private Integer code;
    private String message;
}
