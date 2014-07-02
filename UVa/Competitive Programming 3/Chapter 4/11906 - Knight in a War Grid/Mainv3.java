import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	private static int[][] grid = new int[101][101];
	private static boolean[][] visited = new boolean [101][101];	
	private static int[] xStack = new int[1000000];
	private static int[] yStack = new int[1000000];
	
	private static int i, j;
	
	private static class Node
	{
		public int x, y;
		public Node(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Node other = (Node) obj;
			return x == other.x && y == other.y;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T, W, R, C, M, N, caseNr = 1, even, odd, newX, newY, mulX, mulY, gridVal, stackPointer, tx, ty;
		T = Integer.valueOf(reader.readLine());
		String[] line = null;
		
		int[][] inc = null;
		StringBuffer buffer = new StringBuffer();
		String lineSeparator = System.getProperty("line.separator");
		Set<Node> set = new HashSet<Node>();
		while(T-- != 0)
		{
			
			line = reader.readLine().split("\\s+");
			R = Integer.valueOf(line[0]);
			C = Integer.valueOf(line[1]);
			M = Integer.valueOf(line[2]);
			N = Integer.valueOf(line[3]);
			
			W = Integer.valueOf(reader.readLine());
			
			set.clear();
			set.add(new Node(N, M));
			set.add(new Node(N, -M));
			set.add(new Node(-N, M));
			set.add(new Node(-N, -M));
			set.add(new Node(M, N));
			set.add(new Node(M, -N));
			set.add(new Node(-M, N));
			set.add(new Node(-M, -N));
			
			//System.out.println(set.size());
			//inc = new int[][] { { N, M }, { N, -M}, {-N, M}, {-N, -M}, {M, N}, {M, -N}, {-M, N} , {-M, -N} };
			
			while(W-- != 0)
			{
				line = reader.readLine().split("\\s+");
				grid[Integer.valueOf(line[0])][Integer.valueOf(line[1])] = -1;
			}
			
			even = odd = stackPointer = 0;

			xStack[stackPointer] = 0;
			yStack[stackPointer] = 0;
			
			while(stackPointer != -1)
			{
				tx = xStack[stackPointer];
				ty = yStack[stackPointer];
				stackPointer--;
				
				if (!visited[tx][ty])
				{
					visited[tx][ty] = true;
					
					for(Node node : set)
					{
						newX = tx + node.x; 
						newY = ty + node.y;
						
						if (newX >= 0 && newX < R && newY >= 0 && newY < C && grid[newX][newY] != -1)
						{
							grid[newX][newY]++;
							stackPointer++;
							xStack[stackPointer] = newX;
							yStack[stackPointer] = newY;
						}
					}
				}
			}
			
			for(i = 0; i < R; i++)
			{
				for(j = 0; j < C; j++)
				{
					gridVal = grid[i][j];

					if (gridVal > 0)
					{
						if (gridVal % 2 == 0)
						{
							even++;
						}
						else
						{
							odd++;
						}
					}
					
					grid[i][j] = 0;
					visited[i][j] = false;
				}
			}
			
			buffer.append("Case ").append(caseNr++).append(": ").append(even).append(" ").append(odd).append(lineSeparator);
		}
		System.out.print(buffer.toString());
	}
}