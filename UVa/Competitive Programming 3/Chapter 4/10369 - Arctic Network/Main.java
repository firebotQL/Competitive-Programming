import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] vertex = new int[501][2];
	public static List<Edge> edgeList = new ArrayList<Edge>();
	public static int[][] parentRank = new int[501][2];
		
	public static class Edge implements Comparable<Edge>
    {
        public int a, b;
        public double weight = 0;
        
        public Edge(int a, int b, double weight)
        {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        
        public int compareTo(Edge compareEdge)
        {           
            return Double.compare(this.weight, compareEdge.weight);
        }
    }
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(reader.readLine());
		while(cases-- != 0)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int S = Integer.parseInt(token.nextToken());
			int P = Integer.parseInt(token.nextToken());
			
			for(int i = 0; i < P; i++)
			{
				token = new StringTokenizer(reader.readLine());
				vertex[i][0] = Integer.parseInt(token.nextToken());
				vertex[i][1] = Integer.parseInt(token.nextToken());
				parentRank[i][0] = i;
				parentRank[i][1] = 0;
			}
			
			edgeList.clear();
			
			for(int i = 0; i < P; i++)
			{
				for(int j = i + 1; j < P; j++)
				{
					double euclDist = euclideanDistance(vertex[i][0], 
														vertex[i][1], 
														vertex[j][0], 
														vertex[j][1]);
					edgeList.add(new Edge(i, j, euclDist));
				}
			}
			
			Collections.sort(edgeList);
			
			double result = 0;
			int CC = P;
			
			for(int i = 0; i < edgeList.size() && CC > S; i++)
			{
				Edge edge = edgeList.get(i);
				
				int x = find(edge.a);
				int y = find(edge.b);
				
				if (x != y)
				{
					CC--;
					result = Math.max(result, edge.weight);
					union(x, y);
				}
			}
			
			System.out.printf("%.2f\n", result);
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
	
	
	public static double euclideanDistance(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}