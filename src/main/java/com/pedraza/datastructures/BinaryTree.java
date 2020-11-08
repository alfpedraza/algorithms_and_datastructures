package com.pedraza.datastructures;

public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void setRoot( BinaryTreeNode<T> value) { root = value; }
    public BinaryTreeNode<T> getRoot() { return root; }

    protected void inOrderProcessing(BinaryTreeNode<T> node) { }
    protected void preOrderProcessing(BinaryTreeNode<T> node) { }
    protected void postOrderProcessing(BinaryTreeNode<T> node) { }

    public void traverseInOrder() { traverseInOrder(root); }
    public void traversePreOrder() { traversePreOrder(root); }
    public void traversePostOrder() { traversePostOrder(root); }

    private void traverseInOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        traverseInOrder(node.getLeft());
        inOrderProcessing(node);
        traverseInOrder(node.getRight());
    }

    private void traversePreOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        preOrderProcessing(node);
        traversePreOrder(node.getLeft());
        traversePreOrder(node.getRight());
    }

    private void traversePostOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        traversePostOrder(node.getLeft());
        traversePostOrder(node.getRight());
        postOrderProcessing(node);
    }
}
