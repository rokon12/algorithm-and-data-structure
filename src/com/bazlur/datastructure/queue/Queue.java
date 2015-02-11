package com.bazlur.datastructure.queue;

import com.bazlur.datastructure.linkedlist.SinglyLinkedList;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/12/15.
 */
public class Queue<Type> {

    private SinglyLinkedList<Type> list = new SinglyLinkedList<>();

    public void enqueue(Type type) {
        list.addLast(type);
    }

    public Type dequeue() {
        if (list.getSize() == 0) {
            throw new RuntimeException("Queue is empty");
        }
        Type value = list.getFirst();
        list.removeFirst();

        return value;
    }

    public Type peek() {
        if (list.getSize() == 0) {
            throw new RuntimeException("Queue is empty");
        }

        return list.getFirst();
    }

    public long size() {

        return list.getSize();
    }
}
