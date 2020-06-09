package com.ming.exercise.leetcode.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description InorderTraversal
 * @Author Administrator
 * @Date 2020/6/9 23:28 2020
 *
 * 二叉树中序遍历
 *
 */
public class InorderTraversal {

    List list = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }

}
