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

    /**
     * 输出
     * @param arr
     */
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

}
