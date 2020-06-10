package com.ming.exercise.leetcode.tree.binary.level;

import java.util.ArrayList;
import java.util.List;

import com.ming.exercise.leetcode.tree.binary.TreeNode;

/**
 * @Description LevelOrder
 * @Author Administrator
 * @Date 2020/6/10 22:15 2020
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 *  示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *  返回其层次遍历结果：
 *
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LevelOrder {

    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrders(root, 0);
        return list;
    }

    public void levelOrders(TreeNode root, int level){
        if(root != null){
            if(list.size() == level) {
                list.add(new ArrayList<Integer>());
            }
            list.get(level).add(root.val);
            levelOrders(root.left, level+1);
            levelOrders(root.right, level+1);
        }
    }

}
