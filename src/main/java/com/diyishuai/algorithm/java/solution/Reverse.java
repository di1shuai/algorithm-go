package com.diyishuai.algorithm.java.solution;

public class Reverse {

    public static void main(String[] args) {

    }

    public static int reverse(int x){
        boolean isPositive = x>0?true:false;
        String numStr = x+"";
        if (!isPositive){
            numStr = numStr.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = numStr.length()-1; i >=0; i--) {
            sb.append(numStr.charAt(i));
        }
        if (!isPositive)
            sb.insert(0,"-");
        int result = 0;
        try {
            result = new Integer(sb.toString()).intValue();
        }catch (Exception e){

        }

        return result;
    }

}
