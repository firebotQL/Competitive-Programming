import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static long max = 0;
	public static int n = 0;
	public static int[] xCoord = new int[1000];
	public static int[] yCoord = new int[1000];
	public static char[][] grid = new char[1000][1000];
	
	public static int minY = 0, maxX = 0, maxY = 0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line = reader.readLine()) != null)
		{
			n = Integer.valueOf(line);
			Arrays.fill(xCoord, 0, n, 0);
			Arrays.fill(yCoord, 0, n, 0);
			
			for(char[] row : grid)
			{
				Arrays.fill(row, ' ');
			}
			
			line =  reader.readLine();
			String[] split = line.split("\\s+");
			System.out.println(n + " " + line);
			minY = 0;
			maxX = 0;
			maxY = 0;
			fillCoords(split);
			
			int offset = minY * -1;
			int sX = 0, sY = 0 + offset;
			
			maxY += offset;
			
			for(int i = 0; i < n; i++)
			{
				//System.out.println("sX+sY: " + sX + " " + sY);
				System.out.println("coord: " + xCoord[i] + " " + (yCoord[i] + offset));
				
				while(sX != xCoord[i]  && sY != (yCoord[i] + offset))
				{
					System.out.println(sX + " " + sY);
					if (sY < (yCoord[i] + offset))
					{
						grid[sY][sX] = '/';
						sY++;
					}
					else
					{
						grid[sY][sX] = '\\';
						sY--;
					}
					sX++;

					for(int z = maxX; z >= 0; z--)
					{
						for(int j = 0; j <= maxY; j++)
						{
							System.out.print(grid[z][j]);
						}
						System.out.println();
					}
				}
				
				
				//sY -= offset;
				System.out.println(sX + " " + sY);
				System.out.println("-----");
			}
			
			for(int i = maxX; i >= 0; i--)
			{
				for(int j = 0; j <= maxY; j++)
				{
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
			
		}
	}
	
	public static void fillCoords(String[] split)
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				xCoord[i] += Integer.valueOf(split[j]);
				yCoord[i] += Integer.valueOf(split[j]) * (int)Math.pow(-1.0, j+1+1); 
				minY = Math.min(yCoord[i], minY);
				maxY = Math.max(xCoord[i], maxY);
				maxX = Math.max(yCoord[i], maxX);
			}
		}
	}

	
}