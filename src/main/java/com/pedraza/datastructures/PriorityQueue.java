package com.pedraza.datastructures;

import javax.management.RuntimeErrorException;

public abstract class PriorityQueue<T extends Comparable<T>> {

    private static int DEFAULT_CAPACITY = 16;

    private ArrayList<T> data;

    public PriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public PriorityQueue(int theCapacity) {
        data = new ArrayList<T>(theCapacity);
    }

    public int capacity() { return data.capacity(); }
    public int size() { return data.size(); }
    public boolean isEmpty() { return data.isEmpty(); }
    public T[] toArray() { return data.toArray(); }
    public T peek() { return data.get(0); }

    public void add(T value) {
        data.add(value);
        insert(data.size() - 1, value);
    }

    private void insert(int index, T value) {
        int parentIndex = getParent(index);
        T parent = data.get(parentIndex);
        if (compare(parent, value) > 0) {
            swap(index, parentIndex);
            insert(parentIndex, value);
        }
    }

    public T poll() {
        if (data.isEmpty()) return null;
        T value = peek();
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        heapify(0);
        return value;
    }

    private void heapify(int index) {
        int leftIndex = getLeft(index);
        int rightIndex = getRight(index);
        int parentIndex = index;
        
        if (leftIndex < data.size()) {
            T parent = data.get(parentIndex); 
            T left = data.get(leftIndex);
            if (compare(parent, left) > 0)
                parentIndex = leftIndex;
        }

        if (rightIndex < data.size()) {
            T parent = data.get(parentIndex); 
            T right = data.get(rightIndex);
            if (compare(parent, right) > 0)
                parentIndex = rightIndex;
        }
        
        if (parentIndex != index) {
            swap(parentIndex, index);
            heapify(parentIndex);
        }
    }

    protected abstract int compare(T v1, T v2);
    private int getParent(int index) { return (index - 1) / 2; }
    private int getLeft(int index) { return (2 * index) + 1; }
    private int getRight(int index) { return (2 * index) + 2; }

    private void swap(int i, int j) {
        T temp = data.get(j);
        data.set(j, data.get(i));
        data.set(i, temp);
    }
}
