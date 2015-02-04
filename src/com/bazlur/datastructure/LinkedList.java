package com.bazlur.datastructure;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/4/15.
 */
public class LinkedList<Type> {
    private long size;

    private LinkedListNode<Type> head;
    private LinkedListNode<Type> tail;

    public void addFirst(Type value) {
        addFirst(new LinkedListNode<>(value));
    }

    public void addLast(Type value) {
        addLast(new LinkedListNode<>(value));
    }

    private void addLast(LinkedListNode<Type> node) {
        if (size == 0) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public void addFirst(LinkedListNode<Type> node) {
        LinkedListNode<Type> temp = head;
        head = node;
        head.setNext(temp);

        size++;

        if (size == 1) {
            tail = head;
        }
    }

    public LinkedListNode<Type> getHead() {
        return head;
    }

    public LinkedListNode<Type> getTail() {
        return tail;
    }

    public void removeFirst() {
        if (size != 0) {
            head = head.getNext();
            size--;
        }

        if (size == 0) {
            tail = null;
        }
    }

    public void removeLast() {
        if (size != 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                LinkedListNode<Type> current = head;

                while (current.getNext() != tail) {
                    current = current.getNext();
                }
                current.setNext(null);
                tail = current;

            }
            size--;
        }
    }


    // four scenario
    // 1. empty list-  do nothing
    // 2. single node : ( previous is null)
    // 3. Many nodes
    //      a. node to remove is first node
    //      b. node to remove is the middle or last

    public boolean remove(Type type) {
        LinkedListNode<Type> prev = null;
        LinkedListNode<Type> current = head;

        while (current != null) {
            if (current.getValue().equals(type)) {
                if (prev != null) {

                    // just skip the current node. it works fine
                    prev.setNext(current.getNext());

                    if (current.getNext() == null) {
                        tail = prev;
                    }

                    size--;
                } else {
                    removeFirst();
                }

                return true;
            }

            prev = current;
            current = current.getNext();
        }

        return false;
    }


    public long getSize() {

        return size;
    }

    public void print() {
        System.out.print("Total elements : " + size + " -> ");
        LinkedListNode node = head;
        while (node != null) {
            System.out.print(node.getValue().toString() +" ,");
            node = node.getNext();
        }
        System.out.println();


    }
}
