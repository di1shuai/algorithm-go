package com.di1shuai.algorithm.sort.select;

import com.di1shuai.algorithm.sort.AbstractSort;

/**
 * @author: Shea
 * @date: 2020/6/30
 * @description:
 *  类似冒泡排序，区别在于只是记录需要交换的位置，每趟只进行一次交换
 *
 *
 */
public class SelectionSort extends AbstractSort {
    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        int maxIndex = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 1; j <= array.length - i - 1; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            swap(array, maxIndex, array.length - i - 1);
            maxIndex = 0;
        }


        showWithDefaultLimit(array);
        return array;
    }
}
