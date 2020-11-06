package com.pedraza.datastructures;

public class Stack<T> {

    Node tail;
    int nodeCount;

    public class Node {
        T value;
        Node prev;
        public Node(T v) {
            value = v;
            prev = null;
        }
    }

    public int size() { return nodeCount; }
    public boolean isEmpty() { return nodeCount == 0; }
    public T peek() { return tail.value; }

    public void push(T value) {
        Node node = new Node(value);
        Node prev = tail;
        tail = node;
        tail.prev = prev;
        nodeCount++;
    }

    public T pop() {
        T value = tail.value;
        Node prev = tail.prev;
        tail.value = null;
        tail.prev = null;
        tail = null;
        tail = prev;
        nodeCount--;
        return value;
    }
}
