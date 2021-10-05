package com.sigom.LinkedList;

public class Main {
    public static void main(String[] args){

        String[] mylist = new String[]{"alpha", "red", "timba", "laneta"};
        IList myList = new ListImpl(mylist);

        System.out.println(myList.getItem(1));
        System.out.println(myList.getItem(0));
        myList.removeItem(2);
        System.out.println(myList.getItem(2));
        System.out.println(myList.length());

    }
}
