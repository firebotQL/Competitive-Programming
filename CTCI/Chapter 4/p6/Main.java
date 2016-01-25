/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search
 * tree. You may assume that each node has a link to its parent.
 */
public class Main {
    public static class Node {
        int key;
        Node left, right, parent;
        public Node(int key) {
            this.key = key;
        }
    }

    public static Node insert(Node node , int key) {
        if (node == null) {
            return new Node(key);
        }

        if (node.key >= key) {
            Node tmp = insert(node.left, key);
            node.left = tmp;
            tmp.parent = node;
        } else {
            Node tmp = insert(node.right, key);
            node.right = tmp;
            tmp.parent = node;
        }

        return node;
    }

    public static Node find(Node node, int key) {
        Node current = node;
        while(current != null) {
            if (current.key < key) {
                current = current.right;
            } else if (current.key > key) {
                current = current.left;
            } else {
                break;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Node root = insert(null, 20);
        insert(root, 8);
        insert(root, 22);
        insert(root, 4);
        insert(root, 12);
        insert(root, 10);
        insert(root, 14);

        Node eight = find(root, 8);
        Node ten = find(root, 10);
        Node fourteen = find(root, 14);

        Node successor = getSuccessor(eight);
        System.out.println("Successor of 8 is: " + successor.key);
        successor = getSuccessor(ten);
        System.out.println("Successor of 10 is: " + successor.key);
        successor = getSuccessor(fourteen);
        System.out.println("Successor of 14 is: " + successor.key);
    }

    private static Node getSuccessor(Node current) {
        if (current.right != null) {
           return getMinimum(current.right);
        }

        Node parent = current.parent;
        while (parent != null && parent.right == current) {
            current = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static Node getMinimum(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
