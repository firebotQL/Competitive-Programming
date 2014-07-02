import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] array = new int[500][500];
	public static int low, high, mid, answer;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null;
		int N, M, i, j, Q, L, U, lowerIndex, max, k, size;
		StringBuffer buffer = null;
		String lineSeparator = System.lineSeparator();
		
		while((line = reader.readLine()) != null)
		{
			splitLine = line.split("\\s+");
			N = Integer.valueOf(splitLine[0]);
			M = Integer.valueOf(splitLine[1]);
			
			if (N == 0 && M == 0)
			{
				break;
			}
			
			for(i = 0; i < N; i++)
			{
				splitLine = reader.readLine().split("\\s+");
				for(j = 0; j < M; j++)
				{
					array[i][j] = Integer.valueOf(splitLine[j]);
				}
			}
			
			Q = Integer.valueOf(reader.readLine());
			buffer = new StringBuffer();
			size = M - 1;
			while(Q-- != 0)
			{
				splitLine = reader.readLine().split("\\s+");
				
				L = Integer.valueOf(splitLine[0]);
				U = Integer.valueOf(splitLine[1]);

				max = 0;
				for(i = 0; i < N; i++)
				{
					lowerIndex = lower_bound(array, i, size, L);		// included index (1)
					
					if (lowerIndex == -1)
					{
						continue;
					}
					
					for(k = max; k < N; k++)
					{
						if (i + k >= N || 
								lowerIndex + k >= M || 
									array[i + k][lowerIndex + k] > U) 
						{
							break;
						}
						if (k + 1 > max) 
						{
							max = k + 1;
						}
					}
					
				}
				buffer.append(max).append(lineSeparator);
			}
			buffer.append('-').append(lineSeparator);
			System.out.print(buffer.toString());
		}
	}
	
	/*public static int findMaxSubSquare(boolean[][] helper, int N, int M)
	{
		int[][] S = new int[N][M];
		
		for(int i = 0; i < N; i++)
		{
			S[i][0] = helper[i][0] ? 1 : 0;
		}
		
		for(int i = 0; i < M; i++)
		{
			S[0][i] = helper[0][i] ? 1 : 0;
		}
		
		int size = 0;
		
		for(int i = 1; i < N; i++)
		{
			for(int j = 1; j < M; j++)
			{
				if (helper[i][j])
				{
					S[i][j] = Math.min(Math.min(S[i][j-1], S[i-1][j-1]), S[i-1][j-1]) + 1;
				}
				else
				{
					S[i][j] = 0;
				}
				
				if (S[i][j] > size)
				{
					size = S[i][j];
				}
			}
		}
		return size;
		
	}
	*/
	// while bigger or equal then include
	public static int lower_bound(int[][] array, int row, int size, int value)
	{
		low = 0;
		high = size;
		mid = 0;
		answer = -1;
		
		while(low <= high)
		{
			mid = low + (high - low) / 2;
			if (array[row][mid] >= value)
			{
				answer = mid;
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		
		return answer;
	}
}