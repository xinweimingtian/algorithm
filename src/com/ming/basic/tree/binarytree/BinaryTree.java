package com.ming.basic.tree.binarytree;

/**
 * @Description BinaryTree
 * @Author weihuiming
 * @Date 二叉树
 */
public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     *  查询节点
     * @param key 通过key查询
     * @return 有返回节点数据 没有返回null
     */
    public BinaryTreeNode find(int key) {
        // 从根节点开始
        BinaryTreeNode current = root;

        // 当前节点不key 不等于 查询的key 循环查询
        while (current.getKeyData() != key) {
            // 如果查询的key 小于当前节点的key
            if (key < current.getKeyData()) {
                // 获取当前节点左子节点 继续比较
                current = current.getLeftChild();
            } else { // 如果查询的key大于当前节点的key
                // 获取当前节点的右子节点 继续比较
                current = current.getRightChild();
            }
            if (current == null) { // 如果当前节点是null 返回
                return null;
            }
        }
        return current;
    }

    /**
     * 添加节点
     * @param id 节点id
     * @param dd 节点值
     */
    public void insert(int id, double dd) {
        BinaryTreeNode newNode = new BinaryTreeNode(id, dd);
        // 判断根基点 有没有数据
        if (root == null) {
            root = newNode; // 没有数据添加到根节点
        } else {
            // 获取当前节点为根节点
            BinaryTreeNode current = root;
            // 当前节点的父节点
            BinaryTreeNode parent;
            // 循环比较
            while (true) {
                // 记录当前节点为父节点
                parent = current;
                // 小于 从左子节点找
                if (id < current.getKeyData()) {
                    // 当前节点指向当前节点的左子节点
                    current = current.getLeftChild();
                    // 如果当前节点的左子节点为null  添加到左子节点
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else { // 大于 从右子节点找
                    current = current.getRightChild(); //指向右子节点
                    if (current == null) { // 右子节点 为null  添加
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除
     * @param key 根据key删除
     * @return 成功返回true 失败返回false
     */
    public boolean delete(int key) {
        // 从根节点开始
        BinaryTreeNode current = root;
        BinaryTreeNode parent = root;
        // 是否比当前节点小 true小 在左子节点 false大 在右子节点
        boolean isLeftChild = true;

        // 循环查询 要删除的节点
        while (current.getKeyData() != key) {
            parent = current;
            if (key < current.getKeyData()) { // 小于 在左子节点
                isLeftChild = true;
                current = current.getLeftChild();
            } else { // 大于 在右子节点
                isLeftChild = false;
                current = current.getRightChild();
            }

            // 不存在 返回false
            if (current == null) {
                return  false;
            }
        }

        // 1. 判断当前删除节点是不是叶节点 叶节点直接删除
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) { // 叶节点是根节点 直接把根节点置空
                root = null;
            } else if (isLeftChild) { // 当前删除节点是父节点的左子节点
                parent.setLeftChild(null);  // 当前删除节点的父节点的左子节点置空
            } else {
                parent.setRightChild(null); // 当前删除节点的父节点的右子节点置空
            }
        }

        // 2. 当前删除节点没有右子节点
        else if (current.getRightChild() == null) {
            if (current == root) {  // 当前删除节点是根节点
                root = current.getLeftChild();  // 把当前删除节点的左子节点设置为根节点
            } else if (isLeftChild) { // 当前删除节点是父节点的左子节点
                // 设置当前删除节点的父节点的左子节点为当前删除节点的左子节点
                parent.setLeftChild(current.getLeftChild());
            } else { // 当前删除节点是父节点的右子节点
                //设置当前删除节点的父节点的右子节点为当前删除节点的左子节点
                parent.setRightChild(current.getLeftChild());
            }
        }

        //3. 当前删除节点没有左子节点
        else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) { // 当前删除节点是父节点的左子节点
                parent.setLeftChild(current.getRightChild());
            } else {// 当前删除节点是付姐点的右子节点
                parent.setRightChild(current.getRightChild());
            }
        }

        //4. 当前删除节点都有左右子节点
        else {
            // 获取当前要删除的节点的后继节点
            BinaryTreeNode successor = getSuccessor(current);
            // 当前删除节点是根节点 设置后继节点是根节点
            if (current == root) {
                root = successor;
            } else if (isLeftChild) { // 如果删除节点是父节点的左子节点
                parent.setLeftChild(successor); // 设置后继节点为删除节点父节点的左子节点
            } else {// 当前删除节点是父节点的右子节点
                parent.setRightChild(successor); // 设置后继节点为删除节点父节点的右子节点
            }

            // 设置当前后继节点的左子节点为当前删除节点的左子节点
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    /**
     * 根据当前节点 获取后继节点
     * 获取删除节点的右子节点的最左子节点  这个节点就是后继节点
     * 设置后继节点的右子节点为要删除节点的右子节点
     * @param delNode 要删除的节点
     * @return
     */
    private BinaryTreeNode getSuccessor(BinaryTreeNode delNode) {
        // 当前节点的后继节点的父节点
        BinaryTreeNode successorParent = delNode;
        // 当前节点的后继节点
        BinaryTreeNode success = delNode;
        // 当前节点（获取当前节点的右子节点）
        BinaryTreeNode current = delNode.getRightChild();

        // 获取删除节点的右子节点的最左子节点  这个节点就是后继节点
        while (current != null) {
            // 后继节点的父节点
            successorParent = success;
            // 后继节点
            success = current;
            // 当前节点的左子节点
            current = current.getLeftChild();
        }

        // 如果当前删除的节点存在 右子节点的最左子节点
        if (success != delNode.getRightChild()) {
            // 把当前后继节点的父节点的左子节点设置为后继节点的右子节点
            successorParent.setLeftChild(success.getRightChild());
            // 把原来的后继节点的右子节点设置为要删除节点的右子节点
            success.setRightChild(delNode.getRightChild());
        }

        // 返回后继节点
        return success;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\n 二叉树的前序遍历");
                preOrder(root);
                break;
            case 2:
                System.out.print("\n 二叉树的中序遍历");
                inOrder(root);
                break;
            case 3:
                System.out.print("\n 二叉树的后序遍历");
                postOrder(root);
                break;
        }
    }

    /**
     * 前序遍历 先输出根节点 接着输出左子节点 最后输出右子节点
     * 前序遍历开头是根节点  第二位是最左子节点  最后一位是最右子节点
     * @param root
     */
    private void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print("\n " + root.getKeyData() + "\n" + root.getValueData());
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    /**
     * 中序遍历  先输出最子节点中间是根节点最后是右子节点
     * 根节点的左边是根节点的左子节点全部  根节点的右边是右子节点全部
     * @param root
     */
    private void inOrder(BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.getLeftChild());
            System.out.print("\n " + root.getKeyData() + "\n" + root.getValueData());
            preOrder(root.getRightChild());
        }
    }

    /**
     * 后序遍历  先输出最左子节点 接着是右子节点 最后是根节点
     * 后序遍历的最后是节点是根节点  开头是最左子节点
     * @param root
     */
    private void postOrder(BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
            System.out.print("\n " + root.getKeyData() + "\n" + root.getValueData());
        }
    }
}
