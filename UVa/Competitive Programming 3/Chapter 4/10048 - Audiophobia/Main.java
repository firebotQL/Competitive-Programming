import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static List<Edge> edgeList = new ArrayList<Edge>();
    public static Map<Integer, List<Edge>> vertexToEdgeMap = new HashMap<Integer, List<Edge>>();
    public static Set<Integer> visited = new HashSet<Integer>();
    public static Set<Edge> resultEdgeList = new HashSet<Edge>();
    public static int[][] parentRank = new int[101][2];
    
    public static int dbmax = 0;
    
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
        String line = null;
        int caseNr = 1;
        while((line = reader.readLine()) != null)
        {
            StringTokenizer token = new StringTokenizer(line);
            int C = Integer.parseInt(token.nextToken());
            int S = Integer.parseInt(token.nextToken());
            int Q = Integer.parseInt(token.nextToken());
            
            if (C == 0 && S == 0 && Q == 0)
            {
                break;
            }
            
            if (caseNr != 1)
            {
            	System.out.println();
            }
            
            edgeList.clear();
            vertexToEdgeMap.clear();
            
            
            for(int i = 1; i <= C; i++)
            {
                parentRank[i][0] = i;
                parentRank[i][1] = 0;
                vertexToEdgeMap.put(i, new ArrayList<Edge>());
            }
            
            
            
            for(int i = 0; i < S; i++)
            {
                token = new StringTokenizer(reader.readLine());
                int c1 = Integer.parseInt(token.nextToken());
                int c2 = Integer.parseInt(token.nextToken());
                int d = Integer.parseInt(token.nextToken());
                
                Edge edge = new Edge(c1, c2, d);
                edgeList.add(edge);
                //System.out.println(c1 + " " + c2);
            }
            
            Collections.sort(edgeList);
            
           
            List<Edge> mst = new ArrayList<Edge>();
            
            
            for(int i = 0; i < edgeList.size(); i++)
            {
                Edge edge = edgeList.get(i);
                
                int x = find(edge.a);
                int y = find(edge.b);
                
                if (x != y)
                {
                    mst.add(edge);
                    vertexToEdgeMap.get(edge.a).add(edge);
                    vertexToEdgeMap.get(edge.b).add(edge);
                    union(x, y);
                }
            }
            
            
            System.out.println("Case #" + caseNr++);
            for(int q = 0; q < Q; ++q)
            {
                token = new StringTokenizer(reader.readLine());
                int c1 = Integer.parseInt(token.nextToken());
                int c2 = Integer.parseInt(token.nextToken());
                
                if (find(c1) != find(c2))
                {
                    System.out.println("no path");
                }
                else
                {
                    dbmax = 0;
            		visited.add(c1);
            		path(c1, c2);
            		visited.remove(c1);
            		System.out.println(dbmax);
                }
                
            }
            
        }
    }
    
    public static boolean path(int currentVertex, int lastVertex)
    {
    	if (currentVertex == lastVertex)
    	{
    		for(Edge edge : resultEdgeList)
    		{
    			dbmax = Math.max(dbmax, edge.weight);
    		}
    		
    		return true;
    	}
    	
    	boolean result = false;
    	
    	List<Edge> edges =  vertexToEdgeMap.get(currentVertex);
        
    	for(int i = 0; i < edges.size() && !result; i++)
    	{
    		Edge edge  = edges.get(i);
    		
    		int visitingVertex = edge.a;
    		
    		if (visitingVertex == currentVertex)
    		{
    			visitingVertex = edge.b;
    		}
    		
    		if (visited.add(visitingVertex))
    		{
    			resultEdgeList.add(edge);
    			result = path(visitingVertex, lastVertex);
    			resultEdgeList.remove(edge);
    			visited.remove(visitingVertex);
    		}
    	}
    
    	return result;
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