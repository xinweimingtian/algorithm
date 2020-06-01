package com.ming.util;

/**
 * @Description SwapUtil
 * @Author Administrator
 * @Date 2020/5/24 16:34 2020
 *
 *  比较并交换
 *
 */
public class SwapUtil {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
