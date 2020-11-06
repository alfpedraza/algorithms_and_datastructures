package com.pedraza.datastructures;

public class MinPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {

    public MinPriorityQueue() { super(); }
    public MinPriorityQueue(int theCapacity) { super(theCapacity); }

    protected int compare(T v1, T v2) {
        return v1.compareTo(v2);
    }
    
}