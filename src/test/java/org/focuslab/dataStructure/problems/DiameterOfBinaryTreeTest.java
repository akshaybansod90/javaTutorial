package org.focuslab.dataStructure.problems;

import org.focuslab.dataStructure.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akky on 21-05-2016.
 */
public class DiameterOfBinaryTreeTest {

    @Test
    public void getDiameterOfBinaryTree() throws Exception {
        Integer[] arr = {6, 2, 1, 4, 3, 5, 7, 8, 12, 10, 9, 11, 13};
        Integer[] arr1 = {14, 13, 7, 2, 1, 6, 4, 3, 5, 8, 10, 9, 11, 12, 15, 16};
        BinaryTree.Node<Integer> root = Preorder2BST.preorder2BST(arr, 0, arr.length - 1);
        assertTrue(new DiameterOfBinaryTree().getDiameterOfBinaryTree(root) == 8);
        root = Preorder2BST.preorder2BST(arr1, 0, arr1.length - 1);
        assertTrue(new DiameterOfBinaryTree().getDiameterOfBinaryTree(root) == 8);

    }
}