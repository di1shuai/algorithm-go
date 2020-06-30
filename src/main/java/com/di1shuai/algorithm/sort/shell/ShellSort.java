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
    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
        if (array.length <= 1) {
            return array;
        }

        //控制增量
        for (int k = array.length / 2; k >= 1; k /= 2) {
            //控制序列
            for (int i = 0; i < k; i++) {
                //序列内插入排序
                //控制序列内 有序范围
                for (int j = i + k; j <= array.length - 1; j += k) {
                    //控制序列内下标
                    for (int l = j - k; l >= 0; l -= k) {
                        if (array[l] > array[l+k]) {
                            swap(array, l, l+k);
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        showWithDefaultLimit(array);
        return array;
    }
}
