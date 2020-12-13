package com.di1shuai.solution;

import java.util.HashMap;

/**
 * @author: Shea
 * @date: 2020/7/6
 * @description:
 */
public class CountNums {


    //leetcode submit region begin(Prohibit modification and deletion)
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int maxValue = nums[0];
        for (int i = 0; i < nums.length >> 2; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
                if (count > map.get(maxValue)) {
                    maxValue = nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i = nums.length >> 2; i < nums.length && i < nums.length / 2 + map.get(maxValue); i++) {

        }

        if (map.get(maxValue) > nums.length >> 2) {
            return maxValue;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 3};
        System.out.println(majorityElement(array));


    }

}
