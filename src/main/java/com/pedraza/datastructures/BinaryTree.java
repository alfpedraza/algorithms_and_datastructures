package com.pedraza.datastructures;

public class BinaryTree<T> {

    public BinaryTreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    protected void inOrderProcessing(BinaryTreeNode<T> node) { }
    protected void preOrderProcessing(BinaryTreeNode<T> node) { }
    protected void postOrderProcessing(BinaryTreeNode<T> node) { }

    public void traverseInOrder() { traverseInOrder(root); }
    public void traversePreOrder() { traversePreOrder(root); }
    public void traversePostOrder() { traversePostOrder(root); }

    private void traverseInOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        traverseInOrder(node.left);
        inOrderProcessing(node);
        traverseInOrder(node.right);
    }

    private void traversePreOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        preOrderProcessing(node);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    private void traversePostOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        postOrderProcessing(node);
    }
}
