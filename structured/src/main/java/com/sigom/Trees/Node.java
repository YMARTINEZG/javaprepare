package com.sigom.Trees;

public class Node {
    public int key;
    public Node left;
    public Node right;
    public Node(){
        key=0;
        left=null;
        right=null;
    }
    public Node(int value){
        key=value;
        left=right=null;
    }
}
