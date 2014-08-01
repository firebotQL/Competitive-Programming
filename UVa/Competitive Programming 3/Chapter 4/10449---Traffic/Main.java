import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static List<Edge> edges = new ArrayList<Edge>();
	public static int[] cost = new int[201];
	
	public static int[] d = new int[201];
	public static int n;
	public static final int INF = ((int)1e8 + 7);
	
	public static class Edge
	{
		int u, v, w;
		public Edge(int u, int v, int w)
		{
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String line = null;
		int cnt = 1;
		while(sc.hasNextInt())
		{			
			edges.clear();
			
			n = sc.nextInt();
			
			for(int i = 0; i < n; ++i)
			{
				cost[i] = sc.nextInt();
			}
			
			int r = sc.nextInt();
			
			for(int i = 0; i < r; ++i)
			{
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				edges.add(new Edge(u, v, getW(u, v)));
			}
			
			runBellmanford();
			
			int q = sc.nextInt();
			
			System.out.println("Set #" + cnt++);
			
			for(int i = 0; i < q; ++i)
			{
				int toV = sc.nextInt() - 1;
				
				if (d[toV] < 3 || d[toV] == INF)
				{
					System.out.println('?');
				} 
				else
				{
					System.out.println(d[toV]);
				}
			}
		}
	}
		
	public static void runBellmanford() 
	{
		for(int i = 0; i < n; ++i)
		{
			d[i] = INF;
		}		
		d[0] = 0;
		
		boolean used = false;
		
		for(int i = 0; i < n - 1; ++i)
		{
			used = true;
			for(int j = 0; j < edges.size(); ++j)
			{
				Edge edge = edges.get(j);
				
				if (d[edge.u] != INF)
				{
					int sum = d[edge.u] + edge.w;
					
					if (sum < d[edge.v])
					{
						d[edge.v] = sum;
						used = false;
					}
				}
			}
			
			if (used) break;
		}
		
		for(int j = 0; j < edges.size(); ++j)
		{
			Edge edge = edges.get(j);
			
			if (d[edge.u] != INF && d[edge.u] + edge.w < d[edge.v])
			{
				d[edge.v] = -INF;
			}
		}
	}
	
	public static int getW(int u, int v)
	{
		return (cost[v] - cost[u]) * (cost[v] - cost[u]) * (cost[v] - cost[u]);
	}
}
