package com.ming.exercise.leetcode.tree.binary;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description Solution
 * @Author weihuiming
 * @Date
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 *  注意:
 * 你可以假设树中没有重复的元素。
 *
 *  例如，给出
 *
 *  中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
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
public class MiddlePost {

    // 存储中序遍历的节点 k 是值 v是在中序数组的下坐标
    Map<Integer, Integer> map = new HashMap();
    // 后续遍历的引用
    int pos[];

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) {
            return new TreeNode(0);
        }

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pos = postorder;
        return buildTrees(0, inorder.length - 1, 0, pos.length - 1);
    }

    public TreeNode buildTrees(int inL, int inR, int posL, int posR){
        if(inR < inL || posR < posL) {
            return null;
        }

        int root = pos[posR]; // 后续遍历最后一个点就是主节点
        int mid = map.get(root);

        TreeNode treeNode = new TreeNode(root);
        // 左边节点是  中序的左到mid-1   后续的左到后续左+mid-中序左-1
        treeNode.left = buildTrees(inL, mid - 1, posL, posL + mid - inL -1);
        // 右边节点是  中序的mid+1到右   后续的左+mid-前序的左到后续的右-1
        treeNode.right = buildTrees(mid + 1, inR, posL + mid - inL, posR - 1);
        return treeNode;
    }

    //====== 上面为自己理解的==========下面是大神的=======

    int post = 0;
    int in = 0;

    public TreeNode buildTreey(int[] inorder, int[] postorder) {
        this.in = inorder.length - 1;   // 中序遍历数组长度
        this.post = postorder.length - 1;   // 后续遍历数组长度

        return buildTreeys(inorder, postorder, Integer.MAX_VALUE);

    }

    private TreeNode buildTreeys(int[] inorder, int[] postorder, int stop) {
        if (post < 0) {
            return null;
        }
        if (stop == inorder[in]) {
            in--;
            return null;
        }
        int index = postorder[post--];
        TreeNode t = new TreeNode(index);
        t.right = buildTreeys(inorder, postorder, index);
        t.left = buildTreeys(inorder, postorder, stop);
        return t;
    }

}
