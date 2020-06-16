package com.ming.basic.heap;

/**
 * @Description Heap
 * @Author weihuiming
 * @Date 堆
 *
 *  父节点的下坐标为（x-1)/2
 *  左子节点的下标为2 * x + 1
 *  右子节点的下标为2 * x + 2
 *
 */
public class Heap {

    private Node[] heapArray; // 堆中存储元素的数组
    private int maxSize; // 堆最大值
    private int currentSize; // 堆当前值

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }

        // 创建新节点
        Node newNode = new Node(key);
        // 把新节点添加到最后
        heapArray[currentSize] = newNode;
        // 向上查询 自己应该存放的位置
        trickleUp(currentSize++);
        return true;
    }

    /**
     *  添加节点 向上查询 确定最终位置
     * @param index
     */
    private void trickleUp(int index) {
        // 获取当前节点的父节点下坐标
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        // 向上查询节点，如果当前节点的父节点 小于当前节点 继续查询
        while (index > 0 && heapArray[parent].getDataValue() < bottom.getDataValue()) {
            // 交换当前节点和当前节点父节点位置
            heapArray[index] = heapArray[parent];
            // 下坐标变成当前父节点
            index = parent;
            // 重新获取父节点左边
            parent = (parent - 1) / 2;
        }
        // 最后把新节点放到最终位置
        heapArray[index] = bottom;
    }

    /**
     *  删除节点 移除根节点
     * @return
     */
    public Node remove() {
        // 获取根节点下坐标的值
        Node root = heapArray[0];
        // 把最后一位交换到根节点
        heapArray[0] = heapArray[--currentSize];
        // 从根向下查询最终节点位置
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largerChild;  // 当前大于的子节点
        Node top = heapArray[index];
        while (index < currentSize / 2) { // 最少有一个子节点
            int leftChild = 2 * index + 1;// 左子节点位置
            int rightChild = leftChild + 1; // 右子节点位置

            // 右节点下坐标下哟当前最大节点下坐标  并且 左节点值小于右节点值
            if (rightChild < currentSize && heapArray[leftChild].getDataValue() < heapArray[rightChild].getDataValue()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            // 定点大于当前最大的
            if (top.getDataValue() >= heapArray[largerChild].getDataValue()) {
                break;
            }
            // 交换最大点和当前丁点
            heapArray[index] = heapArray[largerChild];
            // 当前点变成最大点  继续找
            index = largerChild;
        }
        heapArray[index] = top;
    }

    /**
     * 添加到指定下坐标
     * @param index
     * @param newValue
     * @return
     */
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        // 获取当前下坐标值
        int oldValue = heapArray[index].getDataValue();
        // 设置当前下坐标为新值
        heapArray[index].setDataValue(newValue);
        // 进行比较 排列
        if (oldValue < newValue) {
            trickleUp(index);
        }else{
            trickleDown(index);
        }
        return true;
    }

}

/**
 * 堆中的节点
 */
class Node{
    private int dataValue;

    public Node(int dataValue) {
        this.dataValue = dataValue;
    }

    public int getDataValue() {
        return dataValue;
    }

    public void setDataValue(int dataValue) {
        this.dataValue = dataValue;
    }
}