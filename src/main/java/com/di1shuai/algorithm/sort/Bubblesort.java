package com.di1shuai.algorithm.sort;

import java.util.Arrays;

/**
 * @author: Shea
 * @date: 2019/9/20
 * @description:
 */
public class Bubblesort implements Sort<Integer>{

    public static void main(String[] args) {
        Sort<Integer> sort = new Bubblesort();

        Integer[] array = new Integer[]{1,5,2,9,0,-1,10};
        Integer[] array2 = new Integer[]{1,2,3,4,5,6,7};

        Arrays.stream(sort.sort(array)).forEach( n-> System.out.print(n+"\t"));
        System.out.println();

    }

    @Override
    public Integer[] sort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isOk = true;
            System.out.println("第"+(i+1)+"轮");
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j]>array[j+1]){
                    int x = array[j+1];
                    array[j+1] = array[j];
                    array[j] = x;
                    isOk = false;
                }
            }
            if (isOk) {
                return array;
            }
        }
        return array;
    }
}
