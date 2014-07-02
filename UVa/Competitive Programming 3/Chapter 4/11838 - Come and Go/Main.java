import java.util.*;
import java.io.*;

public class Main
{
	public static Map<Integer, Set<Integer>> adjMap = new HashMap<Integer, Set<Integer>>();
	public static int[] desc = new int[2000];
	public static int[] low = new int[2000];
	public static int time = 0;
	
	public static Stack<Integer> stack = new Stack<Integer>();
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			int N = Integer.valueOf(token.nextToken());
			int M = Integer.valueOf(token.nextToken());
			
			adjMap.clear();
			stack.clear();
			result.clear();
			time = 0;
			for(int i = 0; i < N; i++)
			{
				desc[i] = low[i] = -1;
				adjMap.put(i, new HashSet<Integer>());
			}
			
			if (N == 0 && M == 0)
			{
				break;
			}
			
			for(int i = 0; i < M; i++)
			{
				token = new StringTokenizer(reader.readLine());
				int V = Integer.valueOf(token.nextToken()) - 1;
				int W = Integer.valueOf(token.nextToken()) - 1;
				int P = Integer.valueOf(token.nextToken());
				
				switch(P)
				{
					case 2:
						adjMap.get(W).add(V);
					case 1:
						adjMap.get(V).add(W);
				}
			}
			
			solve(N);
			
			if (result.size() == 1)
			{
				System.out.println(1);
			}
			else
			{
				System.out.println(0);
			}
		}
	}
	
	public static void solve(int size)
	{
		for(int i = 0; i < size; i ++)
		{
			if (desc[i] == -1)
			{
				strongConnect(i);
			}
		}
	}
	
	public static void strongConnect(int vertex)
	{
		low[vertex] = desc[vertex] = time++;
		stack.push(vertex);
		
		for(Integer sVertex : adjMap.get(vertex))
		{
			if (desc[sVertex] == -1)
			{
				strongConnect(sVertex);
				low[vertex] = Math.min(low[vertex], low[sVertex]);
			}
			else if (stack.search(sVertex) != -1)
			{
				low[vertex] = Math.min(low[vertex], desc[sVertex]);
			}
		}
		
		if (low[vertex] == desc[vertex])
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
			} while(successor != null && successor != vertex);
			result.add(newSCC);
		}
	}
	
}