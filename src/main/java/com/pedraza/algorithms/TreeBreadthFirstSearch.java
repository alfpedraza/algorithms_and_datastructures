package com.pedraza.algorithms;

import com.pedraza.datastructures.BTNode;
import com.pedraza.datastructures.BinaryTree;
import com.pedraza.datastructures.Queue;

public class TreeBreadthFirstSearch<T extends Comparable<T>> {
    
    private BinaryTree<T> tree;

    public TreeBreadthFirstSearch(BinaryTree<T> tree) {
        this.tree = tree;
    }

    public BTNode<T> search(T value) {
        if (tree.root == null) return null;
        Queue<BTNode<T>> queue = new Queue<BTNode<T>>();
        queue.queue(tree.root);
        while (!queue.isEmpty()) {
            BTNode<T> node = queue.dequeue();
            if (node.value == value) return node;
            if (node.left  != null) queue.queue(node.left);
            if (node.right != null) queue.queue(node.right);
        }
        return null;
    }

}
