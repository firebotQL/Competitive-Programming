import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Build Order. You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
 * where the first project is dependent on the second project). All of a projects' dependencies must be built before
 * the project is. Find a build order that will allow the projects to be built. If there is no valid build order,
 * return an error.
 * Input:
 *  projects: a, b, c, d, e, f, k
 *  dependencies: (d, a), (b, f), (d, b), (a, f), (c, d), (a, k), (l, d)
 * Output: f, e, a, b, d, c
 */
public class Main {
    public static class Node {
        char name;
        List<Node> children = new ArrayList<Node>();
        public Node(char name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Set<Character> nodes = new HashSet<Character>(Arrays.asList('a','b','c','d','e','f','k','l'));
        Map<Character, Node> nodeMap = new HashMap<Character, Node>();

        for(Iterator<Character> iter = nodes.iterator(); iter.hasNext();) {
            char name = iter.next();
            nodeMap.put(name, new Node(name));
        }

        String dependencies = "(d, a), (b, f), (d, b), (a, f), (c, d), (a, k), (l, d)";
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(dependencies);
        while(m.find()) {
            String[] fromTo = m.group(1).split(",");
            char from = fromTo[0].trim().charAt(0);
            char to = fromTo[1].trim().charAt(0);
            nodeMap.get(from).children.add(nodeMap.get(to));
            nodes.remove(to);   // Removing nodes from which cannot start from
        }


        StringJoiner sj = new StringJoiner(",");
        Set<Character> built = new HashSet<Character>();
        for(Iterator<Character> iter = nodes.iterator(); iter.hasNext();) {
            Node node = nodeMap.get(iter.next());
            dfs(node, sj, built);
        }

        System.out.println(sj.toString());

    }

    private static void dfs(Node node, StringJoiner sj, Set<Character> built) {
        if (!node.children.isEmpty()) {
            for(Node child : node.children) {
                if (!built.contains(child.name)) {
                    dfs(child, sj, built);
                }
            }
        }
        sj.add(node.name + "");
        built.add(node.name);
    }
}
