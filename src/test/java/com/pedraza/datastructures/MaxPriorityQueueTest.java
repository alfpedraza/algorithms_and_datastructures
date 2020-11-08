package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class MaxPriorityQueueTest extends TestBase {

    MaxPriorityQueue<Integer> queue;

    @Test
    public void insertShouldKeeptheMaxAtRoot() {
        queue = new MaxPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)5, queue.peek());
    }

    @Test
    public void insertShouldKeeptheMaxAtRootWithDuplicates() {
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
    public void insertShouldKeepTheOrderAfterResizeCapacity() {
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

}