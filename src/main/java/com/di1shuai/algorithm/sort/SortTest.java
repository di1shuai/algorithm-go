package com.di1shuai.algorithm.sort;

import com.di1shuai.algorithm.sort.Sort;
import com.di1shuai.algorithm.sort.bubble.*;
import com.di1shuai.algorithm.sort.quick.QuickSortBase;
import com.di1shuai.utils.DataUtil;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description:
 */
public class SortTest {

    public static void main(String[] args) {

        List<AbstractSort> sortList = new ArrayList<>();
        sortList.add(new BubbleSortBase());
        sortList.add(new BubbleSortFlag());
        sortList.add(new BubbleSortBorder());
        sortList.add(new CocktailSortBase());
        sortList.add(new CocktailSortFlag());
        sortList.add(new CocktailSortBorder());

//        sortList.add(new QuickSortBase());

        //基本有序
        Integer[] array3 = new Integer[]{1, 2, 3, 4, 5, 6, -1};

        //基本有序
        Integer[] array4 = new Integer[]{1, 2, 3, 4, 5, -1, 8, 7, 20, 10, 11, 40, 13, 14, 15, 16, 17, 18, 19, 20};

        sortsTest("随机数据测试",sortList,DataUtil.getArrayRandom());
        sortsTest("有序数据测试",sortList,DataUtil.getArraySerialized());

    }

    private static void sortsTest(String title,List<AbstractSort> sortList,Integer[] arraySource) {
        System.out.println("==========" + title + "=============" );
        TreeSet<AbstractSort> treeSet = new TreeSet<>();

        sortList.forEach(sort -> {
            long start = System.currentTimeMillis();
            System.out.println(sort.name);
            sort.sort(arraySource);
            long end = System.currentTimeMillis();
            long cost = end - start;
            System.out.println("花费时间 : " + cost);
            sort.cost = cost;
            treeSet.add(sort);
            System.out.println("=============");
        });
        System.out.println(title + "时间排行榜");
        treeSet.stream().forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
