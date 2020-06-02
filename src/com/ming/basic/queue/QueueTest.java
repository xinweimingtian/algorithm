package com.ming.basic.queue;

/**
 * @Description QueueTest
 * @Author Administrator
 * @Date 2020/6/2 21:38 2020
 *
 * 双端队列
 *
 */
public class QueueTest {

    public static void main(String[] args) {
        MyCircularQueue m = new MyCircularQueue(2);
        System.out.println(m.enQueue(8));
        System.out.println(m.enQueue(8));
        System.out.println(m.Front());
        System.out.println(m.enQueue(4));
        System.out.println(m.deQueue());
        System.out.println(m.enQueue(1));
        System.out.println(m.enQueue(1));
        System.out.println(m.Rear());
        System.out.println(m.isEmpty());
        System.out.println(m.Front());
        System.out.println(m.deQueue());
    }

}

class MyCircularQueue {

    private int[] arr;
    private int max;
    private int front;
    private int rear;
    private int nItem;

    /** 初始化 */
    public MyCircularQueue(int k) {
        arr = new int[k];
        max = k;
        front = 0;
        rear = -1;
        nItem = 0;
    }

    /** 添加元素 添加成功返回true 失败返回false */
    public boolean enQueue(int value) {
        if(nItem == max) {
            return false;
        }
        if (rear == max-1){
            rear = -1;
        }
        arr[++rear] = value;
        ++nItem;
        return true;
    }

    /**  删除队列元素 删除成功返回true 失败返回false */
    public boolean deQueue() {
        if(nItem == 0){
            return false;
        }
        if(front  == max){
            front = 0;
        }
        front++;
        --nItem;
        return true;
    }

    /** 获取队列头元素 */
    public int Front() {
        if(nItem == 0) {
            return -1;
        }
        return arr[front];
    }

    /** 获取队列尾元素 */
    public int Rear() {
        if(nItem == 0){
            return -1;
        }
        return arr[rear];
    }

    /** 判定队列是否为null 如果为null返回true */
    public boolean isEmpty() {
        if (nItem == 0) {
            return true;
        }
        return false;
    }

    /** 判定队列是否满了  如果满了返回true */
    public boolean isFull() {
        if(nItem == max){
            return true;
        }
        return false;
    }
}
