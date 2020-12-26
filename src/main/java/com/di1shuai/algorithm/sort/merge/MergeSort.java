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
        return mergeSort(array, 0, array.length - 1);
    }

    private Comparable[] mergeSort(Comparable[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            Comparable[] leftArray = mergeSort(array, left, mid);
            Comparable[] rightArray = mergeSort(array, mid + 1, right);
            return merge(leftArray, rightArray);
        }
        return new Comparable[]{array[mid]};
    }

    private Comparable[] merge(Comparable[] leftArray, Comparable[] rightArray) {
        Comparable[] result = new Integer[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length; i++) {
            while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (less(rightArray[rightIndex], leftArray[leftIndex])) {
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
