package com.ming.basic.graph;

/**
 * @Description GraphDFS
 * @Author Administrator
 * @Date 2020/6/14 20:34 2020
 * <p>
 * 深度优先搜索
 * <p>
 * 规则
 * 1. 如果可能，访问一个邻接的未访问顶点，标记它，并把它放入栈中。
 * 2. 当不能执行规则1时，如果栈不空，就从栈中弹出一个顶点。
 * 3. 如果不能执行规则1和规则2，就完成了整个搜索过程。
 */
public class GraphDFS {


    public static void main(String[] args) {
        GraphDFS graphDFS = new GraphDFS();
        graphDFS.addVertex('A'); // 0
        graphDFS.addVertex('B'); // 1
        graphDFS.addVertex('C'); // 2
        graphDFS.addVertex('D'); // 3
        graphDFS.addVertex('E'); // 4

        graphDFS.addEdge(0,4); // AE
        graphDFS.addEdge(3,4); // DE
        graphDFS.addEdge(2,3); // CD
        graphDFS.addEdge(1,2); // BC
        //graphDFS.addEdge(0,3); // AD

        System.out.print("输出：");
        graphDFS.dfs();
        System.out.println();
    }




    private final int MAX_VERTS = 20; // 图中元素最大个数
    private Vertex vertexList[]; // 存储图元素的数组
    private int adjMat[][]; // 存储图的邻接矩阵
    private int nVerts; // 图中元素个数
    private StackX theStackX; // 深度搜索的栈

    public GraphDFS() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStackX = new StackX();
    }

    /**
     * 给图中添加元素
     *
     * @param lab
     */
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    /**
     * 添加图中元素的连接
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    /**
     * 根据图下坐标输出图元素
     *
     * @param v
     */
    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    /**
     *  通过栈进行存储每次访问的节点，
     *  如果有连接的节点，就添加连接的节点下坐标添加到栈中
     *  如果没有，弹出当前栈顶节点，继续找连接节点。
     *  最后把所以被访问节点设置为未访问
     */
    public void dfs() {
        // 设置 下坐标0的元素被访问
        vertexList[0].wasVisited = true;
        // 输出 元素值
        displayVertex(0);
        // 把元素下坐标添加到栈中
        theStackX.push(0);

        while (!theStackX.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStackX.peek());
            if (v == -1) { // 如果没有未访问的节点
                theStackX.pop(); // 弹出当前栈顶的节点
            } else {
                // 找到未访问的节点 设置为true
                vertexList[v].wasVisited = true;
                // 输出当前节点
                displayVertex(v);
                // 把当前节点下走吧添加到栈中
                theStackX.push(v);
            }
        }

        // 设置所有节点未访问
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }

    }

    /**
     * 获取未访问的节点
     *
     * @param v
     * @return
     */
    public int getAdjUnvisitedVertex(int v) {
        // 查询下坐标v 中没有访问的节点 并且连接的节点
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

}

/**
 * 图中节点数据
 */
class Vertex {
    public char label; // 数据存储
    public boolean wasVisited; // 是否被查询

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

/**
 * 搜索存放元素
 */
class StackX {
    private final int SIZE = 20; //栈中最大存放元素数量
    private int[] st; // 栈中存放元素数组
    private int top; // 栈顶位置指针

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

