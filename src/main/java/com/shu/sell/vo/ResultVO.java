package com.shu.sell.vo;

import lombok.Data;

/**
 * <h1>http请求返回的最外层对象</h1>
 *
 * @author yang
 * @date 2019/6/14 12:24
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 返回的具体内容
     */
    private T data;

}
