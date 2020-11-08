package com.pedraza.algorithms;

import com.pedraza.datastructures.BinaryTreeNode;
import com.pedraza.datastructures.BinaryTree;
import com.pedraza.datastructures.Stack;

public class TreeDepthFirstSearch<T extends Comparable<T>> {

    private BinaryTree<T> tree;

    public TreeDepthFirstSearch(BinaryTree<T> tree) {
        this.tree = tree;
    }

    public BinaryTreeNode<T> search(T value) {
        return search(tree.getRoot(), value);
    }

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T value) {
        if (node == null) return null;
        if (node.getValue() == value) return node;

        BinaryTreeNode<T> result;
        result = search(node.getLeft(), value);
        if (result != null) return result;

        result = search(node.getRight(), value);
        if (result != null) return result;

        return null;
    }

    public BinaryTreeNode<T> searchNoRecursive(T value) {
        if (tree.getRoot() == null) return null;
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
        stack.push(tree.getRoot());
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.pop();
            if (node.getValue() == value) return node;
            if (node.getRight() != null) stack.push(node.getRight());
            if (node.getLeft()  != null) stack.push(node.getLeft());
        }
        return null;
    }
    
}
