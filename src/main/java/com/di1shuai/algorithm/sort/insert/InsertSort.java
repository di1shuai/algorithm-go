package com.di1shuai.algorithm.sort.insert;

import com.di1shuai.algorithm.sort.AbstractSort;

/**
 * @author: Shea
 * @date: 2020/6/30
 * @description: 插入排序
 * 构建局部有序序列，每次将当前index的元素，依次比较交换到相应位置
 */
public class InsertSort extends AbstractSort {

    @Override
    public Integer[] sort(Integer[] arraySource) {
        if (arraySource.length<=1){
            show(arraySource);
            return arraySource;
        }
        Integer[] array = arraySource.clone();
        for (int i = 1; i <= array.length - 1; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (array[j] > array[j+1]){
                    swap(array,j,j+1);
                }else {
                    break;
                }
            }
        }

        showWithDefaultLimit(array);
        return array;
    }

}
