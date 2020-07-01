package com.di1shuai.algorithm.sort.bubble;

import com.di1shuai.algorithm.sort.AbstractSort;
import com.di1shuai.algorithm.sort.Sort;


/**
 * @author: Shea
 * @date: 2020/6/10
 * @description: 鸡尾酒排序 边界版
 * <p>
 * 加入边界记录
 * 正：排最大
 * 倒：排最小
 */
public class CocktailSortBase extends AbstractSort {
    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
//        int n = 0, nc = 0, ncs = 0;
        int left = 0, right = array.length - 1;

        while (left < right) {
//            System.out.print("第" + (++n) + "轮:\t");
//            ncs = 0;
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
//                ncs++;
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
//                ncs++;
            }
            left++;
//            nc += ncs;
//            System.out.print("判断" + ncs + "次\t");
//            show(array);
        }
//        System.out.println("共判断" + nc + "次");
        return array;
    }

}
