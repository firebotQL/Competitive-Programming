import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static Map<Integer, List<Integer> > adjMap = new HashMap<Integer, List<Integer>>();
	public static boolean[] visited = new boolean[10001];
	public static int[] disc = new int[10001];
	public static int[] parent = new int[10001];
	public static int[] low = new int[10001];
	public static int[] bridge = new int[10001];
	public static int time = 0;
	
	public static class Comp implements Comparator<AP>
	{
		public int compare(AP x, AP y)
		{
			if (y.doves == x.doves)
			{
				return x.vertex - y.vertex;
			}
			
			return  y.doves - x.doves;
		}
	}

	public static class AP
	{
		public int vertex, doves;
		
		public AP(int vertex, int doves)
		{
			this.vertex = vertex;
			this.doves = doves;
		}
	}
	
	
	public static PriorityQueue<AP> priorityByDoves = new PriorityQueue<AP>(10000, new Comp());
	
	public static Set<Integer> APList = new HashSet<Integer>();	
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			int n = Integer.valueOf(token.nextToken());
			int m = Integer.valueOf(token.nextToken());
			
			if (n == m && n == 0)
			{
				break;
			}
			
			adjMap.clear();
			priorityByDoves.clear();
			APList.clear();
			
			for(int i = 0; i < n; i++)
			{
			    visited[i] = false;
			    disc[i] = parent[i] = low[i] = -1;
				bridge[i] = 0;
				adjMap.put(i, new ArrayList<Integer>());
			}
			
			time = 0;
			
			while((line = reader.readLine()) != null)
			{
				token = new StringTokenizer(line);
				int x = Integer.valueOf(token.nextToken());
				int y = Integer.valueOf(token.nextToken());
				
				if (x == y && x == -1)
				{
					break;
				}
				
				adjMap.get(x).add(y);
				adjMap.get(y).add(x);
			}
			
			for(int i = 0; i < n; i++)
			{
				if (!visited[i])
				{
					findAP(i);
				}
			}

			for(int i = 0; i < n; i++)
			{
			    if (APList.contains(i))
			    {
				   int count = bridge[i];
				   List<Integer> adjList = adjMap.get(i);
				   
				   if (adjList.size() > count)
				   {
						count++;
				   }
				   
				   priorityByDoves.add(new AP(i, count));
			    }
			    else
			    {
			        priorityByDoves.add(new AP(i, 1));
			    }
			}
			
			for(int i = 0; i < m; i++)
			{
			    AP tmp = priorityByDoves.poll();
			   	System.out.println(tmp.vertex + " " + tmp.doves);
			}
			
			System.out.println();
		}
	}
	
	public static void findAP(int u)
	{
		visited[u] = true;
		
		disc[u] = low[u] = ++time;
		
		int children = 0;
		
		for(Integer adjVertex : adjMap.get(u))
		{
			if (!visited[adjVertex])
			{
				children++;
				parent[adjVertex] = u;
				findAP(adjVertex);
				
				low[u] = Math.min(low[u], low[adjVertex]);
				
				if ((parent[u] == -1 && children > 1)  ||
					(parent[u] != -1 && low[adjVertex] >= disc[u]))
				{
					APList.add(u);
				}
				
				if (low[adjVertex] > disc[u])
				{
					bridge[u]++;
					bridge[adjVertex]++;
				}

			}
			else if (adjVertex != parent[u])
			{
				low[u] = Math.min(low[u], disc[adjVertex]);
			}
		}
	}	
}