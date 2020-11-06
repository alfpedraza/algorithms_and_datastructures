package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class MinPriorityQueueTest extends TestBase {

    MinPriorityQueue<Integer> queue;

    @Test
    public void insertShouldKeeptheMinAtRoot() {
        queue = new MinPriorityQueue<Integer>();
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(1);
        queue.insert(2);
        assertEquals((Integer)1, queue.peek());
    }

    @Test
    public void insertShouldKeeptheMinAtRootWithDuplicates() {
        queue = new MinPriorityQueue<Integer>();
        queue.insert(3);
        queue.insert(4);
        queue.insert(4);
        queue.insert(5);
        queue.insert(1);
        queue.insert(2);
        assertEquals((Integer)1, queue.peek());
    }

    @Test
    public void insertShouldKeepTheOrderAfterResizeCapacity() {
        queue = new MinPriorityQueue<Integer>(1);
        queue.insert(3);
        queue.insert(4);
        queue.insert(4);
        queue.insert(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(2);
        assertEquals((Integer)1, queue.peek());
    }

}