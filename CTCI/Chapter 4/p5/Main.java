/**
 * Validate BST. Implement a function to check if a binary tree is a binary search tree.
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
        Node tree1 = generateBST();
        Node tree2 = generateNonBST();
        System.out.println("Is BST: " + isBST(tree1, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("Is BST: " + isBST(tree2, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.key > min && node.key < max) {
            return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
        }
        return false;
    }


    public static Node generateBST() {
        Node node = new Node(5);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        node.left = three;
        node.right = seven;
        three.left = two;
        three.right = four;
        seven.left = six;
        seven.right = eight;
        return node;
    }

    public static Node generateNonBST() {
        Node node = new Node(5);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node six = new Node(6);
        Node seven = new Node(7);
        node.left = three;
        node.right = seven;
        three.left = two;
        three.right = four;
        seven.left = six;
        seven.right = one;
        return node;
    }
}
