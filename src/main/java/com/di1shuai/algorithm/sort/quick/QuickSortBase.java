package com.di1shuai.algorithm.sort.quick;

import com.di1shuai.algorithm.sort.Sort;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description: 快速排序
 * 定义一个基准
 * <p>
 * 左边找一个小于 右边找一个大于  交换
 *
 * 平均时间复杂度 nlogn
 * 最坏运行时间为 n^2
 *
 */
public class QuickSortBase implements Sort<Integer> {

    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        quickSort(array, 0, array.length - 1);
        show(array);
        return array;
    }

    private Integer[] quickSort(Integer[] array, int left, int right) {

        int start = left;
        int end = right;
        int pivot = array[left];
        while (start < end) {
            //从后往前
            while (start < end && array[end] >= pivot) {
                end--;
            }
            //从前往后
            while (start < end && array[start] < pivot) {
                start++;
            }
            if (start < end) {
                swap(array, start, end);
            }
        }
        if (start > left) {
            quickSort(array, left, start - 1);
        }
        if (end < right) {
            quickSort(array, end + 1, right);
        }
        return array;
    }


}

