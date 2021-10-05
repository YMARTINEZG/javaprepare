package com.sigom.Trees;


public interface ITree {
    void insert(int key);
    void insertKeys(int[] keys);
    int delete(int key);
    void printTree();
}
