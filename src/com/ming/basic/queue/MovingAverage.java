package com.ming.basic.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description MovingAverage
 * @Author Administrator
 * @Date 2020/6/2 23:24 2020
 * 数据流中的移动平均值
 *
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 * 例如：
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 */
public class MovingAverage {

    private double sum; //计算所有整数和
    private Queue<Integer> queue; // 队列元素
    private Integer max; // 队列最大元素数量

    public MovingAverage(Integer max) {
        this.queue = new LinkedList<>();
        this.max = max;
    }

    public double next(int val) {
        if (queue.size() == max) {
            Integer num = queue.remove();
            sum -= num;
        }
        queue.add(val);
        sum += val;
        return sum/queue.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1) == 1);
        System.out.println(m.next(10) == (double)(1 + 10) / 2);
        System.out.println(m.next(3) == (double)(1 + 10 + 3) / 3);
        System.out.println(m.next(5) == (10 + 3 + 5) / 3);
    }

}

