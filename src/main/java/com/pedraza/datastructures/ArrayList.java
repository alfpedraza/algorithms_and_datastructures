package com.pedraza.datastructures;

public class ArrayList<T> {
    private static int DEFAULT_CAPACITY = 8;

    private int size;
    private int capacity;
    private T[] data;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int theCapacity) {
        size = 0;
        capacity = theCapacity;
        data = createArray(capacity);
    }

    public int capacity() { return capacity; }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean contains(T obj) { return indexOf(obj) >= 0; }

    @SuppressWarnings("unchecked")
    private T[] createArray(int size) { return (T[]) new Object[size]; }

    public int indexOf(T obj) {
        for(int i = 0; i < capacity; i++) {
            if (data[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        return data[index];
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    public void add(T value) {
        if (size == capacity) {
            ensureCapacity();
        }
        set(size, value);
        size++;
    }

    private void ensureCapacity() {
        int newCapacity = capacity * 2;
        T[] newData = createArray(newCapacity);
        for(int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }
        data = null;
        data = newData;
        capacity = newCapacity;
    }

    public void insert(int index, T value) {
        if (size == capacity) {
            ensureCapacity();
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        size++;
    }

    public T remove(int index) {
        T value = get(index);
        set(index, null);
        for(int i = index; i < capacity - 1; i++) {
            data[i] = data[i+1];
        }
        data[capacity-1] = null;
        size--;
        return value;
    }

    public void clear() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        data = createArray(capacity);
    }

    public T[] toArray() {
        T[] result = createArray(size);
        for (int i = 0; i < size; i++) result[i] = data[i];
        return (T[]) result;
    }
}