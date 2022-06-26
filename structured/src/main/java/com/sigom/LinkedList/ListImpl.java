package com.sigom.LinkedList;

public class ListImpl implements IList{
    Node root;
    int size;
    public ListImpl(){
        root = null;
        size = 0;
    }
    public ListImpl(Integer[] listData) {
        root = new Node(null, null);
        Node current = root;
        for (int j=0; j < listData.length; j++){
            current.next = new Node(listData[j], null);
            current = current.next;
        }
        size=listData.length;
    }

    @Override
    public Object getItem(int i) {
        if (size == 0 ){
            throw new IndexOutOfBoundsException();
        }
        if (i > size) {
            throw new IndexOutOfBoundsException();
        }
        int index = -1;
        Node current = root;
        while(index < i){
            index++;
            current=current.next;
        }

        return current.data;
    }

    @Override
    public void addItem(Integer item) {
        if (root == null) {
            root = new Node(item, null);
            size++;
            return;
        }
        Node previous = root;
        Node current = root.next;
        while (current !=null) {
            previous = current;
            current = current.next;
        }
        previous.next = new Node(item, null);
        size++;
    }

    @Override
    public boolean addItem(Object item, int i) {
        return false;
    }

    @Override
    public Object removeItem(int i) {
        if (i > size) {
            throw new IndexOutOfBoundsException();
        }
        int index = -1;
        Node current = root;
        while (index < i){
            current = current.next;
            index++;
        }
        size--;
        return current;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void printList() {
        Node current = root;
        System.out.println();
        System.out.print("[");
        while(current !=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    @Override
    public void reverseList() {
        Node newList = null;
        Node prev = root;
        while(prev != null){
            if (newList == null) {
                newList=new Node(prev.data, null);
            } else {
                Node temp = newList;
                newList = new Node(prev.data, null);
                newList.next = temp;
            }
            prev = prev.next;
        }
        root =  newList;
    }

}
