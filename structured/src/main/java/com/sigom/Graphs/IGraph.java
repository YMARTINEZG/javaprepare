package com.sigom.Graphs;

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
}
