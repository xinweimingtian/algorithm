package com.ming.basic.graph;

/**
 * @Description ShortestPath
 * @Author weihuiming
 * @Date
 *
 * 图中最短路径
 *
 */
public class ShortestPath {

    public static void main(String[] args) {
        ShortestPath theGraph = new ShortestPath();
        theGraph.addVertex('A'); // 0 start
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(0, 1, 50); // AB 50
        theGraph.addEdge(0, 3, 80); // AD 80
        theGraph.addEdge(1, 2, 60); // BC 60
        theGraph.addEdge(1, 3, 90); // BD 90
        theGraph.addEdge(2, 4, 40); // CE 40
        theGraph.addEdge(3, 2, 20); // DC 20
        theGraph.addEdge(3, 4, 70); // DE 70
        theGraph.addEdge(4, 1, 50); // EB 50

        System.out.println("最小生成树节点：");
        theGraph.path();
        System.out.println();
    }

    private final int MAX_VERTS = 20; // 最大元素个数
    private final int INFINITY = 1000000; // 节点未连接标志位
    private Vertex vertexList[];    // 存储图元素的数组
    private int adjMat[][];     // 存储图连接的二维数组
    private int nVerts;     // 图中元素个数
    private int nTree;  // 树的节点
    private DistPar distPaths[]; // 接地那距离集合
    private int currentVert; // 当前顶点
    private int startToCurrent; // 开始当前节点

    public ShortestPath() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        // 初始化二维数组
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INFINITY;
            }
        }
        distPaths = new DistPar[MAX_VERTS];
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
    }

    /**
     * 获取最短距离
     */
    public void path(){
        int startTree = 0; // 起始节点
        vertexList[startTree].wasVisited = true; // 添加访问标记
        nTree = 1;

        // 获取 顶点最短距离
        for (int i = 0; i < nVerts; i++) {
            int tempDist = adjMat[startTree][i]; // 获取节点距离
            distPaths[i] = new DistPar(tempDist, startTree); // 存储节点距离和父节点
        }

        // 循环 所有顶点都在树上
        while (nTree < nVerts) {
            int indexMin = getMin();
            int minDist = distPaths[indexMin].distance;

            if (minDist == INFINITY) {
                System.out.println("有无法到达的顶点");
                break;
            } else {
                // 从startTree到currentVert的最小距离是startToCurrent
                currentVert = indexMin;
                startToCurrent = distPaths[indexMin].distance;
            }
            vertexList[currentVert].wasVisited = true;
            nTree++;
            adjustDistPath();
        }

        // 输出
        displayPaths();

        nTree = 0;
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /**
     * 获取当前最短路径下坐标
     * @return
     */
    public int getMin() {
        int minDist = INFINITY; // 最短路径
        int indexMin = 0;   // 最短路径顶点下坐标

        for (int i = 1; i < nVerts; i++) { // 从1开始
            if (!vertexList[i].wasVisited && distPaths[i].distance < minDist) {
                minDist = distPaths[i].distance;
                indexMin = i;
            }
        }
        return indexMin;
    }

    /**
     * 调整最短路径数组spath中的值
     */
    public void adjustDistPath(){
        int column = 1; // 跳过开始节点
        while (column < nVerts) {
            // 如果此列的顶点已经在树中，请跳过它
            if (vertexList[column].wasVisited) {
                column++;
                continue;
            }
            // 计算DistPath距离
            // 从currentVert 获取边缘的列
            int currentToFringe = adjMat[currentVert][column];
            // 从开始增加距离
            int startToFringe = startToCurrent + currentToFringe;
            // 获取当前column的距离
            int sPathDist = distPaths[column].distance;

            // 比较两个节点之间的距离 谁小替换谁
            if (startToFringe < sPathDist) {
                distPaths[column].parentVertex = currentVert;
                distPaths[column].distance = startToFringe;
            }
            column++;
        }
    }

    /**
     * 打印distPaths节点
     */
    public void displayPaths() {
        // 输出distPaths节点
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + "=");
            if (distPaths[i].distance == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(distPaths[i].distance);
            }
            char parent = vertexList[distPaths[i].parentVertex].label;
            System.out.print("(" + parent + ") ");
        }
        System.out.println("");
    }

}

/**
 * 节点距离
 */
class DistPar{

    public int distance;    // 节点距离
    public int parentVertex;  // 父节点

    public DistPar(int distance, int parentVertex) {
        this.distance = distance;
        this.parentVertex = parentVertex;
    }
}