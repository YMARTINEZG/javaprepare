package com.sigom.LinkedList;


public class Node {
    public Object data;
    public Node next;

    public Node() {
        this.data = null;
        this.next = null;
    }
    public Node(Object d, Node n){
        this.data = d;
        this.next=n;
    }
}
