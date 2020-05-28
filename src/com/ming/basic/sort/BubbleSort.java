package com.ming.basic.sort;

import com.ming.util.SwapUtil;

/**
 * @Description BubbleSort
 * @Author Administrator
 * @Date 2020/5/24 16:15 2020
 *
 * 冒泡排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
 *
 */
public class BubbleSort {

    public static void bubbleSort(long[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

}
