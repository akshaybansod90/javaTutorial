package dataStructure.problems;

/**
 * Created by Akshay on 6/6/2016.
 */
import dataStructure.BinaryTree;

public class BinarySearchTreeInsertion<T extends Comparable>{

    BinaryTree.Node<T> root ;

    public BinarySearchTreeInsertion(T[] t) {
        root = Preorder2BST.preorder2BST(t, 0, t.length - 1);
    }

    public boolean insert(T t){

        BinaryTree.Node<T> node = root;
        BinaryTree.Node<T> parent = null;

        while (true) {
            if (node.getData().equals(t)) {
                return false;
            }
            parent = node;
            if (node.getData().compareTo(t) < 0) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
            if (node == null) {
                node = new BinaryTree.Node<T>();
                node.setData(t);
                if (parent.getData().compareTo(t)<0)
                    parent.setRight(node);
                else
                    parent.setLeft(node);
                break;
            }
        }
        return true;
    }

}
