import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static long[][][] paral3D = new long[21][21][21];
	public static long[][] grid2D = new long[21][21];
	public static long[] array1D = new long[21];
	public static int A, B, C;
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int T = scan.nextInt();
		int  x, y, z;
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
						paral3D[x][y][z] = scan.nextLong();
					}
				}
			}
			
			System.out.println(max3D());
			if (T != 0)
			{
				System.out.println();
			}
		}
	}
	
	public static long max1D()
	{
		long answer = Long.MIN_VALUE;
		long sum = 0;
		for(int x = 0; x < C; x++)
		{
			if (sum >= 0)
				sum += array1D[x];
			else
				sum = array1D[x];
			
			answer = Math.max(answer, sum);
		}
		
		return answer;
	}
	
	public static long max2D()
	{
		long answer = Long.MIN_VALUE;
		int x, y, z;
		for(x = 0; x < B; x++)
		{
			Arrays.fill(array1D, 0);
			for(y = x; y < B; y++)
			{
				for(z = 0; z < C; z++)
				{
					array1D[z] += grid2D[y][z];
				}
				answer = Math.max(answer, max1D());
			}
		}
		return answer;
	}
	
	public static long max3D()
	{
		long answer = Long.MIN_VALUE;
		
		int x, y, z, q;
		for(x = 0; x < A; x++)
		{
			reset2DtoAllZeros();
			for(y = x; y < A; y++)
			{
				for(z = 0; z < B; z++)
				{
					for(q = 0; q < C; q++)
					{
						grid2D[z][q] += paral3D[y][z][q];	// sum for each layer y;
					}
				}
				answer = Math.max(answer, max2D());
			}
		}
		return answer;
	}
	
	public static void reset2DtoAllZeros()
	{
		for (long[] row : grid2D)
			Arrays.fill(row, 0);
	}
}