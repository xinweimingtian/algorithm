package com.ming.exercise.leetcode.tree.binary;

/**
 * @Description Node
 * @Author Administrator
 * @Date 2020/6/30 23:32 2020
 *
 * 116. Node节点
 *
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}
