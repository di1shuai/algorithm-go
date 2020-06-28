package com.di1shuai.algorithm.search;

import com.di1shuai.algorithm.sort.Sort;
import com.di1shuai.algorithm.sort.bubble.*;
import com.di1shuai.algorithm.sort.quick.QuickSortBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shea
 * @date: 2020/6/11
 * @description:
 */
public class SearchTest {

    public static void main(String[] args) {

        List<Search<Integer>> searchList = new ArrayList<>();
        searchList.add(new BinarySearch());

        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //有序
        Integer[] array2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};

        //===================

        Integer target = 1;
        Integer[] array = array1;

        searchList.forEach(search -> {
            System.out.println(search.getClass().getSimpleName());
            int index = search.search(target, array);
            if (index != -1) {
                System.out.println("index : " + index + " -> " + array[index]);
            }else {
                System.out.println("Not include");
            }
            System.out.println("=============");
        });
    }

}
