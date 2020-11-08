package com.pedraza.algorithms;

import com.pedraza.datastructures.BinaryTreeNode;
import com.pedraza.datastructures.BinaryTree;
import com.pedraza.datastructures.Queue;

public class TreeBreadthFirstSearch<T extends Comparable<T>> {
    
    private BinaryTree<T> tree;

    public TreeBreadthFirstSearch(BinaryTree<T> tree) {
        this.tree = tree;
    }

    public BinaryTreeNode<T> search(T value) {
        if (tree.getRoot() == null) return null;
        Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>();
        queue.queue(tree.getRoot());
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.dequeue();
            if (node.getValue() == value) return node;
            if (node.getLeft()  != null) queue.queue(node.getLeft());
            if (node.getRight() != null) queue.queue(node.getRight());
        }
        return null;
    }

}
