package com.pedraza.datastructures;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private int nodeCount;
    private Node first;
    private Node last;

    public class Node {
        public T value;
        public Node next;
        public Node(T v) {
            value = v;
            next = null;
        }
    }

    public LinkedList() {
        nodeCount = 0;
        first = null;
        last = null;
    }

    public int size() { return nodeCount; }
    public boolean isEmpty() { return nodeCount > 0; }

    public T get(int index) {
        Node current = getNode(index);
        return current.value;
    }

    public void set(int index, T value) {
        Node current = getNode(index);
        current.value = value;
    }

    public Node getNode(int index) {
        Node current = first;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void add(T value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        nodeCount++;
    }

    public void insertAfter(int index, T value) {
        Node node = new Node(value);
        Node current = getNode(index);
        node.next = current.next;
        current.next = node;
        if (index == nodeCount - 1) {
            last = node;
        }
        nodeCount++;
    }

    public T remove(int index) {
        // Get current, previous
        Node current = first;
        Node previous = null;
        for(int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        // Link current, head and tail
        if (previous != null) {
            previous.next = current.next;
        }
        if (index == 0) {
            first = current.next;
        }
        if (index == nodeCount - 1) {
            last = previous;
        }

        // Return value and remove node
        T value = current.value;
        current.value = null;
        current.next = null;
        current = null;
        nodeCount--;
        return value;
    }

    public void clear() {
        if (first == null) return;
        while (nodeCount > 0) {
            remove(0);
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        int nextIndex = 0;
        Node nextNode = null;

        public LinkedListIterator() {
            nextIndex = 0;
            nextNode = first;
        }

        public boolean hasNext() { return nextIndex < nodeCount; }

        public T next() {
            T value = nextNode.value;
            nextNode = nextNode.next;
            nextIndex++;
            return value;
        }
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (T item : this) {
            arrayList.add(item);
        }
        return arrayList;
    }

    public T[] toArray() {
        return toArrayList().toArray();
    }
}