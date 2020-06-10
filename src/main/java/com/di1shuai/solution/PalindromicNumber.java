package com.di1shuai.solution;

public class PalindromicNumber {


    public static void main(String[] args) {
       print(121);
       print(-121);
       print(2345432);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(02200);
       print(309);


    }

    public static void print(int x){
        System.out.println(x + " -> "+ isPalindrome(x));
    }


    public static boolean isPalindrome(int x) {
        String numberStr = (x+"").toString();
        char[] chars = numberStr.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
