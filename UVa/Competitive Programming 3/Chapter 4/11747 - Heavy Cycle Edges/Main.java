import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static List<Edge> edgeList = new ArrayList<Edge>();
	public static int[][] parentRank = new int[1001][3];
	
	public static class Edge implements Comparable<Edge>
	{
		public int a, b;
		public int weight = 0;
		
		public Edge(int a, int b, int weight)
		{
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		
		public int compareTo(Edge compareEdge)
		{
			if(this.weight > compareEdge.weight)
			{
				return 1;
			}
			else if (this.weight < compareEdge.weight)
			{
				return -1;
			}
			
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			int n = Integer.parseInt(token.nextToken());
			int m = Integer.parseInt(token.nextToken());
			
			if(n == 0 && m == 0)
			{
				break;
			}
			
			for(int i = 0; i < n; i++)
			{
				parentRank[i][0] = i;
				parentRank[i][1] = 0;
			}
			
			edgeList.clear();
			
			for(int i = 0; i < m; i++)
			{
				token = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				int w = Integer.parseInt(token.nextToken());
				
				edgeList.add(new Edge(x, y, w));
			}
			
			List<Integer> maxWeights = new ArrayList<Integer>();
			
			Collections.sort(edgeList);
			
			int maxWeight = 0;
			
			for(int i = 0; i < edgeList.size(); i++)
			{
				Edge edge = edgeList.get(i);
				int x = find(edge.a);
				int y = find(edge.b);
				
				
				if (x != y)
				{
					maxWeight = Math.max(maxWeight, edge.weight);
					union(x, y);
				}
				else
				{
					maxWeights.add(Math.max(maxWeight, edge.weight));
				}
				
			}
			
			if (maxWeights.size() > 0)
			{
				for(int i = 0; i < maxWeights.size(); i++)
				{
					if (i + 1 != maxWeights.size())
					{
						System.out.print(maxWeights.get(i) + " ");
					}
					else
					{
						System.out.print(maxWeights.get(i));
					}
				}
				
				System.out.println();
			}
			else
			{
				System.out.println("forest");
			}
		}
	}
	
	public static int find(int i)
	{
		if (parentRank[i][0] != i)
		{
			parentRank[i][0] = find(parentRank[i][0]);
		}
		return parentRank[i][0];
	}
	
	public static void union(int x, int y)
	{
		int xroot = find(x);
		int yroot = find(y);
		
		if (parentRank[xroot][1] < parentRank[yroot][1])
		{
			parentRank[xroot][0] = yroot;
		}
		else if (parentRank[xroot][1] > parentRank[yroot][1])
		{
			parentRank[yroot][0] = xroot;
		}
		else
		{
			parentRank[yroot][0] = xroot;
			parentRank[xroot][1]++;
		}
			
	}
}