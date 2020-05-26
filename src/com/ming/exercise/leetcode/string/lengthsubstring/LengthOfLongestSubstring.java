package com.ming.exercise.leetcode.string.lengthsubstring;

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
        String ss = "abba";
        System.out.println(lengthOfLongestSubstring(ss));
    }

    public static int lengthOfLongestSubstring(String str) {
        int size = 0;
        int[] dict = new int[128]; //记录ASCII 码字符出现的位置，以字符作为下坐标
        int left = 0; // 第一个指针字符开始 如果重复 移动指针到重复位置
        int right = 0; // 每次都移动比较的指针  直到字符串最大长度
        int i = 0; // ASCII码数组中字符位置  dict[i]存储 str中i字符的位置 从1开始

        while (right < str.length()) {
            i = str.charAt(right); // 获取右指针指向的字符串ASCII码
            if (dict[i] > left) { // 如果dict[i] 存储的str位置大于左指针  那就证明 字符右侧有相同的
                left = dict[i];  // 获取上一次相同字符 出现的位置 right-left+1  就是最长子串的长度
            }
            dict[i] = right + 1; //  从1开始  存储出现字符的位置
            size = (size > right - left + 1) ? size : right - left + 1; // 获取最大子串长度
            right++; // 右指针移动
        }
        return size;
    }

}
