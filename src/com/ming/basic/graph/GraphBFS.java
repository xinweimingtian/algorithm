package com.ming.basic.graph;

/**
 * @Description GraphBFS
 * @Author Administrator
 * @Date 2020/6/16 20:53 2020
 *
 * 广度优先搜索
 *
 * 规则
 *  1. 访问下一个未访问的邻接点（如果存在），这个顶点必须是当前顶点的邻接点，标记它，并把它插入到队列中。
 *  2. 如果因为已经没有未访问顶点而不能执行规则1，那么从队列头取一个顶点（如果存在），并使其成为当前顶点。
 *  3. 如果因为队列为空而不能执行规则2，则搜索结束。
 */
public class GraphBFS {


    public static void main(String[] args) {
        GraphBFS bfs = new GraphBFS();
        bfs.addVertex('A'); // 0
        bfs.addVertex('B'); // 1
        bfs.addVertex('C'); // 2
        bfs.addVertex('D'); // 3
        bfs.addVertex('E'); // 4

        bfs.addEdge(0, 1);  // AB
        bfs.addEdge(1, 2);  // BC
        bfs.addEdge(0, 3);  // AD
        bfs.addEdge(3, 4);  // DE

        System.out.println("BFS: " );
        bfs.bfs();
        System.out.println();
    }


    private final int MAX_VERTS = 20; // 图最大元素个数
    private Vertex vertexList[];    // 存储图元素的数组
    private int adjMat[][];     // 存储图连接的二维数组
    private int nVerts;     // 图中元素个数
    private Queue theQueue; // 广度搜索队列

    public GraphBFS() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theQueue = new Queue();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int index) {
        System.out.println(vertexList[index].label);
    }

    public void bfs() {
        // 修改下坐标元素状态 输出下坐标值 添加下坐标到队列
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);

        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            // 查询直到没有相邻的节点
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        // 重置图元素状态
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    // 根据v1节点查询相邻的节点
    private int getAdjUnvisitedVertex(int v1) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v1][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }
}

/**
 *  广度搜索存储元素队列
 */
class Queue{
    private final int SIZE = 20;  // 队列最大值
    private int[] queArray; // 队列中存储元素的数组
    private int front; // 队列头下坐标
    private int rear; // 队列尾下坐标

    public Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int index) {
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = index;
    }

    public int remove() {
        int temp = queArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }
}

