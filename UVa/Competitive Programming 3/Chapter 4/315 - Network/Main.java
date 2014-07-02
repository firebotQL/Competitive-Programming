import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static Map<Integer, List<Integer>> adjDS = new HashMap<Integer, List<Integer>>();
	public static boolean[] visited = new boolean[101];
	public static int[] disc = new int[101];
	public static int[] parent = new int[101];
	public static int[] low = new int[101];
	public static int time = 0;
	
	public static Set<Integer> APList = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line = reader.readLine()) != null)
		{
			int N = Integer.valueOf(line);
			
			if (N == 0)
			{
				break;
			}
			
			adjDS.clear();
			APList.clear();
			time = 0;
			
			for(int i = 0; i < N; i++)
			{
				visited[i] = false;
				disc[i] = parent[i] = low[i] = -1;
				adjDS.put(i, new ArrayList<Integer>());
			}
			
			while(true)
			{
				StringTokenizer token = new StringTokenizer(reader.readLine());
				
				int place = Integer.valueOf(token.nextToken());
				
				if (place == 0)
				{
					break;
				}
				
				List<Integer> adjList = adjDS.get(place - 1);
				
				while(token.hasMoreTokens())
				{
					int adjPlace = Integer.valueOf(token.nextToken());
					adjList.add(adjPlace - 1);
					adjDS.get(adjPlace - 1).add(place - 1);
				}
			}
			
			findAP(0);
			
			System.out.println(APList.size());
			
		}
	}
	
	public static void findAP(int u)
	{
		visited[u] = true;
		
		disc[u] = low[u] = ++time;
		
		int children = 0;
		
		List<Integer> adjVertexes = adjDS.get(u);
		
		if (adjVertexes != null)
		{
			for(Integer adjVertex : adjVertexes)
			{
				if (!visited[adjVertex])
				{
					children++;
					parent[adjVertex] = u;
					findAP(adjVertex);
					
					low[u] = Math.min(low[u], low[adjVertex]);
					
					if (parent[u] == -1 && children > 1)
					{
						APList.add(u);
					}
					
					if (parent[u] != -1 && low[adjVertex] >= disc[u])
					{
						APList.add(u);
					}
				}
				else if (adjVertex != parent[u])
				{
					low[u] = Math.min(low[u], disc[adjVertex]);
				}
			}
		}
	}
}