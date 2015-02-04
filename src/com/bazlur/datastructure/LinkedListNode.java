package com.bazlur.datastructure;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/4/15.
 */
public class LinkedListNode<Type> {
    private Type value;
    private LinkedListNode<Type> next;

    public LinkedListNode(Type value) {
        this.value = value;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    public LinkedListNode<Type> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<Type> next) {
        this.next = next;
    }
}
