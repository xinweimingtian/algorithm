package com.ming.exercise.leetcode.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description PostorderTraversal
 * @Author Administrator
 * @Date 2020/6/9 23:29 2020
 *
 *  二叉树后序遍历
 *
 */
public class PostorderTraversal {
    List list = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }

}
