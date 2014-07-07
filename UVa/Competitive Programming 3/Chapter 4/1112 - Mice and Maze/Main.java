import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	//public static int[][] maze = new int[100][100];
	public static Map<Integer, List<Integer>> maze = new HashMap<Integer, List<Integer>>();
	
	public static Map<Integer, Vertex> map = new HashMap<Integer, Vertex>();
	
	public static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
	public static List<Vertex> list = new ArrayList<Vertex>();
	
	public static class Vertex extends Comparable<Vertex>
	{
		public int id;
		public int distance;
		
		public Vertex(int id, distance)
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
		
		while(cases-- != 0)
		{
			reader.readLine();
			int N = Integer.parseInt(reader.readLine());
			int E = Integer.parseInt(reader.readLine());
			int T = Integer.parseInt(reader.readLine());
			int M = Integer.parseInt(reader.readLine());
			
			for(int i = 1; i <= M; ++i)
			{
				StringTokenizer token = new StringTokenizer(reader.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				int cost = Integer.parseInt(token.nextToken());
				
				List<Integer> adjList = maze.get(a);
				
				if (adjList == null)
				{
					adjList = new ArrayList<Integer>();
				}
				
				adjList.add(b);
				adjList.add(cost);
				Vertex vertex = new Vertex(a, Integer.MAX_VALUE);
				list.add(vertex);
				map.put(a, vertex);
			}
			
			int result = 0;
			for(Vertex vertex : list)
			{
				vertex.distance = 0;
				pq.clear();
				pq.addAll(list);
				
				while(!pq.isEmpty())
				{
					Vertex u = pq.poll();
					
					List<Integer> adjList = maze.get(u);
					
					if (u == E)
					{
						result += u.distance;
						break;
					}
					
					for(int i = 0; i < adjList.size(); i += 2)
					{
						int vi = adjList.get(i);
						int cost = adjList.get(i + 1);
						int alt = u.distance + cost;
						Vertex v = map.get(vi);
						
						if (alt < v.distance)
						{
							pq.remove(v);
							v.distance = alt;
							pq.offer(v);
						}
					}
				}
			}
		}
	}
}