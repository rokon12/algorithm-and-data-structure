package com.bazlur.datastructure.linkedlist;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/4/15.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> integers = new SinglyLinkedList<>();
        integers.addFirst(4);
        integers.addFirst(3);
        integers.addFirst(2);
        integers.addFirst(1);

        integers.print();

        System.out.println("Remove first and last elements..");
        integers.removeFirst();
        integers.removeLast();
        integers.print();

        System.out.println("add elements at last ");
        integers.addLast(5);
        integers.addLast(6);
        integers.addLast(7);
        integers.print();

        SinglyLinkedList<String> stringLinkedList = new SinglyLinkedList<>();
        stringLinkedList.addFirst("abcd");
        stringLinkedList.addFirst("efgh");
        stringLinkedList.addFirst("ijkl");
        stringLinkedList.addFirst("mnop");
        stringLinkedList.addFirst("qrst");
        stringLinkedList.print();
    }
}
