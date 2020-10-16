package com.ming.exercise.leetcode.string;

/**
 * @Description LongestCommonPrefix
 * @Author Administrator
 * @Date 2020/10/15 22:25 2020
 *
 *  14 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 *  如果不存在公共前缀，返回空字符串 ""。
 *
 *  示例 1:
 *
 *  输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 *
 *  示例 2:
 *
 *  输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 获取0位置的字符串
        String ans = strs[0];
        // 从1开始循环比较
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 和第一个字符串进行比较
            for (; j < ans.length() && j < strs[i].length(); j++) {
                // 不相等 跳出当前内循环
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            // 对字符串进行截取 截取到相同字符串的位置
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }

}
