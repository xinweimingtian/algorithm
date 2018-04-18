package linked;

import java.util.Stack;

/**
 * @Description PalindromeNumber 判断链表是不是回文数
 * @Author whmAdmin
 * @Date 2018/4/7 12:54 2018
 */
public class PalindromeNumber {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一：使用栈来进行比较，把所有元素都压入栈，然后弹出栈进行比较
     * 时间复杂度O(N) 空间复杂度O(N)
     * @param node
     * @return
     */
    public static boolean isPalindromeOne(Node node){
        Stack<Node> stack = new Stack<>();
        Node cur = node;
        // 节点不为null 都压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        // 弹出栈进行比较
        while (node != null) {
            if(node.value != stack.pop().value){
                return false;
            }
            node = node.next;
        }
        return true;
    }

    /**
     * 使用快慢指针，快指针每次走两步，慢指针每次走一步。当快指针到达终点的时候，慢指针在中间的位置。
     * 把中间到后面的位置压入栈，从头开始比较。
     * 时间复杂度O(N) 空间复杂度O(N)
     * @param node
     * @return
     */
    public static boolean isPalindromeTwo(Node node){
        if (node == null || node.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        // 快指针
        Node fast = node;
        // 慢指针
        Node slow = node;

        // 快指针在终点位置的时候，慢指针在中间位置
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 把慢指针后面的位置压入栈
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }

        // 弹出栈进行比较
        while (!stack.isEmpty()){
            if(stack.pop().value != node.value){
                return false;
            }
            node = node.next;
        }
        return true;
    }

    /**
     * 使用快慢指针，当快指针走的终点的时候，慢指针在中间的位置，把中间到最后的位置开始倒序链表。
     * 然后分别从两头开始比较，比较完后，把链表顺序再排列好
     * 时间复杂度O(N)，空间复杂度O(1)
     * @param node
     * @return
     */
    public static boolean isPalindromeThree(Node node){
        if (node == null || node.next == null) {
            return true;
        }
        // 快指针
        Node fast = node;
        // 慢指针
        Node slow = node;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // 开始折半倒序 成^ 状 同时指向中间节点 中间节点指向null
        // 记录中间节点的下一个节点
        Node help = slow.next;
        // 中间位置上的节点的下一个节点指向null
        slow.next = null;
        // 设定记录节点
        Node no;

        // 链表后半部分倒序
        while (help != null) {
            // 记录中间下一个元素的下一个原始的指针位置
            no = help.next;
            // 中间元素的下一个元素指向中间标记节点
            help.next = slow;
            // 变化中间标记节点
            slow = help;
            // 变化下一个节点
            help = no;
        }


        // 记录头结点
        no = node;
        // 记录另一侧头结点
        help = slow;

        boolean flag = true;
        //help 和 从头开始对比 只要有一个节点是null 停止循环;
        while(no != null && help != null) {
            if(no.value != help.value) {
                flag =  false;
                break;
            }
            no = no.next;// no往链表中间走
            help = help.next;//help往链表中间走
        }

       // 记录最后一个node的前一个node 并把最后一个node指向null
       no = slow.next;
       slow.next = null;
        // 比较完进行返回原样
        while(no != null) {
            // 记录下一个节点
            help = no.next;
            // 下一个节点指向中间标记节点
            no.next = slow;
            // 变化中间标记节点
            slow = no;
            // 变化下一个节点
            no = help;
        }
        return flag;
    }


    /**
     * 遍历打印节点
     * @param node
     */
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeOne(head) + " | ");
        System.out.print(isPalindromeTwo(head) + " | ");
        System.out.println(isPalindromeThree(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
