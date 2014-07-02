import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
	public static int[] tarIndex = new int[100000];
	public static int[] lowLink = new int[100000];
	
	public static Stack<Integer> stack = new Stack<Integer>();
    public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	public static int time = 0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int testsNr = Integer.valueOf(reader.readLine());
		
		while(testsNr-- != 0)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int n = Integer.valueOf(token.nextToken());
			int m  = Integer.valueOf(token.nextToken());
			
			stack.clear();
			result.clear();
			adjMap.clear();
			
			for(int i = 0; i < n; i++)
			{
				adjMap.put(i, new ArrayList<Integer>());
				tarIndex[i] = lowLink[i] = -1;
			}
			
			for(int i = 0; i < m; i++)
			{
				token = new StringTokenizer(reader.readLine());
				adjMap.get(Integer.valueOf(token.nextToken()) -1).add(Integer.valueOf(token.nextToken()));
			}
			
			solve(n);
			
			System.out.println(stack.size() - 1);
		}
	}
	
	public static void solve(int size)
	{
		for(int i = 0; i < size; i++)
		{
			if (tarIndex[i] == -1)
			{
				strongConnect(i);
			}
		}
	}
	
	public static void strongConnect(int vertex)
	{
		tarIndex[vertex] = lowLink[vertex] = time++;
		stack.push(vertex);
		
		for(Integer successorVertex : adjMap.get(vertex))
		{
			if (tarIndex[successorVertex] == -1)
			{
				strongConnect(successorVertex);
				lowLink[vertex] = Math.min(lowLink[vertex], lowLink[successorVertex]);
			}
			else if (stack.search(successorVertex) != -1)
			{
				lowLink[vertex] = Math.min(lowLink[vertex], tarIndex[successorVertex]);
			}
		}
		
		if (lowLink[vertex] == tarIndex[vertex])
		{
			List<Integer> newSCC = new ArrayList<Integer>();
			Integer successor = null;
			do
			{
				if (stack.size() != 0)
				{
					successor = stack.pop();
					newSCC.add(successor);
				}
			} while (successor != null && successor != vertex);
			result.add(newSCC);
		}
	}
}