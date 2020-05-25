package com.ming.basic.array.exercise;

/**
 * @Description OrderArrayMain
 * @Author Administrator
 * @Date 2020/5/25 23:19 2020
 */
public class OrderArrayMain {

    public static void main(String[] args) {
        OrderArraySearch orderArray = new OrderArraySearch(30);
        orderArray.insert(10);
        orderArray.display();
        orderArray.insert(15);
        orderArray.display();
        orderArray.insert(2);
        orderArray.display();
        orderArray.insert(9);
        orderArray.display();
        orderArray.insert(7);
        orderArray.display();
        orderArray.insert(6);
        orderArray.display();
        orderArray.insert(30);
        orderArray.display();
        orderArray.insert(22);
        orderArray.display();
        orderArray.insert(50);
        orderArray.display();
        orderArray.insert(19);
        orderArray.display();

        OrderArraySearch orderArray1 = new OrderArraySearch(30);
        orderArray1.insert1(10);
        orderArray1.display();
        orderArray1.insert(15);
        orderArray1.display();
        orderArray1.insert(2);
        orderArray1.display();
        orderArray1.insert(9);
        orderArray1.display();
        orderArray1.insert(7);
        orderArray1.display();
        orderArray1.insert(6);
        orderArray1.display();
        orderArray1.insert(30);
        orderArray1.display();
        orderArray1.insert(22);
        orderArray1.display();
        orderArray1.insert(50);
        orderArray1.display();
        orderArray1.insert(19);
        orderArray1.display();
    }

}
