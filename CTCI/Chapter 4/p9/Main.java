package chapter4.p9;

import java.util.ArrayList;

/**
 * BST Sequences: A binary search tree was created by traversing through an array from left to right and inserting each
 * element. given a binary search tree with distinct elements, print all possible arrays taht could have led to this
 * tree.
 */
public class Main {
    public static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        printTree(root);
    }

    private static ArrayList<Node> printTree(Node node) {
        if (node == null) {
            return new ArrayList<Node>();
        }
        System.out.print(node.key + " ");
        ArrayList<Node> left = printTree(node.left);
        ArrayList<Node> right = printTree(node.right);
    }
}
