import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static byte[][] grid = new byte[50][50];
	public static int[] dx = { 0, 1, 0,  -1};
	public static int[] dy = { -1, 0, 1, 0 };
	public static Map<String, Integer> directionMap = new HashMap<String, Integer>();
	public static Map<Integer, String> directionMap2 = new HashMap<Integer, String>();
	public static String currentDirection = null;
	
	static 
	{
		directionMap.put("north", 0);
		directionMap.put("east", 1);
		directionMap.put("south", 2);
		directionMap.put("west", 3);
		
		directionMap2.put(0, "north");
		directionMap2.put(1, "east");
		directionMap2.put(2, "south");
		directionMap2.put(3, "west");
	}
	
	public static int N, M;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			M = Integer.parseInt(token.nextToken());
			N = Integer.parseInt(token.nextToken());
			
			if (M == 0 && N == 0)
			{
				break;
			}
			
			for(int i = 0; i < M; ++i)
			{
				token = new StringTokenizer(reader.readLine());
				for(int j = 0; j < N; ++j)
				{
					grid[i][j] = Byte.parseByte(token.nextToken());
				}
			}
			
			token = new StringTokenizer(reader.readLine());
			
			int startX = Integer.parseInt(token.nextToken()) - 1;
			int startY = Integer.parseInt(token.nextToken()) - 1;
			
			int endX = Integer.parseInt(token.nextToken()) - 1;
			int endY = Integer.parseInt(token.nextToken()) - 1;
			print(startX, startY);
			currentDirection = token.nextToken();
			
			System.out.println(bfs(startX, startY, endX, endY));
		}
		
	}
	
	public static void markUsed(int startX, int startY)
	{
		grid[startX][startY] = 1;
	}
	
	public static int bfs(int startX, int startY, int endX, int endY)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startX);
		queue.add(startY);
		queue.add(directionMap.get(currentDirection));
		queue.add(0);
		
		markUsed(startX, startY);
		
		while(!queue.isEmpty())
		{
			int x = queue.poll();
			int y = queue.poll();
			int d = queue.poll();
			int z = queue.poll();
			
			if (endX == x && endY == y)
			{
				return z;
			}
			
			int seconds = z + 1;
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (!place(queue, nx, ny, d))	// if not placed in same direction
			{
				for(int i = 0; i < 4; i++)
				{
					nx = x + dx[i];
					ny = y + dy[i];
					
					if (place(queue, x, y, i))
					{
						if (d != i)
						{
							seconds += (i % 2 ==  d % 2) ? 2 : 1;
						}
						break;
					}
				}
			}
			queue.add(seconds);
		}
		return -1;
	}
	
	public static boolean place(Queue<Integer> queue, int x, int y, int i)
	{
		if (canPlace(x, y, i))
		{
			markUsed(x, y);
			print(x, y);
			queue.add(x);
			queue.add(y);
			queue.add(i);
			return true;
		}
		return false;
	}
	
	public static void print(int nx, int ny)
	{
		System.out.println("------------");
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{

				if ((nx == i && ny == j) || (nx == (i - 1) && ny == (j - 1))
					|| (nx == i && ny == (j - 1)) || (nx == (i - 1) && ny == j))
				{
					System.out.print(2 + " ");
				}
				else
				{
					System.out.print(grid[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static boolean canPlace(int x, int y, int direction)
	{
		if (cannotPlaceBoundary(x, y))
		{
			return false;
		}
		
		int nx1 = 0;
		int ny1 = 0;
		
		int nx2 = 0;
		int ny2 = 0;
		
		switch(direction)
		{
			case 0:
				nx1 = x;
				ny1 = y - 1;
				nx2 = x + 1;
				ny2 = y - 1;
				break;
			case 1:
				nx1 = x + 1;
				ny1 = y;
				nx2 = x + 1;
				ny2 = y + 1;
				break;
			case 2:
				nx1 = x;
				ny1 = y + 1;
				nx2 = x + 1;
				ny2 = y + 1;
				break;
			case 3:
				nx1 = nx2 = x;
				ny1 = ny2 = y + 1;
				break;
		}
		
		if (cannotPlaceBoundary(nx1, ny1) || cannotPlaceBoundary(nx2, ny2) || grid[nx1][ny1] == 1 || grid[nx2][ny2] == 1)
		{
			return false;
		}
		
		return true;
	}
	
	public static boolean cannotPlaceBoundary(int x, int y)
	{
		return x < 0 || y < 0 || x >= M - 1 || y >= N - 1 || grid[x][y] == 1;
	}
}