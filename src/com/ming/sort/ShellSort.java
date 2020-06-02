package com.ming.sort;

import java.util.Arrays;

/**
 * @Description ShellSort
 * @Author weihuiming
 * @Date
 *
 *  时间复杂度度大约为O(N*(logN)^2) 比O(N^2)快 比O(N*logN)慢
 *
 */
public class ShellSort {

    public static void main(String[] args) {
        long[] arr = new long[]{5, 4, 21, 7, 2, 85, 3, 6, 1, 0, 65};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        sortInHalf(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }


    /**
     *  每次折半  时间复杂度最坏O(N^2)  可以按2.2的进行相除
     * @param array
     */
    public static void sortInHalf(long[] array) {
        //希尔排序的增量
        int h = array.length;
        while (h > 1) {
            //使用希尔增量的方式，即每次折半
            h = h / 2;
            // 折半前一个坐标x
            for (int x = 0; x < h; x++) {
                // 折半后  加折半距离h的后一个位置 i  每次都加折半距离
                for (int i = x + h; i < array.length; i = i + h) {
                    // 获取折半前坐标的元素
                    long temp = array[i];
                    int j;
                    // 每次都从折半前的坐标开始  进行比较替换 插入排序的移动
                    for (j = i - h; j >= 0 && array[j] > temp; j = j - h) {
                        array[j + h] = array[j];
                    }
                    // 替换最后
                    array[j + h] = temp;
                }
            }
        }
    }

    /**
     * 每次以4 为初始间隔  进行4增量排序 最后会进行一次1增量排序（普通插入排序）
     *
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
              // 每次都从h的坐标开始  进行比较替换 插入排序的移动
                while (inner > h - 1 && arr[inner - h] > temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }


}
