package com.di1shuai.utils;

/**
 * @author: Shea
 * @date: 2020/6/29
 * @description:
 */
public class TimeUtil {

    public static String costTimeString(long cost) {
        long minute = cost / (60 * 1000);
        long second = (cost - minute * 60 * 1000) / 1000;
        long millis = (cost - minute * 60 * 1000 - second * 1000);

        return (minute == 0 ? "" : minute + " m ") +
                (second == 0 ? "" : second + " s ") +
                millis + " ss ";
    }


}
