import java.util.*;

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

    public static void setParentRelationship(Node current, Node parent, Node newValue) {
        if (parent.left == current) {
            parent.left = newValue;
        } else {
            parent.right = newValue;
        }
    }

    public static void delete(Node current, Node parent, int deleteKey) {
        if (current != null) {
            if (current.key == deleteKey) {
                if (current.left != null && current.right != null) {
                    List<Node> result = findMin(current.right);
                    Node successor = result.get(0);
                    Node successorParent = result.get(1);
                    current.key = successor.key;
                    delete(successor, successorParent, successor.key);
                } else if (current.left != null) {
                    setParentRelationship(current, parent, current.left);
                } else if (current.right != null) {
                    setParentRelationship(current, parent, current.right);
                } else {
                    setParentRelationship(current, parent, null);
                }
            } else {
                parent = current;
                if (deleteKey < current.key) {
                    current = current.left;
                } else {
                    current = current.right;
                }
                delete(current, parent, deleteKey);
            }
        }
    }

    private static List<Node> findMin(Node node) {
        Node parent = node;
        while(node.left != null) {
            parent = node;
            node = node.left;
        }
        List<Node> result = new ArrayList<Node>();
        result.add(node);
        result.add(parent);
        return result;
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
