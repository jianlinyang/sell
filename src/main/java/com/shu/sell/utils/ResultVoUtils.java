package com.shu.sell.utils;

import com.shu.sell.vo.ResultVO;

/**
 * <h1>返回结果工具类</h1>
 *
 * @author yang
 * @date 2019/6/14 13:29
 */
public class ResultVoUtils {
    public static ResultVO success(Object o) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(o);
        resultVO.setMessage("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String message) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
