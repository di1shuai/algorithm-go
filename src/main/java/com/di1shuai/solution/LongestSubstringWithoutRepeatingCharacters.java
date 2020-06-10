package com.di1shuai.solution;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author: Bruce
 * @date: 2020-01-21
 * @description:
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 *  输入: "abcabcbb"
 *  输出: 3
 *  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *  示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String[] strs = new String[]{"abcabcbb", "bbbbb", "pwwkew"};
        Arrays.stream(strs).forEach(s -> System.out.println(lengthOfLongestSubstring(s)));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(c, j + 1);
        }
        return ans;
    }

}
