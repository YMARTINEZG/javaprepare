package com.sigom.Stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AppStack {
    public static void main(String[] args){

        System.out.println("----------- Stack ------------");

        Stack<Integer> s = new Stack<Integer>();
        s.push(5);
        s.push(4);
        s.push(10);
        s.push(1);
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }



    }
}
