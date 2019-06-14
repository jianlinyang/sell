package com.shu.sell.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * <h1>订单详情表</h1>
 *
 * @author yang
 * @date 2019/6/14 14:43
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    /**
     * id
     */
    @Id
    private String detailId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品数量
     */
    private Integer productQuantity;
    /**
     * 商品小图
     */
    private String productIcon;
}
