package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTreeTest extends TestBase {

    @Test
    public void nodesShouldBeOrderedWhenInserted() {
        BST tree = buildBinarySearchTree();
        tree.traverseInOrder();
        Object[] expected = new Integer[] { 3, 4, 5, 10, 12, 13, 15 };
        Object[] actual = tree.data.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void nodeShouldBeFoundIfExists() {
        BST tree = buildBinarySearchTree();
        BinaryTreeNode<Integer> node = tree.search((Integer)5);
        assertNotNull(node);
    }

    @Test
    public void nodeShouldBeNullIfNotExists() {
        BST tree = buildBinarySearchTree();
        BinaryTreeNode<Integer> node = tree.search((Integer)50);
        assertNull(node);
    }

    @Test
    public void heightShouldBeWorking() {
        BST tree = buildBinarySearchTree();
        int height = tree.height();
        assertEquals(3, height);
    }

    @Test
    public void heightShouldBeZeroOnEmptyTree() {
        BST tree = new BST();
        int height = tree.height();
        assertEquals(-1, height);
    }

    private BST buildBinarySearchTree() {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(4);
        tree.insert(12);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        tree.insert(13);
        return tree;
    }

    private class BST extends BinarySearchTree<Integer> {
        public ArrayList<Integer> data = new ArrayList<Integer>();
        protected void inOrderProcessing(BinaryTreeNode<Integer> node) {
            data.add(node.getValue()); }
    }
}