package org.focuslab.dataStructure.problems;

import org.focuslab.dataStructure.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Akky on 07-05-2016.
 */
public class Preorder2BSTTest {



    @Test
    public void preorder2BST() throws Exception {

            Integer[] arr = {5,4,3,2,7,6};
            BinaryTree.Node<Integer> tree = Preorder2BST.preorder2BST(arr,0,arr.length-1);
            int i=0;
            BinaryTree.Node<Integer> temp = tree;
            while (temp!=null){
                assertTrue(temp.getData().equals(arr[i++]));
                temp = temp.getLeft();
            }
            temp = tree.getRight();
            assertTrue(temp.getData()==arr[i++]);
            assertTrue(temp.getLeft().getData()==arr[i]);

    }


}