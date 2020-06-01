package com.ming.sort;

import java.util.Arrays;

import com.ming.util.SwapUtil;

/**
 * @Description ShellSort
 * @Author weihuiming
 * @Date
 */
public class ShellSort {

    public static void main(String[] args) {
        long[] arr = new long[]{5, 4, 21, 7, 2, 85, 3, 6, 1, 0, 65};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        shellSort4h(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  每次以4 为初始间隔  进行4增量排序 最后会进行一次1增量排序（普通插入排序）
     * @param arr
     */
    public static void shellSort4h(long[] arr) {
        if (arr == null || arr.length < 0) {
            return;
        }
        int inner = 0;
        int outer;
        long temp = 0;

        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            // 插入排序
            for (outer = h; outer < arr.length; outer++) {
                temp = arr[outer];
                inner = outer;
                while (inner > h - 1 && arr[inner - h] >= temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }


}
