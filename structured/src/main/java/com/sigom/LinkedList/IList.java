package com.sigom.LinkedList;

public interface IList {
    Object getItem(int i);

    void addItem(Object item);
    /*
     * adds the specified item at position i in the list, shifting the
     * items that are currently in positions i, i+1, i+2, etc. to the
     * right by one.  Returns false if the list is full, and true
     * otherwise.
     */
    boolean addItem(Object item, int i);

    /*
     * removes the item at position i in the list, shifting the items
     * that are currently in positions i+1, i+2, etc. to the left by
     * one.  Returns a reference to the removed object.
     */
    Object removeItem(int i);

    /* returns the number of items in the list */
    int length();

    /* returns true if the list is full, and false otherwise */
    boolean isFull();


}
