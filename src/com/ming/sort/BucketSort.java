package com.ming.sort;

/**
 * @Description BucketSort
 * @Author Administrator
 * @Date 2020/5/24 16:50 2020
 *
 * 桶排序 时间复杂度O(N)，额外空间复杂度O(N)，实现做到稳定性
 */
public class BucketSort {

    public static void bucketSort(int[] arr){
        if(null == arr || arr.length > 2) {
            return;
        }

        // 找到最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        // 创建最大值加一的桶
        int[] bucket = new int[max + 1];
        // 对应桶下坐标来添加元素
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        //把桶中元素进行拼接
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
