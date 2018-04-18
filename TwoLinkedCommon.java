package linked;

/**
 * @Description TwoLinkedCommon 打印两个有序链表的公共部分
 * @Author whmAdmin
 * @Date 2018/4/18 21:32 2018
 */
public class TwoLinkedCommon {
    //题目： 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
    //思路： 定义两个指针，分别指向两个链表的头结点，比较value值，谁小移动谁；相等打印并同时移动
    //      任何一个节点下一个节点是null，程序结束。
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 打印相同部分
     * @param head1
     * @param head2
     */
    public static void twoLinkedCommon(Node head1, Node head2){
        Node node1 = head1;
        Node node2 = head2;

        while (node1 != null && node2 != null) {
            if(node1.value < node2.value) {// node1 小移动
                node1 = node1.next;
            }else if(node1.value > node2.value) {// node2 小移动
                node2 = node2.next;
            }else{ // 相同打印
                System.out.print(node1.value + ",");
                node1 = node1.next;
                node2 = node2.next;
            }
            System.out.println();
        }
    }

    /**
     * 打印链表节点值
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
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        twoLinkedCommon(node1, node2);

    }

}
