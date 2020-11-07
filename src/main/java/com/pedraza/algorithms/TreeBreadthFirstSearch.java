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
        if (tree.root == null) return null;
        Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>();
        queue.queue(tree.root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.dequeue();
            if (node.value == value) return node;
            if (node.left  != null) queue.queue(node.left);
            if (node.right != null) queue.queue(node.right);
        }
        return null;
    }

}
