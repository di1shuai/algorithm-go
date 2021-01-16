package com.di1shuai.algorithm.sort;

import com.di1shuai.Base;

import java.util.Arrays;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description:
 */
public interface Sort<T extends Comparable> extends Base<T> {


    T[] sort(T[] array);

    default T[] sortFlow(T[] arraySource){
        T[] array = arraySource.clone();
        T[] sort = sort(array);
        assert check(sort) : "Sort is error";
        showWithDefaultLimit(sort);
        return sort;
    }

    default boolean check(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }






}
