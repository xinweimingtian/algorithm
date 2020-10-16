package com.ming.exercise.leetcode.string;

/**
 * @Description LongestPalindrome
 * @Author weihuiming
 * @Date 2020/10/16
 *
 *  5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *  示例 1：
 *
 *  输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 *
 *  示例 2：
 *
 *  输入: "cbbd"
 * 输出: "bb"
 *
 *
 */
public class LongestPalindrome {


    /**
     * 使用动态规划记录回文串  优化中心扩散
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) {
            return s;
        }

        int strLen = s.length();
        int maxStart = 0; // 最长回文串的起点
        int maxEnd = 0; // 最长回文串的终点
        int maxLen = 1; // 最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     *  中心扩散 双指针
     * @param s
     * @return
     */
    public String longestPalindromeTO(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int strLen = s.length();
        int left = 0;   // 左指针
        int right = 0;  // 右指针
        int len = 1;    // 回文字符串长度
        int maxStart = 0; // 回文字符串起始位置
        int maxLen = 0; // 回文字符串最大长度

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

}
