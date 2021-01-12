package com.di1shuai.algorithm.sort.merge;

import com.di1shuai.algorithm.sort.AbstractSort;

import java.util.Arrays;

/**
 * @author: Shea
 * @date: 2020/6/30
 * @description: 归并排序
 */
public class MergeSort extends AbstractSort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        // 跳出条件
        if (array.length < 2) {
            return array;
        }
        // 计算中间点
        int mid = array.length >> 1;
        //左右切分
        Comparable[] leftArray = Arrays.copyOfRange(array, 0, mid);
        Comparable[] rightArray = Arrays.copyOfRange(array, mid, array.length);
        //合并已排序序列
        return merge(sort(leftArray), sort(rightArray));
    }

    private Comparable[] merge(Comparable[] left, Comparable[] right) {
        // init
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        Comparable[] result = new Comparable[left.length + right.length];

        // 合并左右序列
        while (leftIndex < left.length && rightIndex < right.length) {
            if (less(left[leftIndex], right[rightIndex])) {
                result[index] = left[leftIndex++];
            }else {
                result[index] = right[rightIndex++];
            }
            index++;
        }
        // 复制长序列部分
        while (leftIndex < left.length) {
            result[index++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[index++] = right[rightIndex++];
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.test();


    }

}
