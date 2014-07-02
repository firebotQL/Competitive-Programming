import java.util.*;
import java.io.*;

public class Main
{
	public static List<Edge> edgeList = new ArrayList<Edge>();
	public static int[][] vertexCoords = new int[1001][2];	// 0 - x, 1 - y
	public static int[][] parentRank = new int[1001][2];	// 0 - parent, 1 - rank

	public static class Edge implements Comparable<Edge>
	{
		public int src, dest;
		public double weight = 0;
		
		public Edge(int v1 , int v2, double weight)
		{
			this.src = v1;
			this.dest = v2;
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
		int caseCnt = Integer.parseInt(reader.readLine());
		
		for(int caseNr = 1; caseNr <= caseCnt; caseNr++)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int cityCnt = Integer.parseInt(token.nextToken());
			int r = Integer.parseInt(token.nextToken());
			
			edgeList.clear();
			
			for(int i = 0; i < cityCnt; i++)
			{
				parentRank[i][0] = i;
				parentRank[i][1] = 0;

				token = new StringTokenizer(reader.readLine());
				vertexCoords[i][0] = Integer.parseInt(token.nextToken());
				vertexCoords[i][1] = Integer.parseInt(token.nextToken());
			}
			
			for(int i = 0; i < cityCnt; i++)
			{
				for(int j = i + 1; j < cityCnt; j++)
				{
					double euclDist = euclideanDistance(vertexCoords[i][0], 
														vertexCoords[i][1], 
														vertexCoords[j][0], 
														vertexCoords[j][1]);
					edgeList.add(new Edge(i, j, euclDist));
				}
			}
			
			int state = cityCnt;
			
			Collections.sort(edgeList);
			
			double dRoadMst = 0;
			double dRailwayMst = 0;
			
			for(int i = 0; i < edgeList.size(); i++)
			{
				Edge edge = edgeList.get(i);
				int x = find(edge.src);
				int y = find(edge.dest);
				
				if (x != y)
				{
					if (edge.weight > r)
					{
						dRailwayMst += edge.weight;
					}
					else
					{
						state--;
						dRoadMst += edge.weight;
					}
					union(x, y);
				}
			}
			
			System.out.println("Case #" + caseNr + ": " + state + " " + Math.round(dRoadMst) + " " + Math.round(dRailwayMst));
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
	
	public static double euclideanDistance(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}