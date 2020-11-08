package com.pedraza.algorithms;

import static org.junit.Assert.*;

import com.pedraza.datastructures.BinaryTreeNode;
import com.pedraza.datastructures.BinaryTree;

import org.junit.Test;

public class TreeBreadthFirstSearchTest {

    BinaryTree<Integer> tree;
    TreeBreadthFirstSearch<Integer> search;

    @Test
    public void searchShouldReturnNodeWhenFound() {
        tree = buildTree();
        search = new TreeBreadthFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(1);
        Node expected = (Node) tree.getRoot().getLeft().getLeft();
        assertEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnNullWhenNotFound() {
        tree = buildTree();
        search = new TreeBreadthFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(10);
        Node expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnNodeWhenFoundLeft() {
        tree = buildTree();
        search = new TreeBreadthFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(2);
        Node expected = (Node) tree.getRoot().getLeft().getRight();
        assertEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnNodeWhenFoundRight() {
        tree = buildTree();
        search = new TreeBreadthFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(7);
        Node expected = (Node) tree.getRoot().getRight().getRight();
        assertEquals(expected, actual);
    }

    private BinaryTree<Integer> buildTree() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.setRoot(new Node(4));
        tree.getRoot().setLeft(new Node(3));
        tree.getRoot().getLeft().setLeft(new Node(1));
        tree.getRoot().getLeft().setRight(new Node(2));
        tree.getRoot().setRight(new Node(5));
        tree.getRoot().getRight().setLeft(new Node(6));
        tree.getRoot().getRight().setRight(new Node(7));
        return tree;
    }

    private class Node extends BinaryTreeNode<Integer> { public Node(Integer v) { super(v); } }
    
}