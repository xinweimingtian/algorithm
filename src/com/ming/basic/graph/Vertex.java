package com.ming.basic.graph;

/**
 * @Description Vertex
 * @Author Administrator
 * @Date 2020/6/16 20:52 2020
 *
 * 图中节点数据
 *
 */
public class Vertex {

    public char label; // 数据存储
    public boolean wasVisited; // 是否被查询

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

}
