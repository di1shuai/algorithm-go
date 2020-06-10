package com.di1shuai.algorithm.sort.bubble;

import com.di1shuai.algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description:
 */
public class BubbleTest {

    public static void main(String[] args) {

        List<Sort<Integer>> sortList = new ArrayList<>();
        sortList.add(new BubbleSortBase());
        sortList.add(new BubbleSortFlag());
        sortList.add(new BubbleSortBorder());

        Integer[] array = new Integer[]{1, 5, 2, 9, 0, -1, 10};

        Integer[] array2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        sortList.forEach(sort -> {
            System.out.println(sort.getClass().getSimpleName());
            sort.sort(array);
            System.out.println("=============");
        });
    }
}
