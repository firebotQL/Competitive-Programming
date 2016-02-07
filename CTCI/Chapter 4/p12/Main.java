import java.util.*;

/**
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which might be positive or
 * negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to
 * start or end at the root or a leaf, but it must go downwards (travelling only from parent nodes to child nodes).
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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(2);
        root.right.right = new Node(11);

        int result = countPathsWithSum(root, 8);
        System.out.println("Number of paths sum up to 8 equal to " + result);
    }

    public static int countPathsWithSum(Node current, int sum) {
        if (current == null) return 0;
        Map<Integer, Integer> pathCount = new HashMap<>();
        updateHashTable(pathCount, 0, 1);
        return countPathsWithSum(current, sum, 0, pathCount);
    }

    private static int countPathsWithSum(Node current, int sum, int currentSum, Map<Integer, Integer> pathCount) {
        if (current == null) return 0;

        currentSum += current.key;
        updateHashTable(pathCount, currentSum, 1);
        int newSum = currentSum - sum;
        int totalPaths = pathCount.containsKey(newSum) ? pathCount.get(newSum) : 0;

        totalPaths += countPathsWithSum(current.left, sum, currentSum, pathCount);
        totalPaths += countPathsWithSum(current.right, sum, currentSum, pathCount);

        updateHashTable(pathCount, currentSum, -1);

        return  totalPaths;
    }


    public static void updateHashTable(Map<Integer, Integer> hashTable, int key, int delta) {
        Integer value = hashTable.get(key);
        if (value == null) {
            value = 0;
        }
        hashTable.put(key, value + delta);
    }
}