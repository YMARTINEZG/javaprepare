package com.sigom.Trees;


public class Main {

    public static void main(String[] args){
        TreeImpl myTree = new TreeImpl();
        int [] values = new int[]{15,7,10,20,17,25,3,4,16,1};

        myTree.insertKeys(values);
        myTree.printTree();

        int x = -4;
        System.out.println(x>>1);
        int y = 4;
        System.out.println(y>>1);
    }
}
