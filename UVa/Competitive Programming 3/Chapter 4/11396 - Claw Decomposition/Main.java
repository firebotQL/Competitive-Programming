import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
	public static int[] colored = new int[301];
	
	public static boolean decomp()
	{
		boolean result = true;
		for(Map.Entry<Integer, List<Integer>> adjChain : adjMap.entrySet())
		{
			if (colored[adjChain.getKey()] == -1)
			{
				result &= decomp(adjChain.getKey(), 0);
			}
			
			if (!result)
			{
				break;
			}
		}
		return result;
	}
	
	public static boolean decomp(int vertex, int color)
	{
		boolean result = true;
		colored[vertex] = color;
		List<Integer> adjList = adjMap.get(vertex);
		if (adjList != null)
		{
			for(Integer adjVertex : adjList)
			{
				if (colored[adjVertex] == color)
				{
					result = false;
					break;
				}
				else if (colored[adjVertex] == -1)
				{
					result &= decomp(adjVertex, 1 - color);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			int V = Integer.valueOf(line);
			if (V == 0)
				break;
				
			adjMap.clear();
			Arrays.fill(colored, 0, V+1, -1);
			
			for(int i = 1; i <= V; i++)
			{
				adjMap.put(i, new ArrayList<Integer>());
			}
			
			while((line = reader.readLine()) != null)
			{
				StringTokenizer token = new StringTokenizer(line);
				int a = Integer.valueOf(token.nextToken());
				int b = Integer.valueOf(token.nextToken());
				
				if (a == 0 && b == 0)
				{
					break;
				}
				
				adjMap.get(a).add(b);
				adjMap.get(b).add(a);
			}
			
			if (decomp())
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
}