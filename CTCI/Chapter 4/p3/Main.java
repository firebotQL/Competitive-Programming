import java.util.*;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g. if you have a tree with depth D, you'll have D linked lists).
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
        Node root = generateTree();
        Queue<Node> queue1 = new LinkedList();
        Queue<Node> queue2 = new LinkedList();
        List<List<Node>> D = new ArrayList<List<Node>>();
        queue1.offer(root);
        while(!queue1.isEmpty()) {
            List<Node> levelList = new ArrayList<Node>();
            while(!queue1.isEmpty()) {
                Node current = queue1.poll();
                levelList.add(current);
                if (current.left != null) {
                    queue2.offer(current.left);
                }
                if (current.right != null) {
                    queue2.offer(current.right);
                }
            }
            D.add(levelList);
            Queue<Node> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        for(int i = 0; i < D.size(); i++) {
            List<Node> dlist  = D.get(i);
            System.out.print("Level " + (i+1)  + ": ");
            for(Node node : dlist) {
                System.out.print(node.key + " ");
            }
            System.out.println();
        }
    }

    public static Node generateTree() {
        Node root = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        return root;
    }

}
