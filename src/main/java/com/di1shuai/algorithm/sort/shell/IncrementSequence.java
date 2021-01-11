package com.di1shuai.algorithm.sort.shell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author: Shea
 * @date: 2021/1/11
 * @description:
 */
public interface IncrementSequence {


    int getHfromN(int n);

    int getHfromH(int h);

    /**
     * 展示增量序列
     * @param n  待排数组长度
     * @return  增量序列
     */
    default Integer[] showIncrementSequence(int n) {
        List<Integer> result = new ArrayList<>();
        int h = this.getHfromN(n);
        result.add(h);
        while (h > 1) {
            h = this.getHfromH(h);
            result.add(h);
        }
        Collections.reverse(result);
        System.out.println(this.getClass().getSimpleName() + " -> " + result);
        return result.toArray(new Integer[result.size()]);
    }

}
