package com.di1shuai.algorithm.sort.merge;

import com.di1shuai.algorithm.sort.AbstractSort;

/**
 * @author: Shea
 * @date: 2020/6/30
 * @description: 归并排序
 *
 *
 *
 *
 */
public class MergeSort extends AbstractSort {

    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();



        showWithDefaultLimit(array);
        return array;
    }

}
