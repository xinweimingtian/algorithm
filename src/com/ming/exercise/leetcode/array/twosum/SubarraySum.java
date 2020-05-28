package com.ming.exercise.leetcode.array.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description SubarraySum
 * @Author weihuiming
 * @Date
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 *  示例 1 :
 *
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 *
 *  说明 :
 *
 *
 *  数组的长度为 [1, 20,000]。
 *  数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            // 有默认的值返回默认的值 没有返回 0
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }


    // 前缀和的应用
    /**
     *
     * 输入n个数的数列，所有相邻m数的和有n-m+1个，求其中的最小值。
     * 比如：
     * 数组为：[10, 4, 1, 5, 5, 2]
     * m为：3
     * 结果为：10
     * */
    /**
     * 获取最小值
     *
     * @param src 原数组
     * @param m   相邻数
     * @return 最小值
     */
    private int minM(int[] src, int m) {
        if (m <= 0) {
            return 0;
        }
        int[] prefixSum = new int[src.length];
        for (int i = 0; i < prefixSum.length; i++) {
            if (i == 0) {
                prefixSum[i] = src[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + src[i];
            }
        }
        int first = prefixSum[m - 1], result = first;
        for (int i = m; i < prefixSum.length; i++) {
            int current = prefixSum[i] - prefixSum[i - m];
            result = current > result ? result : current;
        }

        return result;
    }
}
