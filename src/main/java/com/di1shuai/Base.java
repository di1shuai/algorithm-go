package com.di1shuai;

import java.util.Arrays;

/**
 * @author Shea
 * @date 2021-01-15
 * @description
 */
public interface Base<T extends Comparable> {

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

}
