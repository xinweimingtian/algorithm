package com.ming.exercise.leetcode.array.twosum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TwoSortSum
 * @Author weihuiming
 * @Date
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSortSum {

    public static void main(String[] args) {
        int[] ints = new int[]{2, 2, 7, 11, 15};
        int[] ss = twoSortSum(ints, 4);
        System.out.println(Arrays.toString(ss));
    }


    public static int[] twoSortSum(int[] numbers, int target) {
        int[] result = new int[]{-1, -1};
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        // 计算差值
        int sum;
        // 双指针
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return result;
    }
}
