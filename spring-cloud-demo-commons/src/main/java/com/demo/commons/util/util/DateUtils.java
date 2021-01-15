package com.demo.commons.util.util;

import java.text.SimpleDateFormat;

public class DateUtils {


    private static SimpleDateFormat dateFormat = new SimpleDateFormat();


    /**
     * 获取当前时间字符串
     *
     * @return string
     */
    public static String nowTime() {
        dateFormat.applyPattern("yyyyMMddhhmmss");
        return dateFormat.format(System.currentTimeMillis());
    }


}
