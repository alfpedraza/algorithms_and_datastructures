package com.pedraza.datastructures;

public class Queue<T> {

    private Node first;
    private Node last;
    private int nodeCount;

    public class Node {
        T value;
        Node prev;
        Node next;
        public Node(T v) {
            value = v;
            prev = null;
            next = null;
        }
    }

    public int size() { return nodeCount; }
    public boolean isEmpty() { return nodeCount == 0; }
    public T peek() { return first.value; }

    public void add(T value) {
        Node node = new Node(value);
        Node prev = last;
        if (first == null) first = node;
        last = node;
        last.prev = prev;
        if (prev != null) prev.next = node;
        nodeCount++;
    }

    public T poll() {
        T value = first.value;
        Node next = first.next;
        first.value = null;
        first.prev = null;
        first.next = null;
        first = null;
        first = next;
        nodeCount--;
        return value;
    }
}
