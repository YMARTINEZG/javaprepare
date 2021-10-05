package com.sigom.LinkedList;

public class ListImpl implements IList{
    private Node root;
    private int size;

    public ListImpl(Object[] listData) {
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
    public void addItem(Object item) {
        Node current = root;
        while (current !=null) {
            current = root.next;
        }
        current = new Node(item, null);
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

}
