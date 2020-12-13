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
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        return mergeSort(array, 0, array.length - 1);
    }

    private Integer[] mergeSort(Integer[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            Integer[] leftArray = mergeSort(array, left, mid);
            Integer[] rightArray = mergeSort(array, mid + 1, right);
            return merge(leftArray, rightArray);
        }
        return new Integer[]{array[mid]};
    }

    private Integer[] merge(Integer[] leftArray, Integer[] rightArray) {
        Integer[] result = new Integer[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length; i++) {
            while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] > rightArray[rightIndex]) {
                    result[i] = rightArray[rightIndex];
                    rightIndex++;
                } else if (leftArray[leftIndex].equals(rightArray[rightIndex])) {
                    result[i] = leftArray[leftIndex];
                    leftIndex++;
                    result[++i] = rightArray[rightIndex];
                    rightIndex++;
                } else {
                    result[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            if (leftIndex == leftArray.length - 1 && rightIndex < rightArray.length - 1) {
                result[i] = rightArray[rightIndex++];
            } else if (rightIndex == rightArray.length - 1 && leftIndex < leftArray.length - 1) {
                result[i] = leftArray[leftIndex++];
            }

        }
        return result;
    }

}
