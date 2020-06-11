package com.ming.exercise.leetcode.tree.binary;

/**
 * @Description Symmetric
 * @Author Administrator
 * @Date 2020/6/11 22:04 2020
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *      1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 *
 *
 *  但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *      1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 此题和100题是镜像题
 */
public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetrics(root, root);
    }

    public boolean isSymmetrics(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetrics(left.right, right.left) && isSymmetrics(left.left, right.right);
    }

}
