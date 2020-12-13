package com.di1shuai.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Shea
 * @date: 2020/7/7
 * @description:
 */
public class Niuke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);


        String[] initStr = sc.nextLine().split(" ");
        int[] init = Arrays.stream(initStr).mapToInt( s -> Integer.parseInt(s)).toArray();
        Data data = new Data(init);
        List<Integer> list = new ArrayList();
        while (sc.hasNextLine()){
            for (int i = 0; i < m; i++) {
                String[] lineStr = sc.nextLine().split(" ");
                String c = lineStr[0];
                int fromOrIndex = Integer.parseInt(lineStr[1]);
                int toOrValue = Integer.parseInt(lineStr[2]);
                if ("Q".equals(c)) {
                    list.add(data.getMax(Math.min(fromOrIndex - 1, toOrValue - 1),Math.max(fromOrIndex - 1, toOrValue - 1)));
                } else if ("U".equals(c)) {
                    data.update(fromOrIndex - 1, toOrValue);
                } else {
                    System.out.println("Error");
                }
            }
            list.forEach(System.out::println);
        }

    }

    static class Data {
        int[] array;

        public Data(int[] array) {
            this.array = array;
        }

        public Integer getMax(int from, int to) {
            int max = 0;
            for (int i = from; i <= to; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }


        public void update(int index, int value) {
            array[index] = value;
        }

    }


}
