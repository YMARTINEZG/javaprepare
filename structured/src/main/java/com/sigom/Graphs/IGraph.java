package com.sigom.Graphs;

import java.util.List;

public interface IGraph {
    void addVertex(String s);
    void addEdge(String source,
                 String destination,
                 boolean bidirectional);
    void getVertexCount();
    void getEdgesCount(boolean bidirection);
    void hasVertex(String s);
    String hasEdge(String s, String d);
    String print();
    void buildGraph(String[] employees, String[] relations);
    List<String> BFS(String start);
    List<String> DFS(String start);
    void printRelationship();
}
