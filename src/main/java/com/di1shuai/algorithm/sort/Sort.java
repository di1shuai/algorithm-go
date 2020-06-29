package com.di1shuai.algorithm.sort;

import java.util.Arrays;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description:
 */
public interface Sort<T> {


    T[] sort(T[] arraySource);

    default void show(T[] array){
        Arrays.stream(array).forEach(n-> System.out.print(n+"\t"));
        System.out.println();
    }

    default void showWithLimit(T[] array,long limit){
        Arrays.stream(array).limit(limit).forEach(n-> System.out.print(n+"\t"));
        System.out.println();
    }

    default void showWithDefaultLimit(T[] array){
        long limit = 1000L;
        Arrays.stream(array).limit(limit).forEach(n-> System.out.print(n+"\t"));
        System.out.println();
    }

    default void swap(T[] array,int index1,int index2){
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


}
