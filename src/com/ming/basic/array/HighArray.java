package com.ming.basic.array;

/**
 * @Description HighArray
 * @Author Administrator
 * @Date 2020/5/25 20:41 2020
 *
 * 简单的数组封装
 */
public class HighArray {

    private long[] data; // 数据存储
    private int size; //大小 指针

    /**
     * 初始化数组
     *
     * @param max
     */
    public HighArray(int max) {
        data = new long[max];
        size = 0;
    }

    /**
     * 简单数据查询
     * @param searchKey 要查询的数据
     * @return
     */
    public boolean find(long searchKey) {
        int i;
        for (i = 0; i < size; i++) {
            if (data[i] == searchKey) {
                break;
            }
        }
        if (i == size) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *  添加数据
     * @param value
     */
    public void insert(long value) {
        data[size] = value;
        size++;
    }

    /**
     * 删除数据
     * @param value
     * @return
     */
    public boolean delete(long value) {
        int i;
        for (i = 0; i < size ; i++) {
            if (value == data[i]) {
                break;
            }
        }

        if (i == size) {
            return false;
        }else{
            // 把后面的往前移动 并把数组内的数据个数 减少
            for (int j = i; j < size; j++) {
                data[j] = data[j + 1];
            }
            size--;
        }
        return true;
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
