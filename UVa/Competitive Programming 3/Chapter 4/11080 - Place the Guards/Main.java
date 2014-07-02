import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
	public static int[] colored = new int[200];
	public static int[] colorCnt = new int[2];
	public static int sum = 0;

	public static boolean guard()
	{
			boolean result = true;
			
			for(Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet())
			{
				int vertex = entry.getKey();
				if (colored[vertex] == -1)
				{
					if (entry.getValue().size() > 0)
					{
						result &= guard(vertex, 0);
						sum += Math.min(colorCnt[0], colorCnt[1]);
						colorCnt[0] = colorCnt[1] = 0;
					}
					else
					{
						sum++;
					}
				}
				
				if (!result)
				{
					break;
				}
				
			}
			
			return result;
	}
	
	public static boolean guard(int vertex, int color)
	{
		colored[vertex] = color;
		
		
		List<Integer> adjVertexList = adjacencyList.get(vertex);
		
		
		boolean result = true;
		
		if (adjVertexList != null)
		{
			colorCnt[color]++;
			for(Integer adjVertex : adjVertexList)
			{
				if (colored[adjVertex] == color)
				{
					result = false;
					break;
				}
				else if (colored[adjVertex] == -1)
				{
					result &= guard(adjVertex, 1 - color);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(reader.readLine());
		while(T-- != 0)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
			
			int v = Integer.valueOf(token.nextToken());
			int e = Integer.valueOf(token.nextToken());
			
			sum = 0;
			colorCnt[0] = colorCnt[1] = 0;
			adjacencyList.clear();
			
			for(int i = 0; i < v; i++)
			{
				colored[i] = -1;
				adjacencyList.put(i, new ArrayList<Integer>());
			}
			
			while(e-- != 0)
			{
				token = new StringTokenizer(reader.readLine());
				int f = Integer.valueOf(token.nextToken());
				int t = Integer.valueOf(token.nextToken());
				adjacencyList.get(f).add(t);
				adjacencyList.get(t).add(f);
			}
			
			if (guard())
			{
				System.out.println(sum);
			}
			else
			{
				System.out.println(-1);
			}
		}
	}
}