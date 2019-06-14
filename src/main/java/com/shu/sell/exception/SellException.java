package com.shu.sell.exception;

import com.shu.sell.enums.ResultEnum;

/**
 * <h1>自定义异常</h1>
 *
 * @author yang
 * @date 2019/6/14 17:02
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    //private String message;

}
