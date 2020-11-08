package com.pedraza.datastructures;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public void insert(T value) {
        BinaryTreeNode<T> node = insert(getRoot(), value);
        setRoot(node);
    }

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return new BinaryTreeNode<T>(value);
        } else {
            int comparison = value.compareTo(node.getValue());
            if (comparison == 0) {
                return node;
            } else if (comparison < 0) {
                node.setLeft(insert(node.getLeft(), value));
            } else if (comparison > 0) {
                node.setRight(insert(node.getRight(), value));
            }
        }
        return node;
    }

    public BinaryTreeNode<T> search(T value) {
        BinaryTreeNode<T> node = search(getRoot(), value);
        return node;
    }

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T value) {
        if (node == null) return null;
        int comparison = value.compareTo(node.getValue());
        BinaryTreeNode<T> result = null;
        if (comparison == 0) {
            result = node;
        } else if (comparison < 0) {
            result = search(node.getLeft(), value);
        } else if (comparison > 0) {
            result = search(node.getRight(), value);
        }
        return result;
    }

    public int height() { return height(getRoot()); }

    public int height(BinaryTreeNode<T> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
}