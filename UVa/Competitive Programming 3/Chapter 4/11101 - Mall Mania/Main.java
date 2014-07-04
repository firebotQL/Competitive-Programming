import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static boolean[][] city = new boolean[2005][2005];
	public static boolean[][] visited = new boolean[2005][2005];
	
	public static Queue<Node> graph = new LinkedList<Node>();
	
	public static int dx[] = { 0, -1, 1, 0 };
	public static int dy[] = { 1, 0, 0, -1 };
	
	public static class Node
	{
		public int x, y, dist;
		
		public Node(int x, int y, int dist)
		{
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line = reader.readLine()) != null)
			{
				int p = Integer.parseInt(line);
				
				if (p == 0)
				{
					break;
				}
				for(int i = 0; i < 2005; ++i)
				{
					for(int j = 0; j < 2005; ++j)
					{
						visited[i][j] = city[i][j] = false;
					}
				}
				
				graph.clear();
				
				while(p != 0)
                {
                    StringTokenizer token = new StringTokenizer(reader.readLine());
                    while(token.hasMoreTokens())
                    {
                        int a = Integer.parseInt(token.nextToken());
                        int s = Integer.parseInt(token.nextToken());
                        graph.add(new Node(a, s, 0));
                        p--;
                    }
                }
                
                p = Integer.parseInt(reader.readLine());
                
                while(p != 0)
                {
                    StringTokenizer token = new StringTokenizer(reader.readLine());
                    while(token.hasMoreTokens())
                    {
                        int a = Integer.parseInt(token.nextToken());
                        int s = Integer.parseInt(token.nextToken());
                        city[a][s] = true;
                        p--;
                    }
                }

                System.out.println(bfs());
			}
	}
	
	public static int bfs()
	{
		while(!graph.isEmpty())
		{
			Node node = graph.poll();
			for(int i = 0; i < 4; i++)
			{
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				
				if (x >= 0 && x < 2000 && y >= 0 && y < 2000)
				{
					if (!visited[x][y])
					{
						visited[x][y] = true;
						if (city[x][y])
						{
							return node.dist + 1;
						}
						graph.add(new Node(x, y, node.dist + 1));
					}
				}
			}
		}
		return -1;
	}
}
