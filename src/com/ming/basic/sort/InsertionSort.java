package com.ming.basic.sort;

import com.ming.util.SwapUtil;

/**
 * @Description InsertionSort
 * @Author Administrator
 * @Date 2020/5/24 16:39 2020
 *
 * 插入排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
 *
 */
public class InsertionSort {

    public static void insertionSort(long[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

}
