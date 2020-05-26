package com.ming.basic.array.exercise;

import java.util.Random;

/**
 * @Description OrderArrayMain
 * @Author Administrator
 * @Date 2020/5/25 23:19 2020
 */
public class OrderArrayMain {

    public static void main(String[] args) {
//        OrderArraySearch orderArray = new OrderArraySearch(30);
//        orderArray.insert(8);
//        orderArray.display();
//        orderArray.insert(15);
//        orderArray.display();
//        orderArray.insert(25);
//        orderArray.display();
//        orderArray.insert(59);
//        orderArray.display();
//        orderArray.insert(57);
//        orderArray.display();
//        orderArray.insert(26);
//        orderArray.display();
//        orderArray.insert(320);
//        orderArray.display();
//        orderArray.insert(252);
//        orderArray.display();
//        orderArray.insert(550);
//        orderArray.display();
//        orderArray.insert(519);
//        orderArray.display();

//        OrderArraySearch orderArray1 = new OrderArraySearch(30);
//        orderArray1.insert1(1);
//        orderArray1.display();
//        orderArray1.insert(145);
//        orderArray1.display();
//        orderArray1.insert(27);
//        orderArray1.display();
//        orderArray1.insert(79);
//        orderArray1.display();
//        orderArray1.insert(78);
//        orderArray1.display();
//        orderArray1.insert(6);
//        orderArray1.display();
//        orderArray1.insert(350);
//        orderArray1.display();
////        orderArray1.insert(22);
////        orderArray1.display();
////        orderArray1.insert(50);
////        orderArray1.display();
////        orderArray1.insert(19);
////        orderArray1.display();

        int max1 = 101;
        int max = 120;
        OrderArraySearch orderArray1 = new OrderArraySearch(max1);
        OrderArraySearch orderArray = new OrderArraySearch(max);

        for (int i = 0; i < max1; i++) {
            orderArray1.insert(new Random().nextInt(999));
        }

        for (int i = 0; i < max; i++) {
            orderArray.insert(new Random().nextInt(9999));
        }

        OrderArraySearch orderArraySearch = OrderArraySearch.merge(orderArray, orderArray1);
//        orderArraySearch.display();
        OrderArraySearch orderArraySearch2 = OrderArraySearch.merge1(orderArray, orderArray1);
//        orderArraySearch2.display();
    }

}
