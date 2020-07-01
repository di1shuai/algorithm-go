package com.di1shuai.algorithm.sort.bubble;

import com.di1shuai.algorithm.sort.AbstractSort;
import com.di1shuai.algorithm.sort.Sort;


/**
 * @author: Shea
 * @date: 2020/6/10
 * @description: 鸡尾酒排序 边界版
 * <p>
 * 加入边界，记录边界值变化
 * 加入标识，记录是否有变化
 * 正：排最大
 * 倒：排最小
 */
public class CocktailSortBorder extends AbstractSort {

    @Override
    public Integer[] sort(Integer[] arraySource) {
        Integer[] array = arraySource.clone();
//        int n = 0, nc = 0, ncs = 0;
        int left = 0, right = array.length - 1;
        int leftBorder = array.length - 1, rightBorder = 0;
        boolean ok = false;
        while (!ok) {
            ok = true;
//            ncs = 0;
//            System.out.print("第" + (++n) + "轮:\t");
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    rightBorder = i;
                    ok = false;
                }
//                ncs++;
            }
            right = rightBorder;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    leftBorder = i;
                    ok = false;
                }
//                ncs++;
            }
            left = leftBorder;
//            nc += ncs;
//            System.out.print("判断" + ncs + "次\t");
//            show(array);
        }
//        System.out.println("共判断" + nc + "次");
        return array;
    }
}
