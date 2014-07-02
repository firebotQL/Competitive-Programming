import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static boolean[][] map = new boolean[1001][1001];
	public static int R, C;
	public static int[] dy = { 1, -1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		//long startTime = System.nanoTime();
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			R = Integer.parseInt(token.nextToken());
			C = Integer.parseInt(token.nextToken());
			
			if (R == 0 && C == 0)
			{
				break;
			}

			for(int i = 0; i < R; ++i)
			{
				Arrays.fill(map[i], 0, C, false);
			}
			
			token = new StringTokenizer(reader.readLine());
			int rows = Integer.parseInt(token.nextToken());

			for(int i = 0; i < rows; ++i)
			{
				token = new StringTokenizer(reader.readLine());
				int rowNr = Integer.parseInt(token.nextToken());
				int bombCnt = Integer.parseInt(token.nextToken());
				for(int j = 0; j < bombCnt; ++j)
				{
					int columnNr = Integer.parseInt(token.nextToken());
					map[rowNr][columnNr] = true;
				}
			}
			
			token = new StringTokenizer(reader.readLine());
			int startX = Integer.parseInt(token.nextToken());
			int startY = Integer.parseInt(token.nextToken());
			
			token = new StringTokenizer(reader.readLine());
			int endX = Integer.parseInt(token.nextToken());
			int endY = Integer.parseInt(token.nextToken());

			System.out.println(bfs(startX, startY, endX, endY));
		}
		//long endTime = System.nanoTime();
		//System.out.println((endTime - startTime) / 1000000.0);
	}
	
	public static int bfs(int startX, int startY, int endX, int endY)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		queue.add(startX);
		queue.add(startY);
		
		map[startX][startY] = true;
		int count = 0;
		
		while(!queue.isEmpty())
		{
			int x = queue.poll();
			int y = queue.poll();
			
			if (x == endX && y == endY)
			{
				return count;
			}
			
			for(int i = 0; i < 4; ++i)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C && !map[nx][ny])
				{
					map[nx][ny] = true;
					queue2.add(nx);
					queue2.add(ny);
				}
			}
			
			if (queue.isEmpty())
			{
				Queue<Integer> tmpQueue = queue;
				queue = queue2;
				queue2 = tmpQueue;
				count++;
			}
		}
		
		return -1;
	}

}