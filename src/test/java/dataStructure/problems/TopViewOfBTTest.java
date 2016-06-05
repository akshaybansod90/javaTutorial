package dataStructure.problems;

import dataStructure.BinaryTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/5/2016.
 */
public class TopViewOfBTTest {
    @Test
    public void topview() throws Exception {
        Integer[] arr = {5, 4, 3, 2, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8};
        BinaryTree.Node<Integer> tree = Preorder2BST.preorder2BST(arr, 0, arr.length - 1);

        List<BinaryTree.Node<?>> topView = new TopViewOfBT().topview(tree);

        List<Integer> result = Arrays.asList(new Integer[]{8, 9, 10, 11, 12, 2, 3, 4, 5, 17});

        assertEquals(topView.size(), result.size());

        int i = 0;
        for (BinaryTree.Node<?> node : topView) {
            assertEquals(node.getData(), result.get(i++));
        }

    }

}