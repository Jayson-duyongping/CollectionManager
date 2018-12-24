package com.jayson.collection.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    /**
     * 获取格式日期字符串
     *
     * @param format
     * @return
     */
    public static String getTimeStr(String format) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 计算宽高比，保留两位小数
     *
     * @param width
     * @param height
     * @return
     */
    public static float calcuWHratio2(float width, float height) {
        float f = width / height;
        BigDecimal b = new BigDecimal(f);
        float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return f1;
    }
}
