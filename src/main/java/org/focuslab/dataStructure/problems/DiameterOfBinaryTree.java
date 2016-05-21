package org.focuslab.dataStructure.problems;

import org.focuslab.dataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by Akky on 20-05-2016.
 */

public class DiameterOfBinaryTree {

    public int maxLength = 0;
    public int currentDepth = 0;

    public <T> int getDiameterOfBinaryTree(BinaryTree.Node<T> root) {
        postorder(root);
        return maxLength;
    }


    private <T> int postorder(BinaryTree.Node<T> root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = postorder(root.getLeft());
        int rightDepth = postorder(root.getRight());
        if (maxLength < (leftDepth + rightDepth)) {
            maxLength = leftDepth + rightDepth;
        }
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


}
