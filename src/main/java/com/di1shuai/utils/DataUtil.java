package com.di1shuai.utils;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: Shea
 * @date: 2020/6/29
 * @description:
 */
public class DataUtil {

    private static Integer size = 40 * 1000;

    //无序
    private static Integer[] arrayRandom;

    //有序
    private static Integer[] arraySerialized;

    static {
        arrayRandom = Stream.generate(
                new Supplier<Integer>() {
                    Random random = new Random();

                    @Override
                    public Integer get() {
                        return random.nextInt(size);
                    }
                }
        ).limit(size).toArray(Integer[]::new);

        arraySerialized = Stream.generate(
                new Supplier<Integer>() {
                    Integer i = 0;

                    @Override
                    public Integer get() {
                        return i++;
                    }
                }
        ).limit(size).toArray(Integer[]::new);
    }


    public static Integer[] getArrayRandom() {
        return arrayRandom;
    }

    public static Integer[] getArraySerialized() {
        return arraySerialized;
    }
}
