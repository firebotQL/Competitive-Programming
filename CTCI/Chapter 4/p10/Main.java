/**
 * Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm
 * to determine if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class Main {
    public static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
        }
    }

    public static boolean isSubTree(Node T1, Node T2) {
        Node newRoot = findSameRoot(T1, T2);
        return isSame(newRoot, T2);
    }

    private static boolean isSame(Node t1, Node t2) {
        if (t1 == null || t2 == null) {
            return t1 == null && t2 == null;
        }

        if (t1.key != t2.key) {
            return false;
        }

        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    private static Node findSameRoot(Node T1, Node T2) {
        if (T1 == null) {
            return null;
        }

        if (T1.key == T2.key) {
            return T1;
        }

        Node found1 = findSameRoot(T1.left, T2);
        Node found2 = findSameRoot(T1.right, T2);

        if (found1 != null) {
            return found1;
        } else {
            return found2;
        }
    }

    // Assume that nodes are unique
    public static void main(String[] args) {
        Node T1 = new Node(5);
        T1.left = new Node(3);
        T1.right = new Node(7);
        T1.left.left = new Node(2);
        T1.left.right = new Node(4);
        T1.right.left = new Node(6);
        T1.right.right = new Node(8);
        Node T2 = T1.right;

        Node T3 = new Node(7);
        T3.left = new Node(6);

        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(2);

        System.out.println(isSubTree(T1, T2));
        System.out.println(isSubTree(T1, T3));
    }
}
