import java.util.*;

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

    public static List<List<Integer>> bfs(Node node) {
        Queue<Node> queue1 = new LinkedList();
        Queue<Node> queue2 = new LinkedList();
        queue1.add(node);
        List<List<Integer>> results = new ArrayList();

        while(!queue1.isEmpty()) {
            List<Integer> level = new ArrayList();
            while(!queue1.isEmpty()) {
                Node current = queue1.poll();
                level.add(current.key);

                if (current.left != null) {
                    queue2.add(current.left);
                }

                if (current.right != null) {
                    queue2.add(current.right);
                }
            }

            Queue<Node> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;

            List<List<Integer>> tmpResults = new ArrayList();
            permute(level, 0, tmpResults);
            results = getNewResults(results, tmpResults);
        }
        return results;
    }

    private static List<List<Integer>> getNewResults(List<List<Integer>> results, List<List<Integer>> tmpResults) {
        List<List<Integer>> newResults = new ArrayList();
        if (!results.isEmpty()) {
            for(List<Integer> tmpResult : tmpResults) {
                for(List<Integer> result : results) {
                    List<Integer> subResult = new ArrayList(result);
                    subResult.addAll(tmpResult);
                    newResults.add(subResult);
                }
            }
        } else {
            newResults = tmpResults;
        }
        return newResults;
    }

    public static void permute(List<Integer> array, int k, List<List<Integer>> results) {
        for (int i = k; i < array.size(); i++) {
            Collections.swap(array, i, k);
            permute(array, k + 1, results);
            Collections.swap(array, k, i);
        }

        if (k == array.size() - 1) {
            results.add(new ArrayList<>(array));
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(2);

        for(List<Integer> result : bfs(root)) {
            System.out.println(Arrays.toString(result.toArray()));
        }

        System.out.println();

        for(List<Integer> result : bfs(root1)) {
            System.out.println(Arrays.toString(result.toArray()));
        }
    }
}

