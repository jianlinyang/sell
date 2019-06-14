package com.shu.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h1>支付状态枚举</h1>
 *
 * @author yang
 * @date 2019/6/14 14:33
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {
    /**
     * 未支付
     */
    WAIT(0, "未支付"),
    /**
     * 支付成功
     */
    SUCCESS(1, "支付成功");
    private Integer code;
    private String message;
}
