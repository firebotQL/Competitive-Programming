import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
	public static int maxBoom = 0;
	public static int maxBoomDay = 0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			int E = Integer.parseInt(line);
			adjMap.clear();
			
			for(int i = 0; i < E; ++i)
			{
				StringTokenizer token = new StringTokenizer(reader.readLine());
				List<Integer> adjList = new ArrayList<Integer>();
				adjMap.put(i, adjList);
				
				token.nextToken();
				
				while(token.hasMoreTokens())
				{
					adjList.add(Integer.parseInt(token.nextToken()));
				}
			}
			
			int T = Integer.parseInt(reader.readLine());
			
			while(T-- != 0)
			{
				int start = Integer.parseInt(reader.readLine());
				maxBoom = 0;
				maxBoomDay = 0;
				bfs(start);
				
				if (maxBoomDay != 0)
				{
					System.out.println(maxBoom + " " + maxBoomDay);
				}
				else
				{
					System.out.println(0);
				}
			}
		}
	}
	
	public static void bfs(int vertex)
	{
		Queue<Integer> currentQueue = new LinkedList<Integer>();
		Queue<Integer> nextQueue = new LinkedList<Integer>();
		Set<Integer> used = new HashSet<Integer>();
		
		currentQueue.add(vertex);
		used.add(vertex);
		
		int day = 0;
		
		while(!currentQueue.isEmpty())
		{
			int u = currentQueue.poll();
			
			List<Integer> adjList = adjMap.get(u);
			
			for(Integer adjVertex : adjList)
			{
				if (used.add(adjVertex))
				{
					nextQueue.add(adjVertex);
				}
			}
			
			if (currentQueue.isEmpty())
			{
				Queue<Integer> tmpQueue = currentQueue;
				currentQueue = nextQueue;
				nextQueue = tmpQueue;
				day++;
				
				if (currentQueue.size() > maxBoom)
				{
					maxBoom = currentQueue.size();
					maxBoomDay = day;
				}
			}
		}
	}
	
}