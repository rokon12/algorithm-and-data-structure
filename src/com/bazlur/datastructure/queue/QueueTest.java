package com.bazlur.datastructure.queue;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class QueueTest {
    @Test
    public void test() {
        Queue<Integer> integerQueue = new Queue<>();
        assertEquals(0, integerQueue.size());

        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);

        assertEquals(4, integerQueue.size());
        assertEquals(1, (int) integerQueue.peek());
        assertEquals(1, (int) integerQueue.dequeue());

        assertEquals(3, integerQueue.size());
        assertEquals(2, (int) integerQueue.dequeue());
        assertEquals(3, (int) integerQueue.dequeue());
        assertEquals(4, (int) integerQueue.dequeue());

        assertEquals(0, integerQueue.size());

        QueueArray<Integer> integerQueueArray = new QueueArray<>(Integer.class);
        assertEquals(0, integerQueueArray.size());

        integerQueueArray.enqueue(1);
        integerQueueArray.enqueue(2);
        integerQueueArray.enqueue(3);
        integerQueueArray.enqueue(4);

        assertEquals(4, integerQueueArray.size());
        assertEquals(1, (int) integerQueueArray.peek());
        assertEquals(1, (int) integerQueueArray.dequeue());

        assertEquals(3, integerQueueArray.size());
        assertEquals(2, (int) integerQueueArray.dequeue());
        assertEquals(3, (int) integerQueueArray.dequeue());
        assertEquals(4, (int) integerQueueArray.dequeue());

        assertEquals(0, integerQueueArray.size());

    }
}