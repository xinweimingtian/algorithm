package com.ming.exercise.leetcode.string.lengthsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description LengthOfLongestSubstring
 * @Author Administrator
 * @Date 2020/5/26 22:32 2020
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  示例 1:
 *
 *  输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 *  示例 2:
 *
 *  输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 *  示例 3:
 *
 *  输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String ss = "abccbaabcefgabc";
        System.out.println(lengthOfLongestSubstring(ss));
    }

    /**
     *  方法一
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        int size = 0;
        if (str == null || str.length() < 1) {
            return size;
        }
        // 定义双指针 进行滑动窗口维护
        int left = 0; // 左边维持的窗口指针
        int right = 0; // 向右移动的指针
        // 定义数组，按照ASCII码为下坐标存储在str中出现的位置+1
        int[] arr = new int[128];
        // 获取字符串的char ASCII码
        int in;

        // 循环判断 左指针小于字符串长度
        while (right < str.length()) {
            // 获取左指针当前位置的char
            in = str.charAt(right);

            // 判断char是否出现过 如果in 位置存储的值 大于 left
            // 那就证明 已经重复出现 然后移动left到in的值的位置
            if (arr[in] > left) {
                left = arr[in];
            }

            // 存储in的值
            arr[in] = right + 1;
            // 进行判断 右指针-左指针+1 就是最长子串长度
            size = size > right - left + 1 ? size : right - left + 1;
            // 右指针移动
            right++;
        }
        return size;
    }

    /**
     * 方法二
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring1(String str) {
        int size = 0; //总子串长度
        if (str == null || str.length() < 1) {
            return size;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 初始化左指针和右指针，并遍历字符串
        for(int left = 0, right = 0; right < str.length(); right++){
            // 判断右指针指向的字符是否出现过
            if(hashMap.containsKey(str.charAt(right))){
                // 确定左指针的位置
                left = Math.max(left, hashMap.get(str.charAt(right))+1);
            }
            // 对于第一次出现的字符，保存该字符的位置；对于多次出现的字符，更新该字符出现的位置
            hashMap.put(str.charAt(right), right);
            // 更新窗口的大小，保存最大的窗口大小
            size = Math.max(size, right-left+1);
        }
        return size;
    }

}
