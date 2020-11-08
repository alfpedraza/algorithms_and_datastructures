package com.pedraza.datastructures;

public class Queue<T> {

    private Node first;
    private Node last;
    private int nodeCount;

    private class Node {
        public T value;
        public Node next;
        public Node(T v) {
            value = v;
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
        if (prev != null) prev.next = node;
        nodeCount++;
    }

    public T poll() {
        T value = first.value;
        Node next = first.next;
        first.value = null;
        first.next = null;
        first = null;
        first = next;
        nodeCount--;
        return value;
    }
}
