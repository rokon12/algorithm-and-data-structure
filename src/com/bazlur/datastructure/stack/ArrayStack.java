package com.bazlur.datastructure.stack;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/7/15.
 */
public class ArrayStack<Type> {

    private Type[] items;


    private int size;

    private Class<Type> clazz;

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<Type> clazz) {
        this.clazz = clazz;

        //http://stackoverflow.com/a/530289
        // using native method to create array of a type only known at run time
        // it facilitates strong typing
        // it will throw run time exception in case we pass different type
        // initialized with zero length , will grow as needed during the push
        items = (Type[]) Array.newInstance(clazz, 0);

        // alternatively we could do  ->
        // items = (Type[]) new Object[initialCapacity];
        // but this weak typing. No type checking is actually done on any of the objects passed as argument.
    }

    public void push(Type item) {
        if (size == items.length) {
            grow();
        }

        items[size] = item;
        size++;
    }

    public Type pop() {
        if (size == 0) {
            throw new RuntimeException("The stack is empty");
        }

        return items[--size];
    }

    public Type peek() {
        if (size == 0) {
            throw new RuntimeException("The stack is empty");
        }

        return items[size - 1];
    }

    public int size() {

        return size;
    }

    public void clear() {
        Arrays.fill(items, null); // clearing the array
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {

        // if the current size is 0, we will allocate 10, otherwise double it
        int newLength = size == 0 ? 10 : size * 2;

        Type[] newArray = (Type[]) Array.newInstance(clazz, newLength);
        System.arraycopy(items, 0, newArray, 0, items.length);
        items = newArray;
    }

}
