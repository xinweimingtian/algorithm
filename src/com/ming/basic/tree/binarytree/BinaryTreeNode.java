package com.ming.basic.tree.binarytree;

/**
 * @Description BinaryTreeNode
 * @Author weihuiming
 * @Date
 *
 * 二叉树节点
 *
 */
public class BinaryTreeNode {

    private int keyData;    // 节点Key
    private double valueData; // 节点value
    private BinaryTreeNode leftChild; // 左子节点
    private BinaryTreeNode rightChild; // 右子节点

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int keyData, double valueData) {
        this.keyData = keyData;
        this.valueData = valueData;
    }

    public BinaryTreeNode(int keyData, double valueData, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.keyData = keyData;
        this.valueData = valueData;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getKeyData() {
        return keyData;
    }

    public void setKeyData(int keyData) {
        this.keyData = keyData;
    }

    public double getValueData() {
        return valueData;
    }

    public void setValueData(double valueData) {
        this.valueData = valueData;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    // 输出打印
    public void displayNode() {
        System.out.print('{');
        System.out.print(keyData);
        System.out.print(",");
        System.out.print(valueData);
        System.out.print('}');
    }
}
