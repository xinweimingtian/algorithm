package com.ming.exercise.leetcode.tree.binary;

/**
 * @Description TreeNextOut
 * @Author Administrator
 * @Date 2020/6/30 23:32 2020
 *
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 *  struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 *  填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 *  初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 *  示例：
 *
 *
 *
 *  输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"ri
 * ght":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right
 * ":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left"
 * :null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":nu
 * ll,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4
 * ","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next"
 * :null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":
 * null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":
 * "6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"va
 * l":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 *
 *
 *
 *  提示：
 *
 *
 *  你只能使用常量级额外空间。
 *  使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 */
public class TreeNextOut {
    // 解题
    // 每个 node 左子树的 next , 就是 node 的右子树
    // 每个 node 右子树的 next, 就是 node next 的 左子树
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private Node dfs(Node node, Node next) {
        if (node != null) {
            node.next = next;
            dfs(node.left, node.right);
            dfs(node.right, node.next != null ? node.next.left : null);
        }
        return node;
    }
}
