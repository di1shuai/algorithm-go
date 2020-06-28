package com.di1shuai.algorithm.search;

/**
 * @author: Bruce
 * @date: 2019-09-02
 * @description:
 */
public class BinarySearch implements Search<Integer> {

    @Override
    public int search(Integer target, Integer[] arraySource) {
        Integer[] data = arraySource.clone();
        int mid = data.length / 2;
        int i = 1;
        while (mid != 0 && mid != data.length) {
            System.out.println((i++) + "轮,mid :  " + mid);
            if (target.equals(data[mid])) {
                return mid;
            } else if (target > data[mid]) {
                mid = (mid + data.length) / 2;
            } else if (target < data[mid]) {
                mid /= 2;
            }
        }
        return -1;
    }
}
