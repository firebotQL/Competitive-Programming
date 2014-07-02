import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	// Manhattan distance path = Math.abs(threeCoord.x - oneCoord.x) + Math.abs(threeCoord.y - oneCoord.y);
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] splitLine = null;
		int t = Integer.valueOf(reader.readLine());
		int n, a, b, c, d, e, row, col, min, minDist, A, B, C, D, E, population;
		int[][] area = null;
		int[] minFiveDistances = new int[5];
		while(t-- != 0)
		{
			area = new int[5][5];		
			n = Integer.valueOf(reader.readLine());
			
			while(n-- != 0)
			{
				splitLine = reader.readLine().split("\\s+");
				row = Integer.valueOf(splitLine[0]);
				col = Integer.valueOf(splitLine[1]);
				population = Integer.valueOf(splitLine[2]);
				area[row][col] = population;
				
			}
			
			min = 0;
			minDist = Integer.MAX_VALUE;
			
			for(a = 0; a < 25; a++)
			{
				for(b = a + 1; b < 25; b++)
				{
					for(c = b + 1; c < 25; c++)
					{
						for(d = c + 1; d < 25; d++)
						{
							for(e = d + 1; e < 25; e++)
							{
								min = 0;
								for(row = 0; row < 5; row++)
								{
									for(col = 0; col < 5; col++)
									{
										population = area[row][col];
										A = getDistance(row, col, a / 5, a % 5) * population;
										B = getDistance(row, col, b / 5, b % 5) * population;
										C = getDistance(row, col, d / 5, d % 5) * population;
										D = getDistance(row, col, c / 5, c % 5) * population;
										E = getDistance(row, col, e / 5, e % 5) * population;
										min += Math.min(Math.min(A, Math.min(B, C)), Math.min(D, E));
									}
								}
								if (min < minDist)
								{
									minDist = min;
									minFiveDistances = new int[] {a, b, c, d, e};
								}
							}
						}
					}
				}
			} 
			System.out.printf("%d %d %d %d %d\n", minFiveDistances[0], minFiveDistances[1], minFiveDistances[2], minFiveDistances[3], minFiveDistances[4] );
		}
	}
	
	private static int getDistance(int x1, int y1, int x2, int y2)
	{
		return Math.abs(x1 - x2) + Math.abs(y1 -  y2);
	}
}