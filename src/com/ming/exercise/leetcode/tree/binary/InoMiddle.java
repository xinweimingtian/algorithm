package com.ming.exercise.leetcode.tree.binary;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description InoMiddle
 * @Author weihuiming
 * @Date
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 *  注意:
 * 你可以假设树中没有重复的元素。
 *
 *  例如，给出
 *
 *  前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 *  返回如下的二叉树：
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class InoMiddle {

    Map<Integer, Integer> map = new HashMap();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return new TreeNode(0);
        }
        for(int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pre=preorder;
        return buildTrees(0, pre.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTrees(int preL, int preR, int inL, int inR) {
        if (preR < preL || inR < inL) {
            return null;
        }
        int root = pre[preL]; // 前序遍历的第一个点是主节点
        int mid = map.get(root);
        TreeNode treeNode = new TreeNode(root);
        // 左节点是 前序左+1到左+mid-中序左  中序左到mid-1
        treeNode.left = buildTrees(preL+1, preL + mid - inL, inL, mid - 1);
        // 右节点是 前序左+mid-中序左+1到前序右  中序mid+1到右
        treeNode.right = buildTrees(preL + mid - inL + 1, preR, mid + 1, inR);
        return treeNode;
    }

    //====== 上面为自己理解的==========下面是大神的=======


    int pres = 0, in = 0;

    public TreeNode buildTrees(int[] preorder, int[] inorder) {
        return recursive(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode recursive(int[] preorder, int[] inorder, int stop) {
        if (pres >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int curVal = preorder[pres++];
        TreeNode cur = new TreeNode(curVal);
        cur.left = recursive(preorder, inorder, curVal);
        cur.right = recursive(preorder, inorder, stop);
        return cur;
    }
}
