import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static Map<Integer, List<Integer> > adjMap = new HashMap<Integer, List<Integer>>();
	public static Set<Integer> visited = new HashSet<Integer>();
	public static Map<Integer, Integer> disc = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> low = new HashMap<Integer, Integer>();
	
	public static int time = 0;
	
	public static class Comp implements Comparator<Edge>
	{
		public int compare(Edge x, Edge y)
		{
			if (x.a != y.a)
				return x.a - y.a;
			else
				return x.b - y.b;
		}
	}

	public static class Edge
	{
		public int a, b;
		
		public Edge(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}
	public static PriorityQueue<Edge> bridgeQueue = new PriorityQueue<Edge>(10, new Comp());
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			int nos = Integer.valueOf(line);
			
			adjMap.clear();
			bridgeQueue.clear();
			visited.clear();
			parent.clear();
			low.clear();
			bridgeQueue.clear();
			time = 0;
			
			for(int i = 0; i < nos; i++)
			{
				adjMap.put(i, new ArrayList<Integer>());
			}
			
			for(int i = 0; i < nos; i++)
			{
				disc.put(i, 0);
				parent.put(i, -1);
				low.put(i, 0);
				
				StringTokenizer token = new StringTokenizer(reader.readLine());
				int vertex = Integer.valueOf(token.nextToken());
				token.nextToken();
				
				while(token.hasMoreTokens())
				{
					int adjVertex = Integer.valueOf(token.nextToken());
					adjMap.get(vertex).add(adjVertex);
					adjMap.get(adjVertex).add(vertex);
				}
			}
			
			for(int i = 0; i < nos; i++)
			{
				findAP(i);
			}
			
			System.out.println(bridgeQueue.size() + " critical links");
			while(bridgeQueue.size() > 0)
			{
				Edge temp = bridgeQueue.poll();
				System.out.println(temp.a + " - " + temp.b);
			}
			System.out.println();
			reader.readLine();
		}
	}
	
	public static void findAP(int u)
	{

		visited.add(u);
		
		++time;
		disc.put(u, time);
		low.put(u, time);

		List<Integer> adjVertexes = adjMap.get(u);
		
		if (adjVertexes != null)
		{
			for(Integer adjVertex : adjVertexes)
			{
				if (!visited.contains(adjVertex))
				{
					parent.put(adjVertex, u);
					findAP(adjVertex);
					
					low.put(u, Math.min(low.get(u), low.get(adjVertex)));
					
					
					if (low.get(adjVertex) > disc.get(u))
					{
						if (u < adjVertex)
						{
							bridgeQueue.add(new Edge(u, adjVertex));
						}
						else
						{
							bridgeQueue.add(new Edge(adjVertex, u));
						}
					}
				}
				else if (adjVertex != parent.get(u))
				{
					low.put(u, Math.min(low.get(u), disc.get(adjVertex)));
				}
			}
		}
	}
}