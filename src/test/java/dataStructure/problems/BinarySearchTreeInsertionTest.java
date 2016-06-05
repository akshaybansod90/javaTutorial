package dataStructure.problems;

import dataStructure.BinaryTree;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/6/2016.
 */
public class BinarySearchTreeInsertionTest {
    @Test
    public void insert() throws Exception {
        Integer[] arr = {5, 4, 3, 2, 17, 16, 15, 14, 12, 11, 10, 9, 8};
        BinarySearchTreeInsertion binarySearchTreeInsertion = new BinarySearchTreeInsertion<Integer>(arr);

        binarySearchTreeInsertion.insert(13);

        BinaryTree<Integer> binaryTree = new BinaryTree<>(binarySearchTreeInsertion.root);

        List<Integer> list =  binaryTree.inorderTraversal();

        assertTrue(list.get(9).equals(13));
    }

}