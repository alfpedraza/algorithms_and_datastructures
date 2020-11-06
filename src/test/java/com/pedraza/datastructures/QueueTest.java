package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest extends TestBase {
    
    Queue<Integer> queue;
    Queue<Integer>.Node first;
    Queue<Integer>.Node last;

    @Test
    public void sizeShouldBeZeroWhenNew() {
        queue = new Queue<Integer>();
        assertEquals(0, queue.size());
    }

    @Test
    public void sizeShouldBeUpdatedWhenQueueing() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        assertEquals(3, queue.size());
    }

    @Test
    public void sizeShouldBeUpdatedWhenDequeueing() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void sizeShouldBeUpdatedWhenQueueingAndDequeueing() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.queue(4);
        queue.queue(5);
        queue.dequeue();
        queue.queue(6);
        assertEquals(2, queue.size());
    }

    @Test
    public void firstShouldBeKeptWhenQueueing() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        first = getFirst();
        assertEquals((Integer)1, first.value);
    }

    @Test
    public void firstShouldBeUpdatedWhenDequeueing() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.dequeue();
        first = getFirst();
        assertEquals((Integer)2, first.value);
    }

    @Test
    public void lastShouldBeUpdatedWhenQueueing() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        last = getLast();
        assertEquals((Integer)2, last.value);
    }

    @Test
    public void lastShouldBeKeptWhenDequeueing() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.dequeue();
        last = getLast();
        assertEquals((Integer)2, last.value);
    }

    @Test
    public void dequeueShouldReturnRemovedValue() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        Integer value = queue.dequeue();
        assertEquals((Integer)1, value);
    }

    @Test
    public void peekShouldReturnFirstValue() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.dequeue();
        queue.dequeue();
        queue.queue(3);
        Integer value = queue.peek();
        first = getFirst();
        assertEquals(value, first.value);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoItems() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.dequeue();
        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenItems() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void sizeShouldReturnNodeCount() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        assertEquals(2, queue.size());
    }

    @Test
    public void sizeShouldBeZeroWhenNoItems() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void sizeShouldBeNotZeroWhenItems() {
        queue = new Queue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    private Queue<Integer>.Node getFirst() {
        return getNode("first");
    }
    private Queue<Integer>.Node getLast() {
        return getNode("last");
    }
    @SuppressWarnings("unchecked")
    private Queue<Integer>.Node getNode(String fieldName) {
        return (Queue<Integer>.Node)getField(queue, fieldName);
    }
}
