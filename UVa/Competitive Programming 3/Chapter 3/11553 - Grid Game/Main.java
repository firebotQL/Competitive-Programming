import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(reader.readLine());
		String[] separatedLine = null;
		int[][] array = new int[8][8];
		int i, j, A, B, n;
		int[] numbers = null;
		int min, result;
		boolean lost;
		
		while(t-- != 0)
		{
			n = Integer.valueOf(reader.readLine());
			
			numbers = new int[n];
			
			for(i = 0; i < n; i++)
			{
				separatedLine = reader.readLine().split("\\s+");
				for(j = 0; j < n; j++)
				{
					array[i][j] = Integer.valueOf(separatedLine[j]);
				}
				numbers[i] = i;
			}
			
			result = Integer.MAX_VALUE;
			
			do
			{
				min = 0;
				
				for(i = 0; i < n; i++)
				{
					min += array[i][numbers[i]];
				}
				
				if (result > min)
				{
						result = min;
				}
				
			} while(nextPermutation(numbers));
			
			System.out.println(result);
		}
	}
	
	public static boolean nextPermutation(int[] a)
	{
		int N = a.length;
		int temp;
		int i = N - 2;
		
		// Checking if it is ascending order
		// and stopping at descending order or the end
		for(; i >= 0; i--) 
		{
			if (a[i] < a[i+1])
			{
				break;
			}
		}
		
		// if array has less than one element then dont permute
		if (i < 0) 
		{
			return false;
		}
		
		// swapping elements around with the last found descending
		for(int j = N - 1; j >= i; j--)
		{
			if (a[j] > a[i])
			{
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				break;
			}
		}
		
		for(int j = i + 1; j < (N + i + 1) / 2; j++)
		{
			temp = a[j];
			a[j] = a[N+i-j];
			a[N+i-j] = temp;
		}
		
		return true;
	}
}