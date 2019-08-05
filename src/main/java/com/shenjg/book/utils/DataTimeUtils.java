package com.shenjg.book.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DataTimeUtils
 *
 * @author shenjg
 * @date 2019/08/05
 */
public class DataTimeUtils {

    /**
     * 按照yyyy-MM-dd HH:mm:ss格式化时间日期
     *
     * @param localDateTime
     */
    public static void fotmat(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        localDateTime.format(formatter);
    }

    /**
     * 获取yyyyMMddHHmmss格式的日期字符串
     */
    public static String getDataTimeStr() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.now().format(formatter);
    }
}
