package com.di1shuai.algorithm.sort;

import java.util.Arrays;

/**
 * @author: Shea
 * @date: 2020/7/1
 * @description:
 */
public class ArraysSort extends AbstractSort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        Arrays.sort(array);
        return array;
    }
}
