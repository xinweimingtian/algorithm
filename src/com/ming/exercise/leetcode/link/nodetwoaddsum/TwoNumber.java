package com.ming.exercise.leetcode.link.nodetwoaddsum;

/**
 * @Description TwoNumber
 * @Author Administrator
 * @Date 2020/5/22 23:24 2020
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoNumber {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(7);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        addTwoNumbers(listNode1, listNode2);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建两个链表头  进行组装链表
        ListNode node = new ListNode(0);
        // 永远指向链表头
        ListNode sumNode = node;
        // 判定是否需要进位
        int num = 0;

        // 循环判定 两个链表只要有一个不为null  继续添加 防止链表长度不同
        while (l1 != null || l2 != null) {
            // 如果是null 返回0 进行相加 否则就是当前的值
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            // 计算和是多少
            int sum = num1 + num2 + num;
            // 判定是否大于10
            num = sum / 10;
            sum = sum % 10;
            // 进行节点创建赋值
            node.next = new ListNode(sum);
            // 指向下一个节点
            node = node.next;
            // 判定两个链表是否都是null 防止两个链表抄底不同
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            ;
        }
        // 如果最后num大于1  添加新的链表
        if (num == 1) {
            node.next = new ListNode(1);
        }
        // 返回头链表的下一个链表节点
        return sumNode.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}