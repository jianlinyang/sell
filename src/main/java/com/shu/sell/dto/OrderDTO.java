package com.shu.sell.dto;

import com.shu.sell.dataobject.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <h1>Order数据传输对象</h1>
 *
 * @author yang
 * @date 2019/6/14 16:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家OpenId
     */
    private String buyerOpenId;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态,默认0为新下单
     */
    private Integer orderStatus;
    /**
     * 支付状态,默认0为未支付
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * {@link OrderDetail}
     */
    private List<OrderDetail> orderDetailList;

}
