package com.ming.basic.sort.experiment;

import com.ming.basic.sort.BubbleSort;
import com.ming.basic.sort.InsertionSort;
import com.ming.basic.sort.SelectionSort;

/**
 * @Description Experiment
 * @Author Administrator
 * @Date 2020/5/27 20:51 2020
 * <p>
 * 实验 分别随机生成10000个数  插入到数组 打印时间
 * <p>
 */
public class Experiment {

    public static void main(String[] args) {
        int max = 10000;
        long[] arr = new long[max];
        long[] arr1 = new long[max];
        long[] arr2 = new long[max];
        // 随机数测试
//        for (int i = 0; i < max; i++) {
//            long n = (long) (Math.random() * (max - 1));
//            arr[i] = n;
//            arr1[i] = n;
//            arr2[i] = n;
//        }
//
//        System.out.println("随机数开始排序-----");
//        long start = System.currentTimeMillis();
//        BubbleSort.bubbleSort(arr);
//        System.out.println("冒泡消耗时间 \t" + (System.currentTimeMillis() - start));
//        long start1 = System.currentTimeMillis();
//        SelectionSort.selectionSort(arr1);
//        System.out.println("选择消耗时间 \t" + (System.currentTimeMillis() - start1));
//        long start2 = System.currentTimeMillis();
//        InsertionSort.insertionSort(arr2);
//        System.out.println("插入消耗时间 \t" + (System.currentTimeMillis() - start2));
//        System.out.println("随机数结束排序-----");

//        // 元素倒序
//        for (int i = max-1; i > 0; i--) {
//            arr[i] = i;
//            arr1[i] = i;
//            arr2[i] = i;
//        }
//
//        System.out.println("元素倒序开始排序----");
//        long start = System.currentTimeMillis();
//        BubbleSort.bubbleSort(arr);
//        System.out.println("冒泡消耗时间 \t" + (System.currentTimeMillis() - start));
//        long start1 = System.currentTimeMillis();
//        SelectionSort.selectionSort(arr1);
//        System.out.println("选择消耗时间 \t" + (System.currentTimeMillis() - start1));
//        long start2 = System.currentTimeMillis();
//        InsertionSort.insertionSort(arr2);
//        System.out.println("插入消耗时间 \t" + (System.currentTimeMillis() - start2));
//        System.out.println("元素倒序结束排序----");
//
//        // 元素正序
        for (int i = 0; i < max; i++) {
            arr[i] = i;
            arr1[i] = i;
            arr2[i] = i;
        }
        System.out.println("正序开始排序-----");
        long start = System.currentTimeMillis();
        BubbleSort.bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("冒泡消耗时间 \t" + (end - start));
        long start1 = System.currentTimeMillis();
        SelectionSort.selectionSort(arr1);
        long end1 = System.currentTimeMillis();
        System.out.println("选择消耗时间 \t" + (end1 - start1));
        long start2 = System.currentTimeMillis();
        InsertionSort.insertionSort(arr2);
        long end2 = System.currentTimeMillis();
        System.out.println("插入消耗时间 \t" + (end2 - start2));
        System.out.println("正序结束排序----");
    }

}
