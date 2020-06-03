package com.ming.basic.tree.binarytree;

/**
 * @Description BinaryTree
 * @Author weihuiming
 * @Date 二叉树
 */
public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     *  查询节点
     * @param key 通过key查询
     * @return 有返回节点数据 没有返回null
     */
    public BinaryTreeNode find(int key) {
        // 从根节点开始
        BinaryTreeNode current = root;

        // 当前节点不key 不等于 查询的key 循环查询
        while (current.getKeyData() != key) {
            // 如果查询的key 小于当前节点的key
            if (key < current.getKeyData()) {
                // 获取当前节点左子节点 继续比较
                current = current.getLeftChild();
            } else { // 如果查询的key大于当前节点的key
                // 获取当前节点的右子节点 继续比较
                current = current.getRightChild();
            }
            if (current == null) { // 如果当前节点是null 返回
                return null;
            }
        }
        return current;
    }

    /**
     * 添加节点
     * @param id 节点id
     * @param dd 节点值
     */
    public void insert(int id, double dd) {
        BinaryTreeNode newNode = new BinaryTreeNode(id, dd);
        // 判断根基点 有没有数据
        if (root == null) {
            root = newNode; // 没有数据添加到根节点
        } else {
            // 获取当前节点为根节点
            BinaryTreeNode current = root;
            // 当前节点的父节点
            BinaryTreeNode parent;
            // 循环比较
            while (true) {
                // 记录当前节点为父节点
                parent = current;
                // 小于 从左子节点找
                if (id < current.getKeyData()) {
                    // 当前节点指向当前节点的左子节点
                    current = current.getLeftChild();
                    // 如果当前节点的左子节点为null  添加到左子节点
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else { // 大于 从右子节点找
                    current = current.getRightChild(); //指向右子节点
                    if (current == null) { // 右子节点 为null  添加
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除
     * @param key 根据key删除
     * @return 成功返回true 失败返回false
     */
    public boolean delete(int key) {
        // 从根节点开始
        BinaryTreeNode current = root;
        BinaryTreeNode parent = root;
        // 是否比当前节点小 true小 在左子节点 false大 在右子节点
        boolean isLeftChild = true;

        // 循环查询 要删除的节点
        while (current.getKeyData() != key) {
            parent = current;
            if (key < current.getKeyData()) { // 小于 在左子节点
                isLeftChild = true;
                current = current.getLeftChild();
            } else { // 大于 在右子节点
                isLeftChild = false;
                current = current.getRightChild();
            }

            // 不存在 返回false
            if (current == null) {
                return  false;
            }
        }

        // 1. 判断是不是叶节点 叶节点直接删除
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) { // 叶节点是根节点 直接把根节点置空
                root = null;
            } else if (isLeftChild) { // 当前节点在左边
                parent.setLeftChild(null);  // 当前节点的父节点的左子节点置空
            } else {
                parent.setRightChild(null); // 当前节点的父节点的右子节点置空
            }
        }

        // 2. 当前节点没有右子节点
        else if (current.getRightChild() == null) {
            if (current == root) {  // 当前节点是根节点
                root = current.getLeftChild();  // 把当前节点的左子节点设置为根节点
            } else if (isLeftChild) { // 当前节点是父节点的左子节点
                // 设置当前节点的父节点的左子节点为当前节点的左子节点
                parent.setLeftChild(current.getLeftChild());
            } else { // 当前节点在父节点的由子节点

            }
        }
    }

}
