package com.di1shuai.algorithm.sort;

import java.util.Arrays;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description:
 */
public interface Sort<T extends Comparable> {


    T[] sort(T[] array);

    default T[] sortFlow(T[] arraySource){
        T[] array = arraySource.clone();
        sort(array);
        assert check(array) : "Sort is error";
        showWithDefaultLimit(array);
        return array;
    }

    default boolean check(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }



    default void show(T[] array) {
        Arrays.stream(array).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }

    default void showWithLimit(T[] array, long limit) {
        Arrays.stream(array).limit(limit).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }

    default void showWithDefaultLimit(T[] array) {
        long limit = 100L;
        Arrays.stream(array).limit(limit).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }

    default boolean less(Comparable one, Comparable other) {
        if (one.compareTo(other) < 0){
            return true;
        }
        return false;
    }

    default void swap(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


}
