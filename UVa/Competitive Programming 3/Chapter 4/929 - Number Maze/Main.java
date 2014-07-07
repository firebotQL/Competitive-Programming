import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    public static int[][] cost = new int[1000][1000];
    public static int[][] sum = new int[1000][1000];
	
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0 };
    
    public static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(1000000);
    
    public static class Vertex implements Comparable<Vertex>
    {
        public int x, y;
        public int sum;
        
        public Vertex(int x, int y, int sum)
        {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
        
        public int compareTo(Vertex v)
        {
			return this.sum - v.sum;
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
                    cost[i][j] = Integer.parseInt(token.nextToken());
					sum[i][j] = Integer.MAX_VALUE;
                    pq.offer(new Vertex(i, j, Integer.MAX_VALUE));
                }
            }
			
			if (N == 1 && M == 1)
			{
				System.out.println(cost[0][0]);
				continue;
			}
			
			pq.offer(new Vertex(0, 0, cost[0][0]));

			int result = -1;
			int ex = N - 1;
			int ey = M - 1;
			
            while(!pq.isEmpty())
            {
                Vertex u = pq.poll();
				
				if ((u.x == ex) && (u.y == ey))
				{
					result = u.sum;
					break;
				}
				
                for(int i = 0; i < 4; ++i)
                {
                    int nx = u.x + dx[i];
                    int ny = u.y + dy[i];
                    
					
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                    {         
					   int altSum = u.sum + cost[nx][ny];
					   
					   if (altSum < sum[nx][ny])
					   {
						   pq.offer(new Vertex(nx, ny, altSum));
						   sum[nx][ny] = altSum;
					   }
                    }
                }
            }
			
            System.out.println(result);
        }
    }
});
                }
            }
			
			if (N == 1 && M == 1)
			{
				System.out.println(cost[0][0]);
				continue;
			}
			
			pq.offer(new Vertex(0, 0, cost[0][0]));

			int result = -1;
			int ex = N - 1;
			int ey = M - 1; 
			
            while(!pq.isEmpty())
            {
                Vertex u = pq.poll();
				
				if ((u.x == ex) && (u.y == ey))
				{
					result = u.sum;
					break;
				}
				
                for(int i = 0; i <