package com.bazlur.datastructure.stack;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ArrayStackTest {

    @Test
    public void test() {
        ArrayStack<Integer> integerStack = new ArrayStack<>(Integer.class);
        integerStack.push(4);
        integerStack.push(5);
        integerStack.push(7);

        assertEquals(integerStack.size(), 3);
        assertEquals(integerStack.pop(), (Integer)7);
        assertEquals(integerStack.size(), 2);
        assertEquals(integerStack.peek(), (Integer)5);

        integerStack.clear();
        assertEquals(integerStack.size(), 0);
    }
}