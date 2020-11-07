package com.pedraza.datastructures;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public void insert(T value) { root = insert(root, value); }

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return new BinaryTreeNode<T>(value);
        } else {
            int comparison = value.compareTo(node.value);
            if (comparison == 0) {
                return node;
            } else if (comparison < 0) {
                node.left = insert(node.left, value);
            } else if (comparison > 0) {
                node.right = insert(node.right, value);
            }
        }
        return node;
    }

    public BinaryTreeNode<T> search(T value) { return search(root, value); }

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T value) {
        if (node == null) return null;
        int comparison = value.compareTo(node.value);
        BinaryTreeNode<T> result = null;
        if (comparison == 0) {
            result = node;
        } else if (comparison < 0) {
            result = search(node.left, value);
        } else if (comparison > 0) {
            result = search(node.right, value);
        }
        return result;
    }

    public int height() { return height(root); }

    public int height(BinaryTreeNode<T> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}