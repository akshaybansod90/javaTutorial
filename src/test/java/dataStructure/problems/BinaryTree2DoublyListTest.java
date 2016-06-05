package dataStructure.problems;

import dataStructure.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akky on 08-05-2016.
 */
public class BinaryTree2DoublyListTest {

    @Test
    public void getDoublyListFromBinaryTree() throws Exception {
        Integer[] arr = {5,4,3,2,7,6};
        BinaryTree.Node<Integer> root = Preorder2BST.preorder2BST(arr,0,arr.length-1);

        BinaryTree.Node<Integer> head = new BinaryTree2DoublyList<Integer>().getDoublyListFromBinaryTree(root);

        Integer prev = Integer.MIN_VALUE;
        while (head!=null){
            assertTrue(prev<=head.getData());
            head=head.getRight();
        }
    }
}