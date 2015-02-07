package com.bazlur.datastructure.linkedlist;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/5/15.
 */
public class DoublyLinkedList<Type> {
    private Node<Type> head;
    private Node<Type> tail;
    private long size;

    private void addFirst(Node<Type> node) {
        Node<Type> temp = head;
        head = node;
        head.next = temp;
        size++;

        if (size == 1) {
            tail = head;
        } else {
            temp.previous = head;
        }
    }

    public void addFirst(Type value) {
        addFirst(new Node<>(value));
    }

    public void addLast(Node<Type> node) {
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size++;
    }

    public void removeFirst() {
        if (size != 0) {
            head = head.next;
            size--;

            if (size == 0) {
                tail = null;
            } else {
                head.previous = null;
            }
        }
    }

    public boolean remove(Type value) {
        Node<Type> current = head;
        Node<Type> previous = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                if (previous == null) {
                    removeFirst();
                } else {
                    previous.next = current.next;

                    if (current.next == null) {
                        tail = previous;
                    } else {
                        current.next.previous = previous;
                    }
                    size--;
                }

                return true;
            }

            current = current.next;
            previous = current;
        }

        return false;
    }

    public void remoteLast() {
        if (size != 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail.previous.next = null;
                tail = tail.previous;
            }
        }
    }

    private class Node<Type> {
        private Type value;
        private Node<Type> next;
        private Node<Type> previous;

        public Node(Type value) {
            this.value = value;
        }

        public Type getValue() {
            return value;
        }

        public void setValue(Type value) {
            this.value = value;
        }

        public Node<Type> getNext() {
            return next;
        }

        public void setNext(Node<Type> next) {
            this.next = next;
        }

        public Node<Type> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<Type> previous) {
            this.previous = previous;
        }
    }

}
