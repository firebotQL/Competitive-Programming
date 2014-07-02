import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static long[][][] par = new long[21][21][21];
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int cases = scan.nextInt();
		int total = 0;
		int A, B, C, x, y, z;
		long sum, sum2, sum3, answer, answer2, answer3;
		while(cases-- != 0)
		{
			sum = 0;
			sum2 = 0;
			sum3 = 0;
			answer = Long.MIN_VALUE;
			answer2 = Long.MIN_VALUE;
			answer3 = Long.MIN_VALUE;
			A = scan.nextInt();
			B = scan.nextInt();
			C = scan.nextInt();
			
			for(x = 0; x < A; x++)
			{
				for(y = 0; y < B; y++)
				{
					for (z = 0; z < C; z++)
					{
						par[x][y][z] = scan.nextLong();
					}
				}
			}
			
			for(x = 0; x < A; x++)
			{
				for(y = 0; y < B; y++)
				{
					for (z = 0; z < C; z++)
					{
						sum += par[x][y][z];
						answer = Math.max(answer, sum);
						if (sum < 0) sum = 0;
					}
					sum2 += answer;
					answer2 = Math.max(answer2, sum2);
					if (sum2 < 0) sum2 = 0;
				}
				sum3 += answer2;
				answer3 = Math.max(answer3, sum3);
				if (sum3 < 0) sum3 = 0;
			}
			
			System.out.println(answer3);
			
			if (cases - 1 > 0)
			{
				System.out.println();
			}
		}
	}
}