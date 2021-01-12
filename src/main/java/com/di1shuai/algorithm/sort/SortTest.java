package com.di1shuai.algorithm.sort;

import com.di1shuai.algorithm.sort.bubble.*;
import com.di1shuai.algorithm.sort.insert.InsertSort;
import com.di1shuai.algorithm.sort.merge.MergeSort;
import com.di1shuai.algorithm.sort.quick.QuickSortBase;
import com.di1shuai.algorithm.sort.select.SelectionSort;
import com.di1shuai.algorithm.sort.shell.ShellSort;
import com.di1shuai.algorithm.sort.shell.increment.HibbardIncrementSequence;
import com.di1shuai.algorithm.sort.shell.increment.KnuthIncrementSequence;
import com.di1shuai.algorithm.sort.shell.increment.ShellIncrementSequence;
import com.di1shuai.utils.DataUtil;
import com.di1shuai.utils.TimeUtil;

import java.util.*;

/**
 * @author: Shea
 * @date: 2020/6/10
 * @description:
 */
public class SortTest {

    public static final int size = 1 << 10 << 5;

    static {
        DataUtil.generateData(size);
    }

    public static void main(String[] args) {
        List<AbstractSort> sortList = new ArrayList<>();
        // n^2
        O_nn(sortList);
        // nlog2n
        O_nlogn(sortList);

        //基本有序
        Comparable[] array3 = new Integer[]{1, 2, 3, 4, 5, 6, -1};

        //基本有序
        Comparable[] array4 = new Integer[]{1, 2, 3, 4, 5, -1, 8, 7, 20, 10, 11, 40, 13, 14, 15, 16, 17, 18, 19, 20};

        sortsTest("随机数据测试", sortList, DataUtil.getArrayRandom());
//        sortsTest("有序数据测试", sortList, DataUtil.getArraySerialized());

    }

    private static void O_nlogn(List<AbstractSort> sortList) {
        //Shell
        sortList.add(new ShellSort(new ShellIncrementSequence()));
        sortList.add(new ShellSort(new KnuthIncrementSequence()));
        sortList.add(new ShellSort(new HibbardIncrementSequence()));

        //Quick
        sortList.add(new QuickSortBase());

        //Merge
//        sortList.add(new MergeSort());
        sortList.add(new ArraysSort());
    }

    private static void O_nn(List<AbstractSort> sortList) {
        sortList.add(new BubbleSortBase());
        sortList.add(new BubbleSortFlag());
        sortList.add(new BubbleSortBorder());
        sortList.add(new CocktailSortBase());
        sortList.add(new CocktailSortFlag());
        sortList.add(new CocktailSortBorder());

        sortList.add(new SelectionSort());

        sortList.add(new InsertSort());
    }

    private static void sortsTest(String title, List<AbstractSort> sortList, Comparable[] arraySource) {
        System.out.println("==========" + title + "=============");
        TreeSet<AbstractSort> treeSet = new TreeSet<>();
        System.out.println("原始数据\t size:" + arraySource.length);
        Arrays.stream(arraySource).limit(100).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
        System.out.println("-------------------");
        sortList.forEach(sort -> {
            try {
                // 输出算法名称
                System.out.println(sort.name);

                // 开始计时
                long start = System.currentTimeMillis();
                Comparable[] sortResult = sort.sortFlow(arraySource);
                // 结束计时
                long end = System.currentTimeMillis();
                long cost = end - start;
                System.out.println("花费时间 : " + TimeUtil.costTimeString(cost) + " \t 结果 : " + sort.check(sortResult));

                //算法耗时排序
                sort.cost = cost;
                treeSet.add(sort);
                System.out.println("----  ------   ----  ----  ----   ---");
            } catch (StackOverflowError error) {
                System.err.println(sort.name + "  -> 递归栈溢出:StackOverflowError");
            }
        });
        System.out.println(title + "时间排行榜");
        System.out.printf("%-40s","name");
        System.out.printf("%10s","cost");
        System.out.printf("%15s","compareCount");
        System.out.printf("%15s","swapCount");
        System.out.println();
        System.out.println("-------------------");
        treeSet.stream().forEach(sort -> {
            System.out.printf("%-40s", sort.name);
            System.out.printf("%10s", sort.cost);
            System.out.printf("%15s", sort.compareCount);
            System.out.printf("%15s", sort.swapCount);
            System.out.println();
        });
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
