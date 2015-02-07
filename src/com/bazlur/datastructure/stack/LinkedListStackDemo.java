package com.bazlur.datastructure.stack;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/7/15.
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack<Integer> integerStack = new LinkedListStack<>();
        integerStack.push(4);
        integerStack.push(5);
        integerStack.push(7);

        assert integerStack.size() == 3;
        assert integerStack.pop() == 7;

        assert integerStack.size() == 2;
        assert integerStack.peek() == 5;

        integerStack.clear();
        assert integerStack.size() == 0;

        System.out.println("Stack properly worked");
    }
}
