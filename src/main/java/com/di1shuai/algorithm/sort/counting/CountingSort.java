package com.di1shuai.algorithm.sort.counting;


import com.di1shuai.algorithm.sort.AbstractSort;

import java.util.Arrays;

/**
 * @author Shea
 * @date 2021-01-24
 * @description 计数排序
 * <p>
 * 1. 扫描获取最大值和最小值,创建长度为 Max - Min + 1 的数组
 * 2. 分桶
 * 3. 收集
 */
public class CountingSort extends AbstractSort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        if (array instanceof Integer[] a) {
            // 大小值 创建数组
            int max = a[0];
            int min = a[0];
            for (int i = 0; i < a.length; i++) {
                if (less(max, a[i])) {
                    max = a[i];
                }
                if (less(a[i], min)) {
                    min = a[i];
                }
            }
            Integer[] countArray = Arrays.stream(new int[max - min + 1]).boxed().toArray(Integer[]::new);
            // 分桶  index = value-min
            for (int i = 0; i < a.length; i++) {
                int index = a[i] - min;
                countArray[index]++;
            }
            // 收集
            int indexArray = 0;
            for (int i = 0; i < countArray.length; i++) {
                for (int j = countArray[i]; j > 0 ; j--) {
                    array[indexArray++] = min + i;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        countingSort.test();

    }

}
