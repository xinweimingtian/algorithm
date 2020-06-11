package com.ming.exercise.leetcode.tree.binary;

/**
 * @Description SameTree
 * @Author Administrator
 * @Date 2020/6/11 22:02 2020
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 *  如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *  示例 1:
 *
 *  输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 *  示例 2:
 *
 *  输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 *
 *  示例 3:
 *
 *  输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 此题和101题是镜像题
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两个节点都是null  返回true
        if(p == null && q == null){
            return true;
        }
        // 两个节点有一个不为null  证明不平衡
        if(p == null || q == null){
            return false;
        }
        // 两个节点值不相等 返回false
        if(p.val != q.val){
            return false;
        }
        // 左子节点 右子节点继续查找
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
