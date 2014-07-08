import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static Map<Integer, List<Integer>> maze = new HashMap<Integer, List<Integer>>();
    public static Map<Integer, Vertex> map = new HashMap<Integer, Vertex>();
    public static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
    public static int[][] cost = new int[101][101];
    
    public static class Vertex implements Comparable<Vertex>
    {
        public int id;
        public int distance;

        public Vertex(int id, int distance)
        {
            this.id = id;
            this.distance = distance;
        }

        public int compareTo(Vertex vertex)
        {
            return distance - vertex.distance;
        }
    }

    public static void main(String[] args) throws IOException
    {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());

        for(int z = 0; z < cases; ++z)
        {
            reader.readLine();
            int N = Integer.parseInt(reader.readLine());
            int E = Integer.parseInt(reader.readLine());
            int T = Integer.parseInt(reader.readLine());
            int M = Integer.parseInt(reader.readLine());

            if (z != 0)
            {
                System.out.println();
            }
            
            maze.clear();
            map.clear();
            pq.clear();
            
            for(int i = 1; i <= N; ++i)
            {
                int dist = Integer.MAX_VALUE;
                
                if (i == E)
                {
                   dist = 0;
                }
                
                maze.put(i, new ArrayList<Integer>());
                Vertex vertex = new Vertex(i, dist);
                map.put(i, vertex);
                pq.add(vertex);
            }
            
            for(int i = 1; i <= M; ++i)
            {
                StringTokenizer token = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                int c = Integer.parseInt(token.nextToken());

                maze.get(b).add(a);
                cost[b][a] = c;
            }
            
            while(!pq.isEmpty())
            {
                Vertex u = pq.poll();

                for(Integer vi : maze.get(u.id))
                {                    
                    Vertex v = map.get(vi);
                    
                    if (u.distance + cost[u.id][vi] < v.distance)
                    {
                        pq.remove(v);
                        v.distance = u.distance + cost[u.id][vi];
                        pq.offer(v);
                    }
                }
            }
            
            int result = 0;
            
            for(int i = 1; i <= N; ++i)
            {
                Vertex v = map.get(i);
                
                if (T >= v.distance)
                {
                    result++;
                }
            }
            
            System.out.println(result);
        }
    }
}
