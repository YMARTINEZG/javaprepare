package com.sigom.Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AppQueue {
    public static void main(String[] args){

        System.out.println( "------------ Deque --------------" );
        Deque<Integer> myDeque = new LinkedList<>();
        myDeque.addLast(5);
        myDeque.addLast(3);
        myDeque.addLast(1);
        myDeque.addFirst(2);
        System.out.println(myDeque);
        myDeque.remove();
        System.out.println(myDeque);
        myDeque.removeLast();
        myDeque.removeFirst();
        while(!myDeque.isEmpty()){
            Integer val = myDeque.remove();
            System.out.print(val + " ");
        }

        System.out.println("----------- Queue ------------");
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(4);
        q.add(10);
        q.add(1);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
