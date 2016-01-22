/**
 * Check Balanced. Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
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
        Node balanced = generateBalancedTree();
        Node unbalanced = generateUnbalancedTree();
        System.out.println("Is tree balanced: " + isTreeBalanced(balanced));
        System.out.println("Is tree unbalanced: " + isTreeBalanced(unbalanced));
    }

    public static boolean isTreeBalanced(Node root) {
        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2;
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getHeight(node.left) + getHeight(node.right);
    }

    public static Node generateBalancedTree() {
        Node root = new Node(5);
        insert(root, 3);
        insert(root, 2);
        insert(root, 4);
        insert(root, 7);
        insert(root, 6);
        insert(root, 8);
        return root;
    }

    public static Node generateUnbalancedTree() {
        Node root = new Node(5);
        for(int i = 6; i < 15; i++) {
            insert(root, i);
        }
        return root;
    }

    public static void insert(Node node, int key) {
        Node newNode = new Node(key);
        while(true) {
            if (node.key > newNode.key) {
                if (node.left == null) {
                    node.left = newNode;
                    return;
                }
               node = node.left;
            } else if (node.key < newNode.key) {
                if (node.right == null) {
                    node.right = newNode;
                    return;
                }
                node = node.right;
            }
        }
    }
}
