package chapter4.p10;

import java.util.Random;

/*
 * Random Node: You are implementing a binary tree class from scratch which, in addition to insert, find, and delete,
 * has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be
 * chosen. Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the
 * methods.
 */
public class Main {
    public static class Node {
        int key;
        int size = 0;
        Node left, right;
        public Node(int key) {
            this.key = key;
        }
    }

    public static void insert(Node node, int newKey) {
        node.size++;
        if (newKey <= node.key) {
            if (node.left == null) {
                node.left = new Node(newKey);
            } else {
                insert(node.left, newKey);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(newKey);
            } else {
                insert(node.right, newKey);
            }
        }
    }

    /**
     * TODO: THINK ABOUT when only 1 node(root) or deleting correctly on found key!
     */
    public static void delete(Node current, Node previous, int deleteKey) {
        if (current != null) {
            if (current.key == deleteKey) {
                previous.left = current.left;
                previous.right = current.right;
            } else {
                previous = current;
                if (deleteKey < current.key) {
                    current = current.left;
                } else {
                    current = current.right;
                }
                delete(current, previous, deleteKey);
            }
        }
    }

    public static Node getRandomNode(Node current) {
        int leftSize = current.left == null ? 0 : current.left.size;
        Random random = new Random();
        int index = random.nextInt(current.size);
        if (index < leftSize) {
            return getRandomNode(current.left);
        } else if (index == leftSize) {
            return current.left;
        } else {
            return getRandomNode(current.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
    }
}
