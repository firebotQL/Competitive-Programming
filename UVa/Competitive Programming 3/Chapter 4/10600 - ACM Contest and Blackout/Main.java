import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static List<Edge> edgeList = new ArrayList<Edge>();
	public static int[][] parentRank = new int[101][2];
	
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
            return this.weight - compareEdge.weight;
        }
    }
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(reader.readLine());
		while(cases-- != 0)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());

			for(int i = 1; i <= N ; i++)
			{
				parentRank[i][0] = i;
				parentRank[i][1] = 0;
			}
			
			edgeList.clear();
			
			for(int i = 0; i < M; i++)
			{
				token = new StringTokenizer(reader.readLine());
				int A = Integer.parseInt(token.nextToken());
				int B = Integer.parseInt(token.nextToken());
				int C = Integer.parseInt(token.nextToken());
				
				edgeList.add(new Edge(A, B, C));
			}
			
			Collections.sort(edgeList);
			int cheapest1 = 0;
			Set<Edge> mst = new HashSet<Edge>();
			
			for(Edge edge : edgeList)
			{
				int x = find(edge.a);
				int y = find(edge.b);
				
				if (x != y)
				{
					cheapest1 += edge.weight;
					mst.add(edge);
					union(x, y);
				}
			}
			
			int cheapest2 = Integer.MAX_VALUE;
			int tmpcheapest = 0;
			
			for(int i = 0; i < edgeList.size(); i++)
			{	
				tmpcheapest = 0;
				
				for(int z = 1; z <= N ; z++)
				{
					parentRank[z][0] = z;
					parentRank[z][1] = 0;
				}
				int countEdges = 0;
				
				for(int j = 0; j < edgeList.size(); j++)
				{
					if (j != i)
					{
						Edge edge = edgeList.get(j);
						int x = find(edge.a);
						int y = find(edge.b);
						
						if (x != y)
						{
							tmpcheapest += edge.weight;
							
							if (mst.contains(edge))
							{
								countEdges++;
							}
							
							union(x, y);
						}
					}
				}
				
				if (tmpcheapest < cheapest2 && tmpcheapest >= cheapest1 && countEdges != mst.size())
				{
					cheapest2 = tmpcheapest;
				}
			}
			
			
			System.out.println(cheapest1 + " " + cheapest2);
			
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
			parentRank[yroot][1]++;
		}
	}
}