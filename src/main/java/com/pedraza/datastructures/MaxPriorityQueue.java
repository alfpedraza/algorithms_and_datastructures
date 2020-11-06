package com.pedraza.datastructures;

public class MaxPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {

    public MaxPriorityQueue() { super(); }
    public MaxPriorityQueue(int theCapacity) { super(theCapacity); }

    protected int compare(T v1, T v2) {
        return v1.compareTo(v2) * -1;
    }
    
}