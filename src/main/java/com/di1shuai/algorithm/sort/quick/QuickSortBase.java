package com.di1shuai.algorithm.sort.quick;

import com.di1shuai.algorithm.sort.AbstractSort;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description: 快速排序
 * 定义一个基准
 * <p>
 * 左边找一个小于 右边找一个大于  交换
 * <p>
 * 平均时间复杂度 nlogn
 * 最坏运行时间为 n^2
 */
public class QuickSortBase extends AbstractSort {

    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private Integer[] quickSort(Integer[] array, int left, int right) throws StackOverflowError {

        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return array;
    }


    private int partition(Integer[] array, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index - 1);
        return index - 1;
    }


}

