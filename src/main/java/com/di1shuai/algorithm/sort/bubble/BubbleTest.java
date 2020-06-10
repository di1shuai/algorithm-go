package com.di1shuai.algorithm.sort.bubble;

import com.di1shuai.algorithm.sort.Sort;

import java.util.ArrayList;
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
        sortList.add(new CocktailSortBase());
        sortList.add(new CocktailSortFlag());
        sortList.add(new CocktailSortBorder());

        Integer[] array = new Integer[]{1, 5, 2, 9, 0, -1, 10, 20, 80, 100, -5, -20, 3};

        Integer[] array2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};

        Integer[] array3 = new Integer[]{1, 2, 3, 4, 5, 6, -1};

        Integer[] array4 = new Integer[]{1, 2, 3, 4, 5, -1, 8, 7, 20, 10, 11, 40, 13, 14, 15, 16, 17, 18, 19, 20};

        sortList.forEach(sort -> {
            System.out.println(sort.getClass().getSimpleName());
            sort.sort(array4);
            System.out.println("=============");
        });
    }
}
