/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily
 * a binary search tree.
 */
public class Main {
    public static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
        }
    }

    public static class Tracker {
        int found = 0;
    }

    public static Node findFCA(Node node, int key1, int key2, Tracker tracker) {
        if (node == null) {
            return null;
        }

        if (node.key == key1 || node.key == key2) {
            tracker.found++;
            return node;
        }

        Node left = findFCA(node.left, key1, key2, tracker);
        Node right = findFCA(node.right, key1, key2, tracker);

        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

    public static boolean contains(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (node.key == key) {
            return true;
        }

        return contains(node.left, key) || contains(node.left, key);
    }

    public static Node findFCA(Node node, int key1, int key2) {
        Tracker tracker = new Tracker();
        Node foundNode = findFCA(node, key1, key2, tracker);
        if (key1 != key2) {
            if (tracker.found == 2) {
                return foundNode;
            }
            if (tracker.found == 1 && contains(node, key1) && contains(node, key2)) {
                return foundNode;
            }
        } else {
            if (tracker.found == 1) {
                return foundNode;
            }
        }
        return null;
    }

    // Assuming no duplicates in the binary tree
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node found = findFCA(root, 3, 10);
        System.out.println("First Common Ancestor (3, 10) : " + (found == null ? "not found" : found));   // case when node on of nodes doesn't exist
        System.out.println("First Common Ancestor (3, 4) : " + findFCA(root,3, 4).key);
        System.out.println("First Common Ancestor (4, 5) : " + findFCA(root, 4, 5).key);
        System.out.println("First Common Ancestor (2, 4) : " + findFCA(root,2, 4).key);
        System.out.println("First Common Ancestor (4, 6) : " + findFCA(root,4, 6).key);
    }
}
