package com.ming.basic.array.exercise;

/**
 * @Description OrderArraySearch
 * @Author Administrator
 * @Date 2020/5/25 22:55 2020
 *  练习题 2.4
 * 修改orderedArray.java程序（清单2.4）使insert()、delete()与find()方法一样都使用
 *     	二分查找，正如书中所建议的那样
 */
public class OrderArraySearch {

    private long[] data;
    private int size;

    public OrderArraySearch(int max) {
        data = new long[max];
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     *  有序数组 二分查询进行查询
     * @param searchKey
     * @return
     */
    public int find(long searchKey) {
        int left = 0;   // 左指针
        int right = size - 1; // 右指针
        int mid;    // 中间值

        while (true) {
            mid = left + (right - left) / 2;
            // 先等 直接返回
            if (data[size] == searchKey) {
                return mid;
            } else if (left > right) { // 左指针大于右指针 说明没有 返回数组中的总个数
                return size;
            } else {
                // 当前中间数比要查询的数小 找右边
                if (data[mid] < searchKey) {
                    left = mid + 1;
                } else {
                    // 否则就从左边找
                    right = mid - 1;
                }
            }
        }
    }

    public void insert(long value) {

        if (size == 0) {
            data[size]  = value;
            size++;
            return;
        }
        if (data[size-1] < value) {
            data[size] = value;
            size++;
            return;
        }

        int i;
        // 因为数据有序 添加前先查询
        for (i = 0; i < size; i++) {
            if (data[i] > value) {
                break;
            }
        }
        // 所有数据往后移动一位
        for (int j = size; j > i; j--) {
            data[j] = data[j - 1];
        }

        // 把要添加的值按顺序添加到制定位置
        data[i] = value;
        size++;
    }

    public boolean insert1(long value) {

        // 如果为空 直接添加
        if (size == 0) {
            data[size]  = value;
            size++;
            return true;
        }

        // 如果比最大的还大  也直接添加
        if (data[size - 1] < value) {
            data[size] = value;
            size++;
            return true;
        }

        int left = 0;
        int right = size - 1;
        int mid;
        int i;

        while (true) {
            mid = left + (right - left) / 2;
            if (data[mid] == value) {
                return false;
            } else if (data[mid] > value) {
                if (data[left] == value){
                    return false;
                }else if (data[left] > value){
                    i = left;
                    break;
                }else{
                    right = mid - 1;
                }
            }else {
                if (data[right] == value){
                    return false;
                } else{
                    left = mid + 1;
                }
            }
        }
        // 所有数据往后移动一位
        for (int j = size; j > i; j--) {
            data[j] = data[j - 1];
        }

        // 把要添加的值按顺序添加到制定位置
        data[i] = value;
        size++;
        return true;
    }


    public boolean delete(long value) {
        int j = find(value);
        if (j == size) {
            return false;
        }else{
            // 所有数据往前移动一位
            for (int i = j; i < size; i++) {
                data[i] = data[i + 1];
            }
            size--;
            return true;
        }
    }

    /**
     * 打印输出数组内的数据
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

}
