package com.pedraza.datastructures;

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

    public void insert(T value) {
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

    protected abstract int compare(T v1, T v2);
    private int getParent(int index) { return index / 2; }

    private void swap(int i, int j) {
        T temp = data.get(j);
        data.set(j, data.get(i));
        data.set(i, temp);
    }
}
