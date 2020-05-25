package com.ming.exercise.leetcode.array.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TwoSum
 * @Author Administrator
 * @Date 2020/5/22 23:03 2020
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 *
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{-1, -1};
        }

        // 通过map存储唯一的键
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            // 如果包含就返回
            if (map.containsKey(number)) {
                return new int[]{map.get(number), i};
            } else {
                // 会出现[2,2，-2] 要结果是0
                // 严格的话应该返回0,2  目前返回1,2
                // 如果要严格 此处要进行map.containsKey
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
