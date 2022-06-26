package com.sigom.LinkedList;


public class Node {
    public Integer data;
    public Node next;

    public Node() {
        this.data = null;
        this.next = null;
    }
    public Node(Integer d, Node n){
        this.data = d;
        this.next=n;
    }
}
