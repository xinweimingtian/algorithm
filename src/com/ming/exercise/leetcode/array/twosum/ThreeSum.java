package com.ming.exercise.leetcode.array.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description ThreeSum
 * @Author Administrator
 * @Date 2020/5/24 18:11 2020
 *
 * 三数之和
 *
 */
public class ThreeSum {

    /**
     *  暴力解法 超出时间限制
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 最后两位是i 和 j的位置
        for(int k = 0; k < nums.length - 2; k++){
            // 和是0  如果第一位就比0大 直接跳出循环
            if(nums[k] > 0) {
                break;
            }
            // 数字重复 直接下一次循环
            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            // 定义双指针
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

}
