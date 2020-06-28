package com.ming.basic.graph;

/**
 * @Description MSTW
 * @Author weihuiming
 * @Date
 *
 *  带权图的最小生成树
 *  使用优先级队列，总是选择造假最低的边，把已经经过的点删除
 *
 */
public class MSTW {


    public static void main(String[] args) {
        MSTW theGraph = new MSTW();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5

        theGraph.addEdge(0, 1, 6);  // AB 6
        theGraph.addEdge(0, 3, 4);  // AD 4
        theGraph.addEdge(1, 2, 10); // BC 10
        theGraph.addEdge(1, 3, 7);  // BD 7
        theGraph.addEdge(1, 4, 7);  // BE 7
        theGraph.addEdge(2, 3, 8);  // CD 8
        theGraph.addEdge(2, 4, 5);  // CE 5
        theGraph.addEdge(2, 5, 6);  // CF 6
        theGraph.addEdge(3, 4, 12); // DE 12
        theGraph.addEdge(4, 5, 7);  // EF 7

        System.out.println("最小生成树节点：");
        theGraph.mstw();    //AD AB BE EC CF
        System.out.println();
    }



    private final int MAX_VERTS = 20; // 最大元素个数
    private final int INFINITY = 1000000; // 节点未连接标志位
    private Vertex vertexList[];    // 存储图元素的数组
    private int adjMat[][];     // 存储图连接的二维数组
    private int nVerts;     // 图中元素个数
    private int currentVert; // 当前顶点
    private PriorityQueue priorityQueue; // 优先级队列
    private int nTree;  // 树的节点

    public MSTW() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        // 初始化二维数组
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INFINITY;
            }
        }
        priorityQueue = new PriorityQueue();
    }

    /**
     * 添加节点
     * @param lab
     */
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    /**
     * 添加连接点
     * @param start
     * @param end
     * @param weight  两个连接点值
     */
    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    /**
     * 制定下坐标的节点值
     * @param v
     */
    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void mstw() {
        // 当前节点为0
        currentVert = 0;

        // 查询当前树的顶点 是否小于总节点数
        while (nTree < nVerts - 1) {
            // 当前节点标记为已经查询过
            vertexList[currentVert].wasVisited = true;
            nTree++; // 树节点下坐标增加

            for (int i = 0; i < nVerts; i++) {
                if (i == currentVert) { // 坐标相等 直接跳过
                    continue;
                }
                if (vertexList[i].wasVisited) { // 坐标查询过 直接跳过
                    continue;
                }
                int distance = adjMat[currentVert][i]; // 获取两个节点的长度
                if (distance == INFINITY) { // 如果是默认的 直接跳过
                    continue;
                }
                // 把路径长度添加到优先级队列
                putInPQ(i, distance);
            }
            if (priorityQueue.size() == 0) {
                System.out.println("没有元素");
                return;
            }

            // 删除当前节点到另一个节点路径最小的元素
            Edge theEdge = priorityQueue.removeMin();
            // 获取路径最小元素的坐标
            int sourceVert = theEdge.srcVert;
            // 当前坐标标记为最小坐标新节点
            currentVert = theEdge.destVert;

            // 输出最小连接点的值
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }

        // 重置节点标志
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /**
     * 优先级队列中添加元素
     * @param newVert
     * @param newDist
     */
    public void putInPQ(int newVert, int newDist) {
        // 查询当前节点是否存在
        int queueIndex = priorityQueue.find(newVert);
        if (queueIndex != -1) {
            // 获取当前下坐标在队列中的值
            Edge tempEdge = priorityQueue.peekN(queueIndex);
            // 获取队列中的边长
            int oldDist = tempEdge.distance;
            if (oldDist > newDist) {    // 如果边长不存在
                priorityQueue.removeN(queueIndex);
                Edge theEdge = new Edge(currentVert, newVert, newDist);
                priorityQueue.insert(theEdge);
            }
        } else {
            Edge theEdge = new Edge(currentVert, newVert, newDist);
            priorityQueue.insert(theEdge);
        }
    }
}

/**
 * 边数据结构
 */
class Edge {

    public int srcVert; // 顶点起始边的索引
    public int destVert; // 顶点结束边的索引
    public int distance; // src到dest的距离

    public Edge(int srcVert, int destVert, int distance) {
        this.srcVert = srcVert;
        this.destVert = destVert;
        this.distance = distance;
    }
}

/**
 *  优先级队列 从大到小排序
 */
class PriorityQueue {
    private final int SIZE = 20; //队列最大长度
    private Edge[] queArray; // 存储边元素数组
    private int size;   // 当前数组元素

    public PriorityQueue() {
        this.queArray = new Edge[SIZE];
        this.size = 0;
    }

    /**
     * 添加元素
     * @param item
     */
    public void insert(Edge item) {
        int j;
        // 进行排序获取要添加的位置
        for (j = 0; j < size; j++) {
            // 判断添加的边值和当前的值比较
            if (item.distance >= queArray[j].distance) {
                break;
            }
        }

        // 移动位置 所有元素往后移动
        for (int i = size - 1; i >=j ; i--) {
            queArray[i + 1] = queArray[i];
        }

        queArray[j] = item;
        size++;
    }

    /**
     * 删除最小值
     * @return
     */
    public Edge removeMin() {
        return queArray[--size];
    }


    /**
     * 删除第N项数据
     * @param n
     */
    public void removeN(int n){
        // 数组后面数据往前移动
        for (int i = n; i < size - 1; i++) {
            queArray[i] = queArray[i + 1];
        }
        size--;
    }

    /**
     * 获取当前最新元素
     * @return
     */
    public Edge peekMin(){
        return queArray[size - 1];
    }

    /**
     * 当前元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断数组是否为null
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 获取当前第N项元素
     * @param n
     * @return
     */
    public Edge peekN(int n){
        return queArray[n];
    }

    /**
     * 查询当前队列中元素的边值是否存在findDex
     * @param findDex
     * @return
     */
    public int find(int findDex) {
        for (int i = 0; i < size; i++) {
            if (queArray[i].destVert == findDex) {
                return i;
            }
        }
        return -1;
    }
}
