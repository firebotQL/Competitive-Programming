import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        Set<Character> visited = new HashSet<>();
        List<Node> collect = br.lines().collect(Collector.of(() -> new HashMap<Character, Node>(),
                (map, line) -> linkNodes(line, map),
                (a1, a2) -> null,
                a -> a))
                .values()
                .stream()
                .filter((o1) -> o1.degree == 0)
                .collect(Collectors.toList());


        Queue<Node> q1 = new PriorityQueue<>(Comparator.comparingInt(o -> o.name));

        q1.addAll(collect);

        while(!q1.isEmpty()) {
            Node current;
            while((current = q1.poll()) != null) {
                if (visited.add(current.name)) {
                    System.out.print(current.name);
                }
                for(Node child : current.children) {
                    if (--child.degree == 0) {
                        q1.add(child);
                    }
                }
            }
        }
        System.out.println();
    }

    private static void linkNodes(String line, Map<Character, Node> nodeMap) {
        String pattern = "Step (.*) must be finished before step (.*) can begin.";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            char name = m.group(1).charAt(0);
            char nextName = m.group(2).charAt(0);
            Node node = nodeMap.get(name);
            Node nextNode = nodeMap.get(nextName);

            if (node == null) {
                node = new Node(name);
                nodeMap.put(name, node);
            }
            if (nextNode == null) {
                nextNode = new Node(nextName);
                nodeMap.put(nextName, nextNode);
            }

            nextNode.degree++;

            node.children.add(nextNode);
        }

    }

    private static class Node {
        int degree;
        char name;
        List<Node> children = new ArrayList<>();
        public Node(char name) {
            this.name = name;
        }
    }
}
