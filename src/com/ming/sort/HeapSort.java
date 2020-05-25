package com.ming.sort;

import com.ming.util.SwapUtil;

/**
 * @Description HeapSort
 * @Author Administrator
 * @Date 2020/5/24 16:48 2020
 *
 * 堆排序 时间复杂度O(N*logN)，额外空间复杂度O(1)，建立堆的操作O(N)，
 * 实现不能做到稳定性堆排序 时间复杂度O(N*logN)，额外空间复杂度O(1)，
 * 建立堆的操作O(N)，实现不能做到稳定性
 */
public class HeapSort {

    public static void seapSort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }

        // 创建大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        // 0位置和最后一个下表位置交换 减小heapSzie下坐标
        SwapUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            // 找到最大的值创建大根对，并和右边元素替换位置，减少空间
            heapify(arr,0,heapSize);
            SwapUtil.swap(arr, 0, --heapSize);
        }

    }

    /**
     * 与子节点比较找到最大值
     * @param arr
     * @param i
     * @param heapSize
     */
    public static void heapify(int[] arr, int i, int heapSize) {
        // 左子节点
        int left = i * 2 + 1;
        // 左子节点不能超过排序好的堆
        while (left < heapSize) {
            // 找到左子节点和右子节点最大的值
            int largest = (left + 1) < heapSize && arr[(left + 1)] > arr[left]?left+1:left;
            // 找到左右子节点最大的值和父节点进行比较找到最大值
            largest = arr[largest] > arr[i] ? largest : i;
            // 最大值是父节点 直接结束
            if(largest == i){
                break;
            }
            // 替换位置，继续按循环找到最大的值
            SwapUtil.swap(arr, largest, i);
            i = largest;
            left = i * 2 + 1;
        }
    }

    /**
     * 创建i位置前的大根堆
     * @param arr 数组
     * @param i	下坐标
     */
    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            SwapUtil.swap(arr, i, (i - 1)/2);
            i = (i - 1) / 2;
        }
    }

}
