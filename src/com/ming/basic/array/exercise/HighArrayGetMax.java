package com.ming.basic.array.exercise;

/**
 * @Description HighArrayGetMax
 * @Author Administrator
 * @Date 2020/5/25 22:17 2020
 *
 * 课后练习 2.1 向HighArray中添加一个getMax方法 返回数组中最大元素值，数组为空返回-1
 * 假设所有元素都是正数
 *
 * 课后练习2.2  添加removeMax() 可以删除最大数
 *
 */
public class HighArrayGetMax{

    private long[] data; // 数据存储
    private int size; //大小 指针

    /**
     * 初始化数组
     *
     * @param max
     */
    public HighArrayGetMax(int max) {
        data = new long[max];
        size = 0;
    }

    /**
     * 练习2.1  返回最大关键字  进行循环
     * @return
     */
    public long getMax() {
        long max = -1;
        if (size == 0) {
            return max;
        }
        for (int i = 0; i < size; i++) {
            max = max > data[i] ? max : data[i];
        }
        return max;
    }

    /**
     *  练习题 2.2 删除最大值
     * @return 如果成功 返回true, 否则返回false
     */
    public long removeMax() {
        long max = getMax();
        delete(max);
        return max;
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
