package com.di1shuai.algorithm.sort.bubble;

import com.di1shuai.algorithm.sort.AbstractSort;
import com.di1shuai.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * @author: Shea
 * @date: 2019/9/20
 * @description: 冒泡排序 标识位版
 * 增加标识位，来标识每轮排序是否有序
 * 若有序，则结束排序
 */
public class BubbleSortFlag extends AbstractSort {



    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        for (int i = 0; i < array.length; i++) {
            boolean isOk = true;
//            System.out.print("第" + (i + 1) + "轮:\t");
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isOk = false;
                }
            }
//            show(array);
            if (isOk) {
                showWithDefaultLimit(array);
                return array;
            }
        }
        showWithDefaultLimit(array);
        return array;
    }
}
