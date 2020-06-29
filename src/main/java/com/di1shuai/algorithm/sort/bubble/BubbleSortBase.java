package com.di1shuai.algorithm.sort.bubble;

import com.di1shuai.algorithm.sort.AbstractSort;
import com.di1shuai.algorithm.sort.Sort;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description: 冒泡排序 基础版
 * 稳定排序，双层循环
 */
public class BubbleSortBase extends AbstractSort{

    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        for (int i = 0; i < array.length; i++) {
//            System.out.print("第" + (i + 1) + "轮:\t");
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
//            show(array);
        }
        showWithDefaultLimit(array);
        return array;
    }

}
