package com.shu.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * <h1>订单状态枚举</h1>
 *
 * @author yang
 * @date 2019/6/14 14:33
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    /**
     * 新订单
     */
    NEW(0, "新订单"),
    /**
     * 完结
     */
    FINISHED(1, "完结"),
    /**
     * 已取消
     */
    CANCEL(2, "已取消");
    private Integer code;
    private String message;
}
