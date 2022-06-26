package com.sigom.LinkedList;

public class Main {
    public static void main(String[] args){
//        String[] mylist = new String[]{"alpha", "red", "timba", "laneta"};
//        IList myList = new ListImpl(mylist);
//        System.out.println(myList.getItem(1));
//        System.out.println(myList.getItem(0));
//        myList.removeItem(2);
//        System.out.println(myList.getItem(2));

        IList myList = new ListImpl();
        myList.addItem(6);
        myList.addItem(21);
        myList.addItem(2);
        System.out.println(myList.length());
        myList.printList();
        myList.reverseList();
        myList.printList();
    }
}
