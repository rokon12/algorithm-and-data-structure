package com.bazlur.datastructure;

import java.util.LinkedList;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/4/15.
 */
public class MainApp {
    public static void main(String[] args) {
        Node first = new Node();
        first.setValue(5);

        Node middle = new Node();
        middle.setValue(4);
        first.setNext(middle);

        Node last = new Node();
        last.setValue(3);
        middle.setNext(last);

        printList(first);
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }
}
