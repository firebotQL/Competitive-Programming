import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static long[][][] paral = new long[21][21][21];
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int T = scan.nextInt();
		int A, B, C, x, y, z, x1, y1, z1, row;
		long maxSubParal, subParal, cube;
		while(T-- != 0)
		{
			A = scan.nextInt();
			B = scan.nextInt();
			C = scan.nextInt();
			for(x = 0; x < A; x++)
			{
				for(y = 0; y < B; y++)
				{
					for(z = 0; z < C; z++)
					{
						cube = scan.nextLong();
						paral[x][y][z] = cube;
						
						if (x > 0) paral[x][y][z] += paral[x-1][y][z];
						if (y > 0) paral[x][y][z] += paral[x][y-1][z];
						if (z > 0) paral[x][y][z] += paral[x][y][z-1];
						
						if (x > 0 && y > 0 && z > 0) paral[x][y][z] -= paral[x-1][y-1][z-1];
						else
						if (y > 0 && z > 0) paral[x][y][z] -= paral[x][y-1][z-1];
						
						System.out.println(x + " " + y + " " + z + " sum: " + (paral[x][y][z]) + ": cube - " + cube);
					}
				}
			}
			System.out.println(paral[1][1][1]);
			System.out.println();
			maxSubParal = Long.MIN_VALUE;

			for(x = 0; x < A; x++)
			{
				for(y = 0; y < B; y++)
				{
					for(z = 0; z < C; z++)
					{
						for(x1 = x; x1 < A; x1++)
						{
							for(y1 = y; y1 < B; y1++)
							{
								for(z1 = z; z1 < C; z1++)
								{
									subParal = paral[x1][y1][z1];
									if (x1 > 0) subParal -= paral[x][y1][z1];
									if (y1 > 0) subParal -= paral[x1][y][z1];
									if (z1 > 0) subParal -= paral[x1][y1][z];
									if (x1 > 0 && y1 > 0 && z1 > 0) subParal += paral[x][y][z];
									else
									if (y1 > 0 && z1 > 0) subParal += paral[x1][y][z];
									maxSubParal = Math.max(maxSubParal, subParal);
								}
							}
						}
					}
				}
			}
			
			System.out.println(maxSubParal);
		}
	}
}