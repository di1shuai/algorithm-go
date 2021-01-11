package com.di1shuai.algorithm.sort.shell.increment;

import com.di1shuai.algorithm.sort.shell.IncrementSequence;

/**
 * @author: Shea
 * @date: 2021/1/11
 * @description:
 *  1, 4, 13, 40, 121, 364, 1093, 3280, 9841 ...
 */
public class KnuthIncrementSequence implements IncrementSequence {


    @Override
    public int getHfromN(int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        return h;
    }

    @Override
    public int getHfromH(int h) {
        return h / 3;
    }


    public static void main(String[] args) {
        KnuthIncrementSequence knuthIncrementSequence = new KnuthIncrementSequence();
        knuthIncrementSequence.showIncrementSequence(10000);
    }
}
