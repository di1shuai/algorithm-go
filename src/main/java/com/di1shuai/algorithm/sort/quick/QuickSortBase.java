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

        int start = left;
        int end = right;
        int pivot = array[left];
        while (start < end) {
            //从后往前
            while (start < end && array[end] > pivot) {
                end--;
            }
            //从前往后
            while (start < end && array[start] < pivot) {
                start++;
            }
            if (array[start].equals(array[end]) && start < end) {
                start++;
            } else {
                swap(array, start, end);
            }
        }
        if (start - 1 > left) {
            quickSort(array, left, start - 1);
        }
        if (end + 1 < right) {
            quickSort(array, end + 1, right);
        }
        return array;
    }


}

