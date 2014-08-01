import java.util.*;
import java.io.*;

// BellmanFord
public class Main 
{
	public static List<Edge> edges = new ArrayList<Edge>();
	public static long[] d = new long[1001];
	public static int[] p = new int[1001];
	public static int n;
	
	private static class Edge
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
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(reader.readLine());
		while(c-- != 0)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(token.nextToken());
			int m = Integer.parseInt(token.nextToken());
			
			edges.clear();
			
			for(int i = 0; i < m ; ++i)
			{
				token = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(token.nextToken());
				int v = Integer.parseInt(token.nextToken());
				int w = Integer.parseInt(token.nextToken());
				
				edges.add(new Edge(u, v, w));
			}
			relax();
			
			if (cycle())
			{
				System.out.println("possible");
			}
			else
			{
				System.out.println("not possible");
			}
		}
	}
	
	public static void relax() 
	{
		for(int i = 0; i < n; ++i)
		{
			d[i] = Integer.MAX_VALUE;
			p[i] = -1;
		}
		
		d[0] = 0;

		for(int i = 0; i < n - 1; ++i)
		{
			for(int j = 0; j < edges.size(); ++j)
			{
				Edge edge = edges.get(j);
				long sum = d[edge.u] + edge.w;
				
				if (sum < d[edge.v])
				{
					d[edge.v] = sum;
					p[edge.v] = edge.v;
				}
			}
		}
	}
	
	public static boolean cycle()
	{
		for(int j = 0; j < edges.size(); ++j)
		{
			Edge edge = edges.get(j);
			if (d[edge.u] + edge.w < d[edge.v])
			{
				return true;
			}
		}
		return false;
	}
	
}
