package com.ming.basic.array.exercise;

/**
 * @Description ArrayMain
 * @Author Administrator
 * @Date 2020/5/25 22:39 2020
 *
 *  HighArray 测试
 */
public class HighArrayMain {

    public static void main(String[] args) {
        int maxSize = 30;
        HighArrayGetMax highArray = new HighArrayGetMax(maxSize);
        highArray.insert(23);
        highArray.insert(343);
        highArray.insert(2543);
        highArray.insert(234);
        highArray.insert(23);
        highArray.insert(233);
        highArray.insert(230);
        highArray.insert(253);
        highArray.insert(223);
        highArray.insert(2);

        highArray.display();


        System.out.println("最大数="+highArray.getMax());

        highArray.removeMax();

        highArray.display();

        /* 2.3 练习题
        编程作业2.2中的removeMax()方法提供了一种通过关键字值进行数组排序的方法。实现一个
        排序方案，要求不修改HighArray类，只需对main()中的代码进行修改。这个方法需要第二个
        数组，在排序结束时数组数据项是逆序排列的。（这个方法是第3章“简单排序”中选择排序的
        一个变体。）*/
        HighArrayGetMax highArrayGetMax = new HighArrayGetMax(maxSize);
        long max = highArray.removeMax();
        while (max != -1) {
            highArrayGetMax.insert(max);
            max = highArray.removeMax();
        }
        System.out.println("逆序后输出");
        highArrayGetMax.display();

    }

}
