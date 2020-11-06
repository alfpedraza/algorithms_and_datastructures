package com.pedraza.datastructures;

public class BTNode<T> {

    public T value;
    public BTNode<T> left;
    public BTNode<T> right;
    public BTNode(T v) {
        value = v;
        left = null;
        right = null;
    }
}
