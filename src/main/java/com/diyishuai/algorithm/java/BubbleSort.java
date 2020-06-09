package com.diyishuai.algorithm.java;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{1,5,2,9,0,-1,10};
        int[] array2 = new int[]{1,2,3,4,5,6,7};
        int[] result = sort(array2);
        for (Object obj: result) {
            System.out.print(obj+"\t");
        }
        System.out.println();

    }

    public static int[] sort(int[] array){
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
                if (isOk)
                    return array;
            }
        }
        return array;
    }


}
