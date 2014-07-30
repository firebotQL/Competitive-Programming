import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static Map<Integer, List<Edge>> directAdjMap = new HashMap<Integer, List<Edge>>();
    public static Map<Integer, List<Edge>> reverseAdjMap = new HashMap<Integer, List<Edge>>();
    public static List<Edge> edges = new ArrayList<Edge>();
    
    public static int[][] directSum = new int[10001][10001];
    public static int[][] reverseSum = new int[10001][10001];
    
    public static boolean[] directVisited = new boolean[10001];
    public static boolean[] reverseVisited = new boolean[10001];
    
    public static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    
    public static class Edge
    {
        public int fromId;
        public int toId;
        public int cost;
        
        public Edge(int from, int to, int cost)
        {
            this.fromId = from;
            this.toId = to;
            this.cost = cost;
        }
    }
    
    public static class Node implements Comparable<Node>
    {
        public int id;
        public int distance;
        
        public Node(int id, int distance)
        {
            this.id = id;
            this.distance = distance;
        }
        
        public int compareTo(Node node)
        {
            return distance - node.distance;
        }
    }
    
    public static void addEdge(int s, int e, int c, Map<Integer, List<Edge>> adjMap, boolean store)
    {        
        List<Edge> edgeList = adjMap.get(s);
        
        if (edgeList == null)
        {
            edgeList = new ArrayList<Edge>();
        }
        
        Edge edge = new Edge(s, e, c);
        
        edgeList.add(edge);
        
        if (store)
        {
            edges.add(edge);
        }
        
        adjMap.put(s, edgeList);
    }
    
    public static void runDijkstra(int s, Map<Integer, List<Edge>> adjMap, int[][] sum, boolean[] visited)
    {
        pq.clear();
        
        pq.offer(new Node(s, 0));
        
        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            
            if (visited[cur.id]) continue;
            visited[cur.id] = true;
            
            List<Edge> adjList = adjMap.get(cur.id);
            
            if (adjList != null)
            {
                for(Edge adjEdge : adjList)
                {
                    int altSum = cur.distance + adjEdge.cost;
                    
                    if (altSum < sum[cur.id][adjEdge.toId])
                    {
                        pq.offer(new Node(adjEdge.toId, altSum));
                        sum[cur.id][adjEdge.toId] = altSum;
                    }
                }
            }
        }
    }
    
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        
        while(T-- != 0)
        {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            int s = Integer.parseInt(token.nextToken());
            int t = Integer.parseInt(token.nextToken());
            int p = Integer.parseInt(token.nextToken());
            
            directAdjMap.clear();
            reverseAdjMap.clear();
            edges.clear();
            
            for(int i = 0; i < M; ++i)
            {
                token = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(token.nextToken());
                int v = Integer.parseInt(token.nextToken());
                int c = Integer.parseInt(token.nextToken());
                directSum[u][v] = reverseSum[v][u] = Integer.MAX_VALUE;
                directVisited[u] = reverseVisited[u] = directVisited[v] = reverseVisited[v] = false;
                addEdge(u, v, c, directAdjMap, true);
                addEdge(v, u, c, reverseAdjMap, false);
            }
            
            runDijkstra(s, directAdjMap, directSum, directVisited);
            runDijkstra(t, reverseAdjMap, reverseSum, reverseVisited);
            
            int result = -1;
            
            for(int i = 0; i < edges.size(); i++)
            {
                Edge edge = edges.get(i);
                int C = directSum[s][edge.fromId] + edge.cost + reverseSum[t][edge.toId];
                if (C <= p && edge.cost > result)
                {
                    result = edge.cost;
                }
            }
            
            System.out.println(result);
        }
    }
}