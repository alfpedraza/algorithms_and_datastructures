package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest extends TestBase {

    LinkedList<Integer> list;
    LinkedList<Integer>.Node first;
    LinkedList<Integer>.Node last;

    @Test
    public void sizeShouldBeZeroWhenCreated() {
        list = new LinkedList<Integer>();
        assertEquals(0, list.size());
    }

    @Test
    public void firstAndLastShouldPointSameNodeWhenCreated() {
        list = new LinkedList<Integer>();
        list.add(1);
        first = getFirst();
        last = getLast();
        assertEquals(first, last);
    }

    @Test
    public void lastShouldPointToLastElement() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.remove(1);
        list.add(4);
        LinkedList<Integer>.Node node = list.getNode(1);
        last = getLast();
        assertEquals(node, last);
    }

    @Test
    public void firstShouldPointToFirstElement() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        LinkedList<Integer>.Node node = list.getNode(0);
        first = getFirst();
        assertEquals(node, first);
    }

    @Test
    public void firstShouldBeNullWhenListEmpty() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        first = getFirst();
        assertEquals(first, null);
    }

    @Test
    public void lastShouldBeNullWhenListEmpty() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        last = getLast();
        assertEquals(last, null);
    }

    @Test
    public void firstShouldNotBeNullWhenRemoveItem() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.remove(1);
        first = getFirst();
        assertEquals(first.value, (Integer)1);
    }

    @Test
    public void firstShouldBeUpdatedWhenRemoveItem() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        list.remove(0);
        first = getFirst();
        assertEquals(first.value, (Integer)3);
    }

    @Test
    public void lastShouldBeNotNullWhenRemoveItem() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        list.remove(1);
        last = getLast();
        assertEquals(last.value, (Integer)1);
    }

    @Test
    public void insertAfterShouldWork() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.insertAfter(0, 2);
        assertEquals(list.get(1), (Integer)2);
    }

    @Test
    public void insertAfterShouldWorkWhenInsertLast() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.insertAfter(2, 4);
        assertEquals(list.get(3), (Integer)4);
    }

    @Test
    public void insertAfterShouldKeepLast() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.insertAfter(2, 4);
        last = getLast();
        assertEquals(last.value, (Integer)4);
    }

    @Test
    public void clearShouldSetFirstToNull() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        first = getFirst();
        assertEquals(first, null);
    }

    @Test
    public void clearShouldSetLastToNull() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        last = getLast();
        assertEquals(last, null);
    }

    @Test
    public void iteratorShoudlReturnDataInOrder() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Object[] expected = new Object[] { 1, 2, 3, 4, 5 };
        Object[] actual = (Object[]) list.toArray();
        assertArrayEquals(expected, actual);
    }

    private LinkedList<Integer>.Node getFirst() {
        return getNode("first");
    }
    private LinkedList<Integer>.Node getLast() {
        return getNode("last");
    }
    @SuppressWarnings("unchecked")
    private LinkedList<Integer>.Node getNode(String fieldName) {
        return (LinkedList<Integer>.Node)getField(list, fieldName);
    }
}