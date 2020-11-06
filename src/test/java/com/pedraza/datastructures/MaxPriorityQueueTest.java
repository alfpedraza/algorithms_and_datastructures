package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class MaxPriorityQueueTest extends TestBase {

    MaxPriorityQueue<Integer> queue;

    @Test
    public void insertShouldKeeptheMaxAtRoot() {
        queue = new MaxPriorityQueue<Integer>();
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(1);
        queue.insert(2);
        assertEquals((Integer)5, queue.peek());
    }

    @Test
    public void insertShouldKeeptheMaxAtRootWithDuplicates() {
        queue = new MaxPriorityQueue<Integer>();
        queue.insert(3);
        queue.insert(4);
        queue.insert(4);
        queue.insert(5);
        queue.insert(1);
        queue.insert(2);
        assertEquals((Integer)5, queue.peek());
    }

    @Test
    public void insertShouldKeepTheOrderAfterResizeCapacity() {
        queue = new MaxPriorityQueue<Integer>(1);
        queue.insert(3);
        queue.insert(4);
        queue.insert(4);
        queue.insert(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(2);
        assertEquals((Integer)5, queue.peek());
    }

}