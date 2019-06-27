package com.shu.sell.exception;

import com.shu.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * <h1>自定义异常</h1>
 *
 * @author yang
 * @date 2019/6/14 17:02
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    //private String message;

}
