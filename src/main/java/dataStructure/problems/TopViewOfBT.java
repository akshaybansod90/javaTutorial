package dataStructure.problems;

import dataStructure.BinaryTree;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Akshay on 6/5/2016.
 */
public class TopViewOfBT {


    public List<BinaryTree.Node<?>> topview(BinaryTree.Node<?> binaryTree) {
        SortedMap<Integer, BinaryTree.Node<?>> map = new TreeMap<>();

        Consumer<NodeElement<?>> consumer = (nodeElement) -> {
            if (!map.containsKey(nodeElement.distanceFromRoot)) {
                map.put(nodeElement.distanceFromRoot, nodeElement.node);
            }
        };

        levelOrderTraversal(binaryTree, consumer);

        return new ArrayList<>(map.values());
    }

    public void levelOrderTraversal(BinaryTree.Node<?> root, Consumer<NodeElement<?>> consumer) {
        Queue<NodeElement<?>> queue = new LinkedList<>();

        queue.add(new NodeElement<>(root, 0));

        while (!queue.isEmpty()) {
            NodeElement<?> nodeElement = queue.remove();
            if (nodeElement.node == null) {
                continue;
            }
            consumer.accept(nodeElement);
            queue.add(new NodeElement<>(nodeElement.node.getLeft(), nodeElement.distanceFromRoot - 1));
            queue.add(new NodeElement<>(nodeElement.node.getRight(), nodeElement.distanceFromRoot + 1));
        }

    }

    private class NodeElement<T> {
        BinaryTree.Node<T> node;
        int distanceFromRoot;

        public NodeElement(BinaryTree.Node<T> node, int distanceFromRoot) {
            this.node = node;
            this.distanceFromRoot = distanceFromRoot;
        }
    }

}
