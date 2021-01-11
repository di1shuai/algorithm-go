package com.di1shuai.algorithm.sort.shell;

import com.di1shuai.algorithm.sort.AbstractSort;

/**
 * @author: Shea
 * @date: 2020/6/30
 * @description: 希尔排序
 * 希尔排序是对插入排序的改进，也是第一批突破O(n^2)的算法之一，
 * <p>
 * <p>
 * <p>
 * 会将序列分为k个增量为k的子序列，在增量序列内插入排序
 * 增量/2  再进行排序
 * 直至增量为1后，对已经基本有序的数列做插入排序
 */
public class ShellSort extends AbstractSort {

    private IncrementSequence incrementSequence;


    public ShellSort(IncrementSequence incrementSequence) {
        this.incrementSequence = incrementSequence;
        name = name + "_" + incrementSequence.getClass().getSimpleName();
    }

    @Override
    public Comparable[] sort(Comparable[] array) {
        if (array.length <= 1) {
            return array;
        }
        int n = array.length;
        int h = incrementSequence.getHfromN(n);
        // 将数组变为h有序
        while (h >= 1) {
            // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    swap(array, j, j - h);
                }
            }
            h = incrementSequence.getHfromH(h);
        }

        return array;
    }


}
