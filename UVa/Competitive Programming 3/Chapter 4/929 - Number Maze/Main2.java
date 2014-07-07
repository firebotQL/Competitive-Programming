import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    public static Vertex[][] graphSet = new Vertex[1000][1000];
    
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0 };
    
    public static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
    
    public static class Vertex implements Comparable<Vertex>
    {
        public int x, y;
        public int distance;
        public int cost;
        
        public Vertex(int x, int y, int distance, int cost )
        {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.cost = cost;
        }
        
        public int compareTo(Vertex v)
        {
			return this.distance - v.distance;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        while(cases-- != 0)
        {
            int N = Integer.parseInt(reader.readLine());
            int M = Integer.parseInt(reader.readLine());
            
            pq.clear();
            
            for(int i = 0; i < N; ++i)
            {
                StringTokenizer token = new StringTokenizer(reader.readLine());
                for(int j = 0; j < M; ++j)
                {
                    int tmpcost = Integer.parseInt(token.nextToken());                    
                    Vertex newVertex = new Vertex(i, j, Integer.MAX_VALUE, tmpcost);
                    graphSet[i][j] = newVertex;   
                    pq.add(newVertex);
                }
            }
			
			if (N == 1 && M == 1)
			{
				System.out.println(graphSet[0][0].cost);
				continue;
			}
			
			Vertex vertex = graphSet[0][0];
			pq.remove(vertex);
			vertex.distance = vertex.cost;
			pq.add(vertex);
			
            while(!pq.isEmpty())
            {
                Vertex u = pq.poll();
				
                for(int i = 0; i < 4; ++i)
                {
                    int nx = u.x + dx[i];
                    int ny = u.y + dy[i];
                    
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                    {
                           Vertex v = graphSet[nx][ny];
                           int alt = u.distance + v.cost;
                           
                           if (alt < v.distance)
                           {
                               pq.remove(v);
                               v.distance = alt;
                               pq.offer(v);
                           }
                    }
                }
				
            }
            System.out.println(graphSet[N-1][M-1].distance);
        }
    }
}
			}
			
			Vertex vertex = graphSet[0][0];
			pq.remove(vertex);
			vertex.distance = vertex.cost;
			pq.add(vertex);
			
            while(!pq.isEmpty())
            {
                Vertex u = 