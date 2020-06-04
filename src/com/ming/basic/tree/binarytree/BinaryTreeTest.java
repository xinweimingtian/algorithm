package com.ming.basic.tree.binarytree;

/**
 * @Description BinaryTreeTest
 * @Author weihuiming
 * @Date
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(8, 11.3);
        tree.insert(1, 11.3);
        tree.insert(5, 11.3);
        tree.insert(6, 11.3);
        tree.insert(3, 11.3);
        tree.insert(14, 11.3);
        tree.insert(2, 11.3);
        tree.insert(15, 11.3);

        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);
    }

}
