package org.focuslab.dataStructure.problems;

import org.focuslab.dataStructure.BinaryTree;

/**
 * Created by Akky on 07-05-2016.
 */
public class Preorder2BST {

    public static <T extends Comparable> BinaryTree.Node<T> preorder2BST(T[] preorder,int lowIndex,int highIndex){

        if (lowIndex > highIndex)
            return null;

        BinaryTree.Node<T> root = new BinaryTree.Node<T>();
        root.setData(preorder[lowIndex]);

        if (lowIndex==highIndex)
            return root;
        int pivot = -1;
        for (int i= lowIndex+1;i<=highIndex;i++){
            if (preorder[i].compareTo(preorder[lowIndex])>=0){
                pivot = i-1;
                break;
            }
        }
        if (pivot==-1){
            pivot = highIndex;
        }

        root.setLeft(preorder2BST(preorder,lowIndex+1,pivot));
        root.setRight(preorder2BST(preorder,pivot+1,highIndex));
        return root;
    }

    public static <T extends Comparable> BinaryTree<T> preorderToBST(T[] preOrder){
         return new BinaryTree<T>(preorder2BST(preOrder,0,preOrder.length-1));
    }

}
