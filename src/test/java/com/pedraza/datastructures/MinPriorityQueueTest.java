package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class MinPriorityQueueTest extends TestBase {

    MinPriorityQueue<Integer> queue;

    @Test
    public void insertShouldKeeptheMinAtRoot() {
        queue = new MinPriorityQueue<Integer>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        assertEquals((Integer)1, queue.peek());
    }

    @Test
    public void insertShouldKeeptheMinAtRootWithDuplicates() {
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
    public void insertShouldKeepTheOrderAfterResizeCapacity() {
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

}