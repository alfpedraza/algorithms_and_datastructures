package com.pedraza.algorithms;

import static org.junit.Assert.*;

import com.pedraza.datastructures.BTNode;
import com.pedraza.datastructures.BinaryTree;

import org.junit.Test;

public class TreeDepthFirstSearchTest {

    BinaryTree<Integer> tree;
    TreeDephtFirstSearch<Integer> search;

    // #########################
    // ## Recursive Method    ##
    // #########################

    @Test
    public void searchShouldReturnNodeWhenFound() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(1);
        Node expected = (Node) tree.root.left.left;
        assertEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnNullWhenNotFound() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(10);
        Node expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnNodeWhenFoundLeft() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(2);
        Node expected = (Node) tree.root.left.right;
        assertEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnNodeWhenFoundRight() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.search(7);
        Node expected = (Node) tree.root.right.right;
        assertEquals(expected, actual);
    }

    // #########################
    // ## No Recursive Method ##
    // #########################

    @Test
    public void searchNoRecursiveShouldReturnNodeWhenFound() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.searchNoRecursive(1);
        Node expected = (Node) tree.root.left.left;
        assertEquals(expected, actual);
    }

    @Test
    public void searchNoRecursiveShouldReturnNullWhenNotFound() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.searchNoRecursive(10);
        Node expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void searchNoRecursiveShouldReturnNodeWhenFoundLeft() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.searchNoRecursive(2);
        Node expected = (Node) tree.root.left.right;
        assertEquals(expected, actual);
    }

    @Test
    public void searchNoRecursiveShouldReturnNodeWhenFoundRight() {
        tree = buildTree();
        search = new TreeDephtFirstSearch<Integer>(tree);
        Node actual = (Node) search.searchNoRecursive(7);
        Node expected = (Node) tree.root.right.right;
        assertEquals(expected, actual);
    }

    private BinaryTree<Integer> buildTree() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.root = new Node(4);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(2);
        tree.root.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        return tree;
    }

    private class Node extends BTNode<Integer> { public Node(Integer v) { super(v); } }
    
}