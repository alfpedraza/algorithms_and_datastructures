package com.pedraza.algorithms;

import com.pedraza.datastructures.BTNode;
import com.pedraza.datastructures.BinaryTree;
import com.pedraza.datastructures.Stack;

public class TreeDepthFirstSearch<T extends Comparable<T>> {

    private BinaryTree<T> tree;

    public TreeDepthFirstSearch(BinaryTree<T> tree) {
        this.tree = tree;
    }

    public BTNode<T> search(T value) {
        return search(tree.root, value);
    }

    private BTNode<T> search(BTNode<T> node, T value) {
        if (node == null) return null;
        if (node.value == value) return node;

        BTNode<T> result;
        result = search(node.left, value);
        if (result != null) return result;

        result = search(node.right, value);
        if (result != null) return result;

        return null;
    }

    public BTNode<T> searchNoRecursive(T value) {
        if (tree.root == null) return null;
        Stack<BTNode<T>> stack = new Stack<BTNode<T>>();
        stack.push(tree.root);
        while (!stack.isEmpty()) {
            BTNode<T> node = stack.pop();
            if (node.value == value) return node;
            if (node.right != null) stack.push(node.right);
            if (node.left  != null) stack.push(node.left);
        }
        return null;
    }
    
}
