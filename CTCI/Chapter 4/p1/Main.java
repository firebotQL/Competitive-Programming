import java.util.*;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route betwen two nodes.
 */
public class Main {
    // 1 - 3 path exist
    // 3 - 0 doesn't
    private static Map<Integer, Node> nodesMap = new HashMap<Integer, Node>();

    public static void createExampleGraph() {
        Node<Integer> node0 = new Node<Integer>(0);
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        node0.addPointingTo(node1);
        node0.addPointingTo(node2);
        node1.addPointingTo(node2);
        node2.addPointingTo(node0);
        node2.addPointingTo(node3);
        node3.addPointingTo(node3);
        nodesMap.put(0, node0);
        nodesMap.put(1, node1);
        nodesMap.put(2, node2);
        nodesMap.put(3, node3);
    }

    public static boolean existViaDFS(Node node, int to) {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        Set<Node<Integer>> visited = new HashSet<Node<Integer>>();
        stack.push(node);
        while(!stack.isEmpty()) {
            Node<Integer> currentNode = stack.pop();
            if (visited.add(currentNode)) {
                System.out.println("Visited " + currentNode.getValue());
                if (currentNode.getValue() == to) {
                    return true;
                }
                for (Node<Integer> child : currentNode.getPointingTo()) {
                    stack.push(child);
                }

            }
        }
        return false;
    }

    public static boolean existViaBFS(Node node, int to) {
        Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Set<Node<Integer>> visited = new HashSet<Node<Integer>>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node<Integer> currentNode = queue.poll();
            if (visited.add(currentNode)) {
                System.out.println("Visited " + currentNode.getValue());
                if (currentNode.getValue() == to) {
                    return true;
                }
                for (Node<Integer> child : currentNode.getPointingTo()) {
                    queue.add(child);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        createExampleGraph();
        System.out.println("Between 1 - 3 using DFS: " + existViaDFS(nodesMap.get(1), 3));
        System.out.println("Between 3 - 0 using DFS: " + existViaDFS(nodesMap.get(3), 0));
        System.out.println("Between 1 - 3 using BFS: " + existViaBFS(nodesMap.get(1), 3));
        System.out.println("Between 3 - 0 using BFS: " + existViaBFS(nodesMap.get(3), 0));
    }

    public static class Node<T> {
        private T value;
        private List<Node> pointingTo;

        public Node(T value) {
            this.value = value;
            pointingTo = new ArrayList<Node>();
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void addPointingTo(Node next) {
            pointingTo.add(next);
        }

        public List<Node> getPointingTo() {
            return pointingTo;
        }
    }
}
