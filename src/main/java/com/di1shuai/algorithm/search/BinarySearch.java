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
        int low = 0;
        int high = data.length-1;
        int mid = getMid(low, high);
        int i = 1;
        while (low <= high) {
            System.out.println((i++) + "轮,mid :  " + mid);
            if (target.equals(data[mid])) {
                return mid;
            } else if (target > data[mid]) {
                low = mid + 1;
                mid = getMid(low,high);
            } else {
                high = mid - 1;
                mid = getMid(low,high);
            }
        }
        return -1;
    }

    private int getMid(int low, int high) {
        return (low + high) >>> 1;
    }


}
