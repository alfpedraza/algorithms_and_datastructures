package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class MinPriorityQueueTest extends TestBase {

    MinPriorityQueue<Integer> queue;

    @Test
    public void addShouldKeeptheMinAtRoot() {
        queue = new MinPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)1, queue.peek());
    }

    @Test
    public void addShouldKeeptheMinAtRootWithDuplicates() {
        queue = new MinPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)1, queue.peek());
    }

    @Test
    public void addShouldKeepTheOrderAfterResizeCapacity() {
        queue = new MinPriorityQueue<Integer>(1);
        queue.add(3);
        queue.add(4);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        queue.add(2);
        assertEquals((Integer)1, queue.peek());
    }

    @Test
    public void pollShouldKeeptheMinAtRoot() {
        queue = new MinPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)1, queue.poll());
        assertEquals((Integer)2, queue.poll());
        assertEquals((Integer)3, queue.poll());
        assertEquals((Integer)4, queue.poll());
        assertEquals((Integer)5, queue.poll());
    }

    @Test
    public void pollShouldReturnNullWhenQueueEmpty() {
        queue = new MinPriorityQueue<Integer>();
        assertEquals((Integer)null, queue.poll());
    }

    @Test
    public void pollShouldReturnNullWhenQueueEmptyAfterAdd() {
        queue = new MinPriorityQueue<Integer>();
        queue.add(2);
        queue.add(1);
        assertEquals((Integer)1, queue.poll());
        assertEquals((Integer)2, queue.poll());
        assertEquals((Integer)null, queue.poll());
    }

}