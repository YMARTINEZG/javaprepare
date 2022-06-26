package com.sigom;

import com.sigom.Trees.Node;
import com.sigom.Trees.TreeImpl;

public class App 
{
    public static void main( String[] args )
    {
        TreeImpl tree = new TreeImpl();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

// [3,9,20,null,null,15,7]
// output [[3],[20,9],[7,15]]
// expect [[3],[20,9],[15,7]]
//        int[] values = new int[]{1,2,3,4,5,6,7};
//        tree.insertKeys(values);
//        tree.printTree();
// Tree test
        System.out.println();
        //System.out.println(tree.findLCA(4,5).key);
        tree.BFS();
        System.out.println();
        tree.ZigZag();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.preOrder();
        System.out.println();
        System.out.println("Reverse tree   ..........");
        tree.reverseTree();
    }
}
