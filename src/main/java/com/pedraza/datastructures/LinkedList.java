package com.pedraza.datastructures;

public class LinkedList<T> {
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
}