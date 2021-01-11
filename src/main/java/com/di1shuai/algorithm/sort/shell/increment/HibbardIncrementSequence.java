package com.di1shuai.algorithm.sort.shell.increment;

import com.di1shuai.algorithm.sort.shell.IncrementSequence;

/**
 * @author: Shea
 * @date: 2021/1/11
 * @description: 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191 ...
 */
public class HibbardIncrementSequence implements IncrementSequence {


    @Override
    public int getHfromN(int n) {
        int h = 1;
        while (h < (n - 1) / 2) {
            h = 2 * h + 1;
        }
        return h;
    }

    @Override
    public int getHfromH(int h) {
        return (h - 1) / 2;
    }


    public static void main(String[] args) {
        HibbardIncrementSequence hibbardIncrementSequence = new HibbardIncrementSequence();
        hibbardIncrementSequence.showIncrementSequence(10000);
    }

}
