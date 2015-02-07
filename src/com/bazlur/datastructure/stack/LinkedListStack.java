package com.bazlur.datastructure.stack;

import com.bazlur.datastructure.linkedlist.SinglyLinkedList;


/**
 * @author Bazlur Rahman Rokon
 * @date 2/7/15.
 */
public class LinkedListStack<Type> {
    private SinglyLinkedList<Type> list = new SinglyLinkedList<>();

    public void push(Type item) {

        list.addFirst(item);
    }

    public Type pop() {
        if (list.getSize() == 0) {
            throw new RuntimeException("The stack is empty");
        }
        Type value = list.getFirst();
        list.removeFirst();

        return value;
    }

    public Type peek() {
        if (list.getSize() == 0) {
            throw new RuntimeException("The stack is empty");
        }

        return list.getFirst();
    }

    public void clear() {
        list.clear();
    }

    public long size() {
        return list.getSize();
    }

}
