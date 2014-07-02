import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int[][] array = new int[101][101];
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int N, i, j, k, l, maxSubRect, subRect; 
		while(scanner.hasNext())
		{
			N = scanner.nextInt();
			
			for(i = 0; i < N; i++)
			{
				for(j = 0; j < N; j++)
				{
					array[i][j] = scanner.nextInt();
					if (i > 0) array[i][j] += array[i-1][j];
					if (j > 0) array[i][j] += array[i][j-1];
					if (i > 0 && j > 0) array[i][j] -= array[i-1][j-1];
				}
			}
			
			maxSubRect = -127000000;
			
			for(i = 0; i < N; i++)
			{
				for(j = 0; j < N; j++)
				{
					for(k = i; k < N; k++)
					{
						for(l = j; l < N; l++)
						{
							subRect = array[k][l]; // sum of all items from (i, j) to (k, l)
							if (i > 0) subRect -= array[i-1][l];
							
							if (j > 0) subRect -= array[k][j-1];
							
							
							if (i > 0 && j > 0) subRect += array[i - 1][j - 1];
							
							maxSubRect = Math.max(subRect, maxSubRect);
						}
					}
				}
			}
			
			System.out.println(maxSubRect);
		}
	}
}