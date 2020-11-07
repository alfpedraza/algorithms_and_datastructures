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
        return search(tree.root, value);
    }

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T value) {
        if (node == null) return null;
        if (node.value == value) return node;

        BinaryTreeNode<T> result;
        result = search(node.left, value);
        if (result != null) return result;

        result = search(node.right, value);
        if (result != null) return result;

        return null;
    }

    public BinaryTreeNode<T> searchNoRecursive(T value) {
        if (tree.root == null) return null;
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
        stack.push(tree.root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.pop();
            if (node.value == value) return node;
            if (node.right != null) stack.push(node.right);
            if (node.left  != null) stack.push(node.left);
        }
        return null;
    }
    
}
