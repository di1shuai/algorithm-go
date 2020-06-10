package com.di1shuai.algorithm.sort.bubble;

import com.di1shuai.algorithm.sort.Sort;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description: 冒泡排序 边界版  比 标识版 粒度更细
 * 增加有序边界，来记录每轮最后发生交换的位置
 * 在交换位置之后，则是有序边界
 */
public class BubbleSortBorder implements Sort<Integer> {

    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        int border = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print("第" + (i + 1) + "轮:\t");
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    border = j;
                }
            }
            show(array);
            if (border == 0){
                return array;
            }
        }
        return array;
    }
}
