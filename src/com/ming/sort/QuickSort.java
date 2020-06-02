package com.ming.sort;

import java.util.Arrays;

import com.ming.util.SwapUtil;

/**
 * @Description QuickSort
 * @Author weihuiming
 * @Date
 * <p>
 * 快速排序 时间复杂度O(N*logN)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 11, 4, 5, 6, 14, 35, 23, 25, 44, 1, 9, 0, 13};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

//        randomQuickSortArray(arr, 0, arr.length - 1); //随机快速排序
//        recQuickSor(arr, 0, arr.length - 1); // 快速排序
        hitThreeQuickSort(arr, 0, arr.length - 1); // 三位取中快速排序

    }

    /**
     * 三位取中快速排序
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void hitThreeQuickSort(int[] arr, int L, int R) {
        int size = R - L + 1;
        // 小于三位 进行自动排序
        if (size <= 3) {
            manualSort(arr, R, L);
        } else {
            // 获取中间划分元素
            int median = medianOf3(arr, L, R);
            int partition = partitionItOf3(arr, L, R, median);
            hitThreeQuickSort(arr, L, partition - 1);
            hitThreeQuickSort(arr, partition + 1, R);
        }
    }

    private static int partitionItOf3(int[] arr, int L, int R, int median) {
        // 左边节点
        int leftPtr = L;
        // 右边节点
        int rightPtr = R - 1;

        while (true) {
            // 如果增加左边的节点小于 划分元素 左边节点停止增加
            while (arr[++leftPtr] < median) ;
            // 如果右边节点大于0 并且右边节点大于 划分元素 右边节点坐标减少
            while (R > 0 && arr[--rightPtr] > median) ;

            // 如果左边大于右边 停止循环
            if (leftPtr >= rightPtr) {
                break;
            } else {
                // 交换数据
                SwapUtil.swap(arr, leftPtr, rightPtr);
            }
        }
        // 最后交换 最后一位的划分元素
        SwapUtil.swap(arr, leftPtr, R - 1);
        return leftPtr;
    }

    private static int medianOf3(int[] arr, int L, int R) {
        // 获取中间下坐标
        int center = (L + R) / 2;
        // 进行判断换位
        if (arr[L] > arr[center]) {
            SwapUtil.swap(arr, L, center);
        }

        if (arr[L] > arr[R]) {
            SwapUtil.swap(arr, L, R);
        }

        if (arr[center] > arr[R]) {
            SwapUtil.swap(arr, center, R);
        }

        SwapUtil.swap(arr, center, R - 1);
        return arr[R - 1];
    }

    // 对三位数进行手动排序
    private static void manualSort(int[] arr, int R, int L) {
        int size = R - L + 1;
        if (size <= 1) {
            return;
        }
        if (size == 2) {
            if (arr[L] > arr[R]) {
                SwapUtil.swap(arr, L, R);
            }
            return;
        } else { // size == 3
            if (arr[L] > arr[L + 1]) {
                SwapUtil.swap(arr, L, L + 1);
            }

            if (arr[L] > arr[R]) {
                SwapUtil.swap(arr, L, R);
            }

            if (arr[L + 1] > arr[R]) {
                SwapUtil.swap(arr, L + 1, R);
            }
        }

    }

    /**
     * 获取最后一位来进行划分快速排序 有可能 出现最差情况 如果数是有序的
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void recQuickSor(int[] arr, int L, int R) {
        if (R - L <= 0) {
            return;
        } else {
            // 记录最右边值 来进行判断
            int pivot = arr[R];

            // 回去划分下坐标
            int partition = partitionIt(arr, L, R, pivot);
            // 排序划分左边的
            recQuickSor(arr, L, partition - 1);
            // 排序划分右边的
            recQuickSor(arr, partition + 1, R);
        }
    }

    /**
     * 获取划分节点、按照划分节点左右划分
     *
     * @param arr
     * @param L
     * @param R
     * @param pivot 划分元素
     * @return
     */
    private static int partitionIt(int[] arr, int L, int R, int pivot) {
        // 左边节点
        int leftPtr = L - 1;
        // 右边节点
        int rightPtr = R;

        while (true) {
            // 如果增加左边的节点小于 划分元素 左边节点停止增加
            while (arr[++leftPtr] < pivot) ;
            // 如果右边节点大于0 并且右边节点大于 划分元素 右边节点坐标减少
            while (R > 0 && arr[--rightPtr] > pivot) ;

            // 如果左边大于右边 停止循环
            if (leftPtr >= rightPtr) {
                break;
            } else {
                // 交换数据
                SwapUtil.swap(arr, leftPtr, rightPtr);
            }
        }
        // 最后交换 最后一位的划分元素
        SwapUtil.swap(arr, leftPtr, R);
        return leftPtr;
    }


    /**
     * 随机快速排序  在获取最后一位来划分的基础上  进行随机获取
     *
     * @param arr
     * @param L
     * @param R
     */
    private static void randomQuickSortArray(int[] arr, int L, int R) {

        if (L < R) {
            // 随机快速排序 一般默认的快排 都是去最后一位上的数 随机选择位置为最后一位
            SwapUtil.swap(arr, (int) (L + (R - L + 1) * Math.random()), R);
            // 获取中间相等的坐标
            int[] mid = randomQuickSortData(arr, L, R);
            // 先排序小于区域的
            randomQuickSortArray(arr, L, mid[0] - 1);
            // 排序大于区域的
            randomQuickSortArray(arr, mid[1] + 1, R);
        }

    }

    /**
     * 随机快速排序
     *
     * @param arr
     * @param L   左边元素下坐标
     * @param R   右边元素下坐标
     * @return
     */
    private static int[] randomQuickSortData(int[] arr, int L, int R) {
        // 较小的
        int less = L - 1;
        // 较大的
        int more = R;

        // 左边指针小于较大边界
        while (L < more) {
            // 如果左边的元素小于最右边的元素
            if (arr[L] < arr[R]) {
                // 较小的元素位置增加 并交换  L增加
                SwapUtil.swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) { //左边的元素小于最右边元素
                // 较大的元素交换到--more位置 L不变 进行下次比较
                SwapUtil.swap(arr, --more, L);
            } else {
                L++; //相等 L增加
            }
        }
        // 最后最后一位和较大的元素 交换
        SwapUtil.swap(arr, more, R);
        // 返回less 和 more  这样左边是小于右边
        return new int[]{less + 1, more};
    }

}
