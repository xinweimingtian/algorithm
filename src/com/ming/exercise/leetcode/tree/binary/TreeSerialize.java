package com.ming.exercise.leetcode.tree.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TreeSerialize
 * @Author weihuiming
 * @Date 2020/7/30
 *
 * 297 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
 * 式重构得到原数据。
 *
 *  请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
 * 反序列化为原始的树结构。
 *
 *  示例:
 *
 *  你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 *  提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
 * 个问题。
 *
 *  说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *  Related Topics 树 设计
 *
 */
public class TreeSerialize {

    // 序列化成字符串
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        preOrder(root, sb);
        return sb.substring(0, sb.length() - 1);
    }
    // 前序遍历进行序列化
    private void preOrder(TreeNode root, StringBuffer stringBuffer) {
        // 叶子节点的子树都为空，用特殊字符表示
        if (root == null) {
            stringBuffer.append("#,");
            return;
        }
        // 不为空 添加
        stringBuffer.append(root.val);
        stringBuffer.append(",");
        // 添加左边
        preOrder(root.left, stringBuffer);
        // 添加右边
        preOrder(root.right, stringBuffer);
    }

    // 字符串反序列化成二叉树
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strs));
        return buildTree(list);
    }

    private TreeNode buildTree(List<String> list) {
        // 如果是特殊字符，表明是一个空节点
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }

        // 递归创建树
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        // 添加树左边
        root.left = buildTree(list);
        // 添加树右边
        root.right = buildTree(list);
        return root;
    }
}
