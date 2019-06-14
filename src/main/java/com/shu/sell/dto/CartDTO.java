package com.shu.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>购物车</h1>
 *
 * @author yang
 * @date 2019/6/14 19:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 数量
     */
    private Integer productQuantity;
}
