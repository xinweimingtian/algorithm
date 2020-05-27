package com.ming.exercise.leetcode.array.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description ThreeSum
 * @Author weihuiming
 * @Date 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
 * 的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, 2};
        // {-4, -1, -1, 0, 1, 2, 2}
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 如果相加为0 那就证明 有正数 负数 对数组排序
        Arrays.sort(nums);

        // 定义双指针
        int left;
        int right;

        for (int i = 0; i < nums.length - 2; i++) { //-2 为了使指针不冲突
            // 判断 如果当前元素大于0 直接跳出循环
            if (nums[i] > 0) {
                break;
            }

            // 去重 移动i 防止元素重复添加
            if (i > 0 && nums[i] == nums[i - 1]){
                continue; // 进行下一次循环
            }

            // 给双指针赋值
            left = i + 1; // 循环的下一位
            right = nums.length - 1; //最后坐标

            // 循环比较 左指针比右指针坐标小 两个指针不能相等
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; //计算三个数相加的和

                if (sum > 0) { //如果和大于0  移动左指针 获取负数
                    while (right > left && nums[right] == nums[--right]) ; // 右指针往左侧移动 去重 防止右指针元素重复
                } else if (sum < 0) { // 如果和小于0  移动右指针 获取正数
                    while (left < right && nums[left] == nums[++left]); // 左指针往右侧移动 去重 防止左指针元素重复
                } else { //相等 添加到集合中
                    List list = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(list);
                    // 同时移动左右指针， 查看是否还有剩余相加相等于0的  并且去重
                    while (left < right && nums[left] == nums[++left]);
                    while (right > left && nums[right] == nums[--right]);
                }
            }
        }

        return result;
    }

    // 暴力解法  超出时间
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
