package com.pedraza.datastructures;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class BinaryTreeTest extends TestBase {

    @Test
    public void traverseInOrder() {
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.setRoot(buildTraverseRoot());
        tree.traverseInOrder();
        Object[] expected = new Integer[] { 3, 2, 4, 1, 6, 5, 7 };
        Object[] actual = tree.data.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void traversePreOrder() {
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.setRoot(buildTraverseRoot());
        tree.traversePreOrder();
        Object[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        Object[] actual = tree.data.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void traversePostOrder() {
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.setRoot(buildTraverseRoot());
        tree.traversePostOrder();
        Object[] expected = new Integer[] { 3, 4, 2, 6, 7, 5, 1 };
        Object[] actual = tree.data.toArray();
        assertArrayEquals(expected, actual);
    }

    private Node buildTraverseRoot() {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.getLeft().setLeft(new Node(3));
        root.getLeft().setRight(new Node(4));
        root.setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));
        return root;
    }

    private class Node extends BinaryTreeNode<Integer> { public Node(Integer v) { super(v); } }

    private class TraverseBinaryTree extends BinaryTree<Integer> {
        public ArrayList<Integer> data = new ArrayList<Integer>();
        protected void inOrderProcessing(BinaryTreeNode<Integer> node) { data.add(node.getValue()); }
        protected void preOrderProcessing(BinaryTreeNode<Integer> node) { data.add(node.getValue()); }
        protected void postOrderProcessing(BinaryTreeNode<Integer> node) { data.add(node.getValue()); }
    }
}