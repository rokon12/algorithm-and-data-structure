package com.bazlur.datastructure.queue;

import java.lang.reflect.Array;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/14/15.
 */
public class QueueArray<Type> {
    private Type[] items;

    private Class<Type> clazz;

    private int size;
    private int head = 0, tail = -1;

    public QueueArray(Class<Type> clazz) {
        this.clazz = clazz;
        items = (Type[]) Array.newInstance(clazz, 0);
    }

    public void enqueue(Type item) {
        if (items.length == size) {
            int newLength = size == 0 ? 10 : size * 2;

            Type[] newArray = (Type[]) Array.newInstance(clazz, newLength);

            int targetIndex = 0;
            if (size > 0) {
                if (tail < head) {
                    for (int index = head; index < items.length; index++) {
                        newArray[targetIndex] = items[index];
                        targetIndex++;
                    }

                    for (int i = 0; i <= tail; i++) {
                        newArray[targetIndex] = items[i];
                        targetIndex++;
                    }
                } else {
                    for (int i = head; i <= tail; i++) {
                        newArray[targetIndex] = items[i];
                        targetIndex++;
                    }
                }
                head = 0;
                tail = targetIndex - 1;
            } else {
                head = 0;
                tail = -1;
            }

            items = newArray;
        }

        if (tail == items.length - 1) {
            tail = 0;
        } else {
            tail++;
        }

        items[tail] = item;
        size++;
    }

    public Type dequeue() {
        checkBoundary();

        Type value = items[head];

        if (head == items.length - 1) {
            head = 0;
        } else {
            head++;
        }

        size--;

        return value;
    }

    public Type peek() {
        checkBoundary();

        return items[head];
    }

    public int size() {
        return size;
    }

    private void checkBoundary() {
        if (size == 0) {
            throw new RuntimeException("the queue is empty ");
        }
    }
}
