package com.sigom.Trees;


public class TreeImpl implements ITree {
    private Node root;

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

    private void printTree(Node node) {
        if(node ==null) return;
        printTree(node.left);
        System.out.print(node.key + " ");
        printTree(node.right);
    }
}
