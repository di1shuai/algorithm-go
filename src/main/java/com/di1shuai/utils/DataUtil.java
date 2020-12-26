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

    //无序
    private static Comparable[] arrayRandom;

    //有序
    private static Comparable[] arraySerialized;

    public static void generateData(Integer size){
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


    public static Comparable[] getArrayRandom() {
        return arrayRandom;
    }

    public static Comparable[] getArraySerialized() {
        return arraySerialized;
    }


    public static void main(String[] args) {
        Comparable[] arrayRandom = DataUtil.getArrayRandom();
        System.out.println(arrayRandom.getClass().getName());
    }

}
