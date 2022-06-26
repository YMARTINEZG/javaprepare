package com.sigom.Trees;


public interface ITree {
    void insert(int key);
    void insertKeys(int[] keys);
    int delete(int key);
    void printTree();
    Node findLCA(int n1, int n2);
    void BFS();
    void ZigZag();
    void preOrder();
    void inOrder();
    void reverseTree();
}
