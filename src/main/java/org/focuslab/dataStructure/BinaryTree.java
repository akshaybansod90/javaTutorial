package org.focuslab.dataStructure;

import java.util.ArrayList;

/**
 * Created by Akky on 06-05-2016.
 */
public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public static class Node<T>{
        T data ;
        Node<T> left;
        Node<T> right;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    public ArrayList<T> preorderTraversal(){
        ArrayList<T> preorderResult = new ArrayList<T>();
        preorder(this.root,preorderResult);
        return preorderResult;
    }

    private void preorder(Node<T> root,ArrayList<T> preorderResult){
        if (root==null){
            return;
        }
        preorderResult.add(root.getData());
        preorder(root.left,preorderResult);
        preorder(root.right,preorderResult);
    }

    public ArrayList<T> inorderTraversal(){
        ArrayList<T> inorderResult = new ArrayList<T>();
        inorder(this.root,inorderResult);
        return inorderResult;
    }

    private void inorder(Node<T> root,ArrayList<T> inorderResult){
        if (root==null){
            return;
        }
        inorder(root.left,inorderResult);
        inorderResult.add(root.getData());
        inorder(root.right,inorderResult);
    }

}
