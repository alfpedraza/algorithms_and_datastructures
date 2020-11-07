package com.pedraza.algorithms;

public class BinarySearch<T extends Comparable<T>> {

    private T[] data;

    public BinarySearch(T[] data) {
        this.data = data;
    }

    public T[] data() { return data; }
    
    public int binarySearch(T value) {
        return binarySearch(0, data.length - 1, value);
    }

    private int binarySearch(int first, int last, T value) {
        if (last < first) return -1;
        int mid = (first + last) / 2;
        if (data[mid] == value) return mid;
        if (data[mid].compareTo(value) > 0) {
            return binarySearch(first, mid -1, value);
        } else {
            return binarySearch(mid + 1, last, value);
        }
    }
}
