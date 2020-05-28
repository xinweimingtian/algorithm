package com.ming.basic.sort;

import com.ming.util.SwapUtil;

/**
 * @Description SelectionSort
 * @Author Administrator
 * @Date 2020/5/24 16:38 2020
 *
 * 选择排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
 *
 */
public class SelectionSort {

    public static void selectionSort(long[] arr){
        if(null == arr || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j] < arr[min]?j:min;
            }
            SwapUtil.swap(arr,i,min);
        }
    }

}
