package com.pedraza.datastructures;

public class BinaryTree<T> {

    public BTNode<T> root;

    public BinaryTree() {
        root = null;
    }

    protected void inOrderProcessing(BTNode<T> node) { }
    protected void preOrderProcessing(BTNode<T> node) { }
    protected void postOrderProcessing(BTNode<T> node) { }

    public void traverseInOrder() { traverseInOrder(root); }
    public void traversePreOrder() { traversePreOrder(root); }
    public void traversePostOrder() { traversePostOrder(root); }

    private void traverseInOrder(BTNode<T> node) {
        if (node == null) return;
        traverseInOrder(node.left);
        inOrderProcessing(node);
        traverseInOrder(node.right);
    }

    private void traversePreOrder(BTNode<T> node) {
        if (node == null) return;
        preOrderProcessing(node);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    private void traversePostOrder(BTNode<T> node) {
        if (node == null) return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        postOrderProcessing(node);
    }
}
