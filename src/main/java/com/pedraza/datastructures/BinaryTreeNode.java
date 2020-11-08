package com.pedraza.datastructures;

public class BinaryTreeNode<T> {

    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public T getValue() { return value; }
    public BinaryTreeNode<T> getLeft() { return left; }
    public BinaryTreeNode<T> getRight() { return right; }
    
    public void setLeft(BinaryTreeNode<T> value) { left = value; }
    public void setRight(BinaryTreeNode<T> value) { right = value; }

    public BinaryTreeNode(T v) {
        value = v;
        left = null;
        right = null;
    }
}
