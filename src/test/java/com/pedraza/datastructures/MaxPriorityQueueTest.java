package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class MaxPriorityQueueTest extends TestBase {

    MaxPriorityQueue<Integer> queue;

    @Test
    public void addShouldKeeptheMaxAtRoot() {
        queue = new MaxPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)5, queue.peek());
    }

    @Test
    public void addShouldKeeptheMaxAtRootWithDuplicates() {
        queue = new MaxPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)5, queue.peek());
    }

    @Test
    public void addShouldKeepTheOrderAfterResizeCapacity() {
        queue = new MaxPriorityQueue<Integer>(1);
        queue.add(3);
        queue.add(4);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        queue.add(2);
        assertEquals((Integer)5, queue.peek());
    }

    @Test
    public void pollShouldKeeptheMaxAtRoot() {
        queue = new MaxPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)5, queue.poll());
        assertEquals((Integer)4, queue.poll());
        assertEquals((Integer)3, queue.poll());
        assertEquals((Integer)2, queue.poll());
        assertEquals((Integer)1, queue.poll());
    }

    @Test
    public void pollShouldReturnNullWhenQueueEmpty() {
        queue = new MaxPriorityQueue<Integer>();
        assertEquals((Integer)null, queue.poll());
    }

    @Test
    public void pollShouldReturnNullWhenQueueEmptyAfterAdd() {
        queue = new MaxPriorityQueue<Integer>();
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)2, queue.poll());
        assertEquals((Integer)1, queue.poll());
        assertEquals((Integer)null, queue.poll());
    }

}