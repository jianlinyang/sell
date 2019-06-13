package com.shu.sell.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * <h1>商品</h1>
 *
 * @author yang
 * @date 2019/6/13 22:33
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductInfo {
    @Id
    private String productId;

    /**
     * 名字
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 描述
     */
    private Integer productStock;
    /**
     * 商品图标
     */
    private String productIcon;
    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品状态0正常1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
