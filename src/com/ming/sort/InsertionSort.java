package com.ming.sort;

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

    public static void main(String[] args) {
        int[] arr = {10, 11, 4, 5, 6, 14, 35, 23, 25, 44, 1, 0};
        System.out.println("排序前：");
        SwapUtil.print(arr);
        insertionSort(arr);
        System.out.println("排序后：");
        SwapUtil.print(arr);
    }

    public static void insertionSort(int[] arr) {
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
