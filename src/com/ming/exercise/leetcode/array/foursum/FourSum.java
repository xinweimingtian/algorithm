package com.ming.exercise.leetcode.array.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description FourSum
 * @Author weihuiming
 * @Date
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
 *  d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 *  注意：
 *
 *  答案中不可以包含重复的四元组。
 *
 *  示例：
 *
 *  给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, 2};
        // {-4, -1, -1, 0, 1, 2, 2}
        System.out.println(fourSum(nums, 0));
    }


    /**
     * 	解答成功:
     * 	执行耗时:3 ms,击败了99.97% 的Java用户
     *  内存消耗:39.8 MB,击败了13.16% 的Java用户
     *
     *  多判断
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        // 排序
        Arrays.sort(nums);

        // 双指针
        int left;
        int right;
        int sum;
        int length = nums.length;

        // 循环进行比较
        for (int i = 0; i < length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 当前最小值都大于 目标值 直接停止循环
            sum = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (sum > target) {
                break;
            }

            // 当前最大值都小于目标值 跳过循环
            sum = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (sum < target) {
                continue;
            }

            // 第二次循环 相当于三个数的和
            for (int j = i + 1; j < length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                left = j + 1;
                right = nums.length - 1;

                // 当前最小值都大于 目标值 直接停止循环
                sum = nums[i] + nums[j] + nums[left] + nums[left + 1];
                if (sum > target) {
                    break;
                }

                // 当前最大值都小于目标值 跳过循环
                sum = nums[i] + nums[j] + nums[right] + nums[right - 1];
                if (sum < target) {
                    continue;
                }

                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) { // 右指针往左移动
                        while (right > left && nums[right] == nums[--right]); // 去重
                    }else if (sum < target) { // 左指针往右移动
                        while (left < right && nums[left] == nums[++left]); // 去重
                    }else{ //相等添加
                        List list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(list);
                        // 去重
                        while (right > left && nums[right] == nums[--right]); // 去重
                        while (left < right && nums[left] == nums[++left]); // 去重
                    }
                }
            }
        }
        return result;
    }

    /**
    *   解答成功:
    *   执行耗时:24 ms,击败了31.30% 的Java用户
    *   内存消耗:40.3 MB,击败了10.53% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        // 排序
        Arrays.sort(nums);

        // 双指针
        int left;
        int right;
        int sum;

        // 循环进行比较
        for (int i = 0; i < nums.length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 第二次循环 相当于三个数的和
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                left = j + 1;
                right = nums.length - 1;

                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) { // 右指针往左移动
                        while (right > left && nums[right] == nums[--right]); // 去重
                    }else if (sum < target) { // 左指针往右移动
                        while (left < right && nums[left] == nums[++left]); // 去重
                    }else{ //相等添加
                        List list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(list);
                        // 去重
                        while (right > left && nums[right] == nums[--right]); // 去重
                        while (left < right && nums[left] == nums[++left]); // 去重
                    }
                }
            }
        }
        return result;
    }
}
