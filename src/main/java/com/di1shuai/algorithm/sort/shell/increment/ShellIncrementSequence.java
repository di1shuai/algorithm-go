package com.di1shuai.algorithm.sort.shell.increment;

import com.di1shuai.algorithm.sort.shell.IncrementSequence;

/**
 * @author: Shea
 * @date: 2021/1/11
 * @description:
 */
public class ShellIncrementSequence implements IncrementSequence {


    @Override
    public int getHfromN(int n) {
        return n / 2;
    }

    @Override
    public int getHfromH(int h) {
        return h / 2;
    }

    public static void main(String[] args) {
        IncrementSequence incrementSequence = new ShellIncrementSequence();
        incrementSequence.showIncrementSequence(10000);
    }

}
