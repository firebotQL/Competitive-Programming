import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static List<Edge> edges = new ArrayList<Edge>();
    public static Set<Integer> visited = new HashSet<Integer>();
    
    public static int[] energy = new int[101];
    public static long[] d = new long[101];
    public static long[] p = new long[101];
    
    public static int n; 

    public static class Edge
    {
        int u, v;
        public Edge(int u, int v)
        {
            this.u = u;
            this.v = v;
        }
    }
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
        String line = null;
        while(scan.hasNextInt())
        {
            n = scan.nextInt();
            
            if (n == -1)
            {
                break;
            }
            
            edges.clear();
            visited.clear();
            
            for(int i = 0; i < n; i++)
            {
                int currentEnergy = scan.nextInt();
                int doorways = scan.nextInt();
                
                energy[i] = currentEnergy;
                
                for(int j = 0; j < doorways; j++)
                {
                    int nextRoom = scan.nextInt() - 1;
                    edges.add(new Edge(i, nextRoom));
                }
            }
            
            
            relax();
            
            if (d[n-1] > 0 || cycle())
            {
                System.out.println("winnable"); 
            }
            else
            {
                System.out.println("hopeless");
            }
        }
        
        
    }
    
    public static void relax()
    {
        
        for(int i = 1; i < n; ++i)
        {
            d[i] = Long.MIN_VALUE;
        }
        
        d[0] = 100;
        
        for(int i = 0; i < n - 1; ++i)
        {
            for(int j = 0; j < edges.size(); ++j)
            {
                Edge edge = edges.get(j);
                
                if (d[edge.u] <= 0) continue;
                
                d[edge.v] = Math.max(d[edge.u] + energy[edge.v], d[edge.v]);
            }
        }
    }
    
    public static boolean cycle()
    {
        for(int i = 0; i < edges.size(); ++i)
        {
            Edge edge = edges.get(i);
            
            if (d[edge.u] <= 0) continue;
            
            if (d[edge.u] + energy[edge.v] > d[edge.v] && reach(edge.u))
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean reach(int v)
    {
        if (v == (n - 1))
        {
            return true;
        }
        
        visited.add(v);
        
        for(int i = 0; i < edges.size(); ++i)
        {
            Edge edge = edges.get(i);
            
            if(edge.u == v && !visited.contains(edge.v) && reach(edge.v))
            {
                return true;
            }
        }
        
        return false;
    } 
}
