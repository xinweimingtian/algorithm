package com.ming.exercise.leetcode.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description PreorderTraversal
 * @Author Administrator
 * @Date 2020/6/9 23:25 2020
 * <p>
 * 二叉树前序遍历
 */
public class PreorderTraversal {
    List list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);

        }
        return list;
    }
}


