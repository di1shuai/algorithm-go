package com.diyishuai.algorithm.java.solution;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            int compltement = target - nums[i]; 
            if(map.containsKey(compltement) && map.get(compltement)!=i){
                return new int[]{i,map.get(compltement)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(twoSum(nums,9));
    }

}