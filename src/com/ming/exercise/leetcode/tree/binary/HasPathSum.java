package com.ming.exercise.leetcode.tree.binary;

/**
 * @Description HasPathSum
 * @Author Administrator
 * @Date 2020/6/11 22:07 2020
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 *  说明: 叶子节点是指没有子节点的节点。
 *
 *  示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 *
 *  返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        // 减去看和剩余多少
        sum -= root.val;
        // 如果当前节点左右节点都是null 那就证明是根节点
        if(root.left == null && root.right == null){
            // 比较sum是否为0
            return sum == 0;
        }
        // 进行左右子树搜索 并且查看sum剩余多少
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }

}
