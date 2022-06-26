package com.sigom.Trees;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeImpl implements ITree {
    public Node root;

    public TreeImpl(){
        root = null;
    }

    @Override
    public void insert(int key) {
        root = insert(key, root);
    }
    private Node insert(int key, Node node){
        if( node == null) return new Node(key);
        if (key < node.key){
            node.left = insert(key, node.left);

        } else {
            node.right =insert(key, node.right);
        }
        return node;

    }
    @Override
    public void insertKeys(int[] keys) {
         root = null;
         for(int j=0; j < keys.length; j++){
             insert(keys[j]);
         }
    }

    @Override
    public int delete(int key) {
        Node parent = null;
        Node prev = root;
        while ( prev !=null && prev.key != key ){
            parent = prev;
            if(key < prev.key){
                prev=prev.left;
            } else {
                prev=prev.right;
            }
        }
        if( prev == null) {
            return -1;
        } else {
            int result = prev.key;
            if (prev.left == null && prev.right == null){
                prev=null;
                return result;
            }
        }
        return 0;
    }
    @Override
    public void printTree(){
        printTree(root);
    }

    @Override
    public Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    @Override
    public void BFS() {
        Queue<NodeDepth> queue = new LinkedList<NodeDepth>();
        queue.add(new NodeDepth(root,0));
        int level = 0;
        while(!queue.isEmpty()){
            NodeDepth data = queue.remove();

            if(data.depth > level){
                System.out.println();
                level++;
            }
            System.out.print(data.item.key + " ");
            if(data.item.left !=null ){
                queue.add(new NodeDepth(data.item.left, data.depth+1));
            }
            if(data.item.right != null ){
                queue.add(new NodeDepth(data.item.right, data.depth+1));
            }
        }
        System.out.println();


    }

    @Override
    public void ZigZag() {
        Deque<NodeDepth> deque = new LinkedList<NodeDepth>();
        deque.addLast(new NodeDepth(root,0));
        int level = 0;
        boolean back = true;
        while(!deque.isEmpty()){
            NodeDepth data = deque.remove();

            if(data.depth > level){
                System.out.println();
                level++;
                back = !back;
            }
            System.out.print(data.item.key + " ");
            if (back) {
                if (data.item.right != null) {
                    deque.addLast(new NodeDepth(data.item.right, data.depth + 1));
                }
                if (data.item.left != null) {
                    deque.addLast(new NodeDepth(data.item.left, data.depth + 1));
                }
            }else{
                if (data.item.left != null) {
                    deque.addLast(new NodeDepth(data.item.left, data.depth + 1));
                }
                if (data.item.right != null) {
                    deque.addLast(new NodeDepth(data.item.right, data.depth + 1));
                }
            }
        }
    }

    @Override
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node==null) return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public void inOrder(){
        inOrder(root);
    }

    @Override
    public void reverseTree() {
        preOrder(root);
        reverseTree(root);
        System.out.println();
        preOrder(root);
    }
    private Node reverseTree(Node node){
        if (node == null) return null;
        if(node.left !=null){
            Node nLeft = reverseTree(node.left);
        }
        if(node.right != null){
            Node nRight = reverseTree(node.right);
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }
    private void inOrder(Node node) {
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    Node findLCA(Node node, int n1, int n2){
        if(node == null){
            return null;
        }
        if(node.key == n1 || node.key == n2){
            return node;
        }
        Node nodeLeft = findLCA(node.left, n1,n2);
        Node nodeRight = findLCA(node.right, n1,n2);

        if( nodeLeft != null && nodeRight != null){
            return node;
        }

        return (nodeLeft != null) ? nodeLeft : nodeRight;

    }
    private void printTree(Node node) {
        if(node ==null) return;
        printTree(node.left);
        System.out.print(node.key + " ");
        printTree(node.right);
    }

}
