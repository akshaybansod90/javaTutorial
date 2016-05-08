package org.focuslab.dataStructure.problems;

import org.focuslab.dataStructure.BinaryTree;

import java.util.Deque;

/**
 * Created by Akky on 07-05-2016.
 */
public class BinaryTree2DoublyList<T> {

    private BinaryTree.Node<T> head = null;
    private BinaryTree.Node<T> previous = null;

    public BinaryTree.Node<T> getDoublyListFromBinaryTree(BinaryTree.Node<T> root){

        if(root==null)
                return null;

        getDoublyListFromBinaryTree(root.getLeft());


        root.setLeft(previous);
        if (head==null)
            head = root;
        if (previous!=null)
            previous.setRight(root);

        previous = root;

        getDoublyListFromBinaryTree(root.getRight());

        return head;
    }



}
