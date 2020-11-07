package com.pedraza.algorithms;

import com.pedraza.datastructures.BTNode;
import com.pedraza.datastructures.BinaryTree;

public class TreeDephtFirstSearch<T extends Comparable<T>> {

    private BinaryTree<T> tree;

    public TreeDephtFirstSearch(BinaryTree<T> tree) {
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
    
}
