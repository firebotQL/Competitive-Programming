import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N, n, i;
		
		StringTokenizer tokenizer = null;
		
		char[][] NArray = null;
		char[][][] nArray = null;
		
		int result[] = null;
		
		while((tokenizer = new StringTokenizer(reader.readLine())).hasMoreTokens())
		{
			N = Integer.parseInt(tokenizer.nextToken());
			n = Integer.parseInt(tokenizer.nextToken());
			
			if (N == 0 && n == 0)
			{
				break;
			}
			
			NArray = new char[N][];
			nArray = new char[4][n][];
			
			for(i = 0; i < N; i++)
			{
				NArray[i] = reader.readLine().toCharArray();
			}
			
			for(i = 0; i < n; i++)
			{
				nArray[0][i] = reader.readLine().toCharArray();
			}
			
			nArray[1] = rotateArray(nArray[0], n);
			nArray[2] = rotateArray(nArray[1], n);
			nArray[3] = rotateArray(nArray[2], n);
			
						
			result = contains(NArray, nArray,  N, n);
			
			System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
		}
	}
	
	public static char[][] rotateArray(char[][] nArray, int n)
	{
		int i, j;
		char tmp;
		
		char[][] result = new char[n][n];
		
		for(i = 0; i < n; i++)
		{
			for(j = 0; j < n; j++)
			{
				result[j][n - 1 - i] = nArray[i][j];
			}
		}
		
		return result;
	}
	
	public static char[][] rotateInplaceArray(char[][] nArray, int n)
	{
		int i, j;
		int med = n/2;
		char tmp;
		for(i = 0; i < med; i++)
		{
			for(j = i; j < n - i - 1; j++)
			{
				tmp = nArray[i][j];
                nArray[i][j] = nArray[j][n-i-1];
                nArray[j][n-i-1] = nArray[n-i-1][n-j-1];
                nArray[n-i-1][n-j-1] = nArray[n-j-1][i];
                nArray[n-j-1][i] = tmp;
			}
		}
		return nArray;
	}
	
	public static int[] contains(char[][] NArray, char[][][] nArray, int N, int n)
	{
		int i, j, z;
		int fieldsToCheck = N - n;
		int count = 0;
		int[] result = new int[4];
		
		int resultMatcher = n * n;
	
		if (n != 0)
		{
			for(i = 0; i <= fieldsToCheck; i++)
			{
				for(j = 0; j <= fieldsToCheck; j++)
				{
					for(z = 0; z < 4; z++)
					{
						if (NArray[i][j] == nArray[z][0][0])
						{
							count = countOccurrences(NArray, nArray[z], i, j, n);
							
							if (count == resultMatcher)
							{
								result[z]++;
							}
						}
						
												
					}
				}
			}
		}
		return result;
	}
	
	public static int countOccurrences(char[][] NArray, char[][] nArray, int i, int j, int n)
	{
		int count = 0;
		int x, y;
		for(x = 0; x < n; x++)
		{
			for(y = 0; y < n; y++)
			{	
				if (NArray[i+x][j+y] == nArray[x][y])
				{
					count++;
				}
			}
		}
		
		return count;
	}
}