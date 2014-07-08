import java.util.*;
import java.io.*;

public class Main
{
	public static LinkedList<Vertex>[] graph = null;
	public static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
	public static int[] dist = null;
	public static boolean[] visited = null;
	
	public static class Vertex implements Comparable<Vertex>
	{
		public int id;
		public int distance;
		public Vertex(int id, int distance)
		{
			this.id = id;
			this.distance = distance;
		}
		
		public int compareTo(Vertex v)
		{
			return distance - v.distance;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		for(int caseNr = 1; caseNr <= N; caseNr++)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            int S = Integer.parseInt(token.nextToken());
            int T = Integer.parseInt(token.nextToken());
			
			pq.clear();
			graph = new LinkedList[n];
			dist = new int[n];
			visited = new boolean[n];
			for(int i = 0; i < n; ++i)
			{
				dist[i] = Integer.MAX_VALUE;
				graph[i] = new LinkedList<Vertex>();
			}
			
			for(int i = 0; i < m; ++i)
			{
				token = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                int c = Integer.parseInt(token.nextToken());
				
				graph[a].add(new Vertex(b, c));
				graph[b].add(new Vertex(a, c));
			}
			
			dist[S] = 0;
			pq.add(new Vertex(S, 0));
			
			while(!pq.isEmpty())
			{
				Vertex current = pq.poll();
				
				if (current.id == T)
				{
					break;
				}
				else if(!visited[current.id])
				{
					visited[current.id] = true;
					for(int i = 0; i < graph[current.id].size(); ++i)
					{
						Vertex v = graph[current.id].get(i);
						
						if (dist[current.id] + v.distance < dist[v.id])
						{
							dist[v.id] = dist[current.id] + v.distance;
							pq.offer(new Vertex(v.id, dist[v.id]));
						}
					}
				}
			}
			
			out.append("Case #" + caseNr + ": ");
			
            if (dist[T] == Integer.MAX_VALUE)
            {
                out.append("unreachable\n");
            }
            else
            {
				out.append(dist[T]).append("\n");
            }
		}
		System.out.print(out);
	}
}