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


     /**
      * 练习题 2.5 向orderedArray.java程序（清单2.4）的OrdArray类加入一个merge()方法，使之可以将两个
      *  		有序的源数组合并成一个有序的目的数组。在main()中添加代码，向两个源数组中插入随机数，
      *  		调用merge()方法，并将结果目的数组显示出来。两个源数组的数据项个数可能不同。在算法中
      *  		需要先比较源数组中的关键字，从中选出最小的一个数据项复制到目的数组。同时还要考虑如何
      *  		解决当一个源数组的数据项已经取完而另一个还剩一些数据项情况。
      *
      *   merge 和 merge1 是两种实现方式
      * */


    public static OrderArraySearch merge(OrderArraySearch arrayOne, OrderArraySearch arrayTwo) {
        long start = System.currentTimeMillis();
        System.out.println("merge 开始");
        if (arrayOne == null || arrayTwo == null) {
            return new OrderArraySearch(0);
        }
        int oneIndex = 0;
        int twoIndex = 0;
        OrderArraySearch result = new OrderArraySearch(arrayOne.size + arrayTwo.size + 1);
        while (oneIndex  != -1 || twoIndex != -1) {
            if (oneIndex != -1 && twoIndex != -1) {
                if (arrayOne.data[oneIndex] >= arrayTwo.data[twoIndex]) {
                    result.insert(arrayOne.data[oneIndex]);
                    oneIndex++;
                }else{
                    result.insert(arrayTwo.data[twoIndex]);
                    twoIndex++;
                }
            } else if (twoIndex != -1) {
                result.insert(arrayTwo.data[twoIndex]);
                twoIndex++;
            } else {
                result.insert(arrayOne.data[oneIndex]);
                oneIndex++;
            }

            oneIndex = oneIndex == arrayOne.size() ? -1 : oneIndex;
            twoIndex = twoIndex == arrayTwo.size() ? -1 : twoIndex;
        }
        System.out.println("merge 结束 ： " + (System.currentTimeMillis() - start));
        return result;
    }


    public static OrderArraySearch merge1(OrderArraySearch oldArray1, OrderArraySearch oldArray2){
        long start = System.currentTimeMillis();
        System.out.println("merge1 开始");
        OrderArraySearch newArray=new OrderArraySearch(oldArray1.size() + oldArray2.size());
        for(int i=0;i<oldArray1.size();i++){
            newArray.insert(oldArray1.data[i]);
        }
        for(int j=0;j<oldArray2.size();j++){
            newArray.insert(oldArray2.data[j]);
        }
        System.out.println("merge1 结束 ： " + (System.currentTimeMillis() - start));
        return newArray;
    }
}
