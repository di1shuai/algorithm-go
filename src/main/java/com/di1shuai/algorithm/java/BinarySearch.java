package com.di1shuai.algorithm.java;

/**
 * @author: Bruce
 * @date: 2019-09-02
 * @description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sort(1, data));
    }

    public static int sort(int value, int[] data) {
        int mid = data.length / 2;
        int i = 1;
        while (mid!=0 && mid!=data.length) {
            System.out.println((i++) +"轮,mid :  " + mid);
            if (value == data[mid]) {
                return mid;
            } else if (value > data[mid]) {
                mid = (mid + data.length) / 2;
            } else if (value < data[mid]) {
                mid /= 2;
            }
        }
        return -1;
    }


}
