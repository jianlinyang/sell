package com.shu.sell.utils;

import java.util.Random;

/**
 * <h1>生成key</h1>
 *
 * @author yang
 * @date 2019/6/14 19:44
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     *
     * @return 时间+随机数
     */
    public synchronized static String genUniqueKey() {
        Random random = new Random();
        int i = random.nextInt(900000) + 100000;
        return String.valueOf(i) + System.currentTimeMillis();

    }
}
