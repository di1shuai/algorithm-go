package com.di1shuai.structures.linearlist.sequential;

import java.util.Arrays;

/**
 * @author: Bruce
 * @date: 2020/6/9
 * @description:
 */
public class Array {

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = {1,2,3,4};

        Arrays.stream(arr1).forEach(i -> System.out.print(i+"\t"));
        System.out.println();
        Arrays.stream(arr2).forEach(i -> System.out.print(i+"\t"));

    }

}
