import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
	public static int[] segmentTree = null;
	public static int result = 0;
	
	public static void main(String[] args) throws IOException
	{
		//long startTime = System.nanoTime();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N, K, i, j, I, V, J;
		char cmd;
		int product;
		String line = null;
		String lineSeparator = System.getProperty("line.separator");
		
		StringTokenizer token = null;
		StringBuilder builder = null;
		
		while((line = reader.readLine()) != null)
		{
			builder = new StringBuilder();
			token = new StringTokenizer(line);
			N = Integer.valueOf(token.nextToken());
			K = Integer.valueOf(token.nextToken());

			segmentTree = constructSegmentTree(N);
			
			token = new StringTokenizer(reader.readLine());
			
			int[] arr = new int[N];
			
			i = 0;
			
			while(token.hasMoreTokens())
			{
				arr[i++] = getValue(token.nextToken());
			}
			
			constructSegmentTree(arr, 0, N-1, 0);

			for(i = 0; i < K; i++)
			{
				token = new StringTokenizer(reader.readLine());
				
				cmd = token.nextToken().charAt(0);
				switch(cmd)
				{
					case 'C':
						I = Integer.valueOf(token.nextToken()) - 1;

						updateValueUtil(0, N-1, I, getValue(token.nextToken()), 0);
						break;
					case 'P':
						I = Integer.valueOf(token.nextToken()) - 1;
						J = Integer.valueOf(token.nextToken()) - 1;
						
						product = getProduct(N, I, J);

						switch (product)
						{
							case 1:
								builder.append('+');
								break;
							case -1:
								builder.append('-');
								break;
							case 0:
								builder.append('0');
								break;
						}
				}
			}
			builder.append(lineSeparator);
			System.out.print(builder.toString());
		}
		//long endTime = System.nanoTime();
		//System.out.println("Running time was " + (endTime - startTime)/1000000f + " milliseconds");
	}
	
	public static int getValue(String value)
	{
		switch(value.charAt(0))
		{
			case '0':
				result = 0;
				break;
			case '-':
				result = -1;
				break;
			default:
				result = 1;
				break;
		}
		return result;
	}
	
	public static int getMiddle(int s, int e) 
	{
		return s + (e - s) / 2;
	}
	
	public static int[] constructSegmentTree(int n)
	{
		int x = (int) Math.ceil(Math.log(n) / Math.log(2.0));
		int max_size = (int)(2 * Math.pow(2, x) - 1);
		return new int[max_size];
	}
	
	public static int constructSegmentTree(int arr[], int start, int end, int index)
	{
		if (start == end)
		{
			segmentTree[index] = arr[start];
			return arr[start];
		}
		
		int mid = getMiddle(start, end);
		segmentTree[index] = constructSegmentTree(arr, start, mid, index * 2 + 1) *
								constructSegmentTree(arr, mid+1, end, index * 2 + 2);
		return segmentTree[index];
	}
	
	public static int getProduct(int n, int start, int end)
	{
		if (start < 0 || end > n - 1 || start > end)
		{
			return 0;
		}
		
		return getProductUtil(0, n-1, start, end, 0);
	}
	
	public static int getProductUtil(int start, int end, int queryStart, int queryEnd, int index)
	{
		if (queryStart <= start && queryEnd >= end)
		{
			return segmentTree[index];
		}
		
		if (end < queryStart || start > queryEnd)
		{
			return 1;
		}
		
		int mid = getMiddle(start, end);
		return getProductUtil(start, mid, queryStart, queryEnd, 2 * index + 1) *
				getProductUtil(mid + 1, end, queryStart, queryEnd, 2 * index + 2);
	}
	
	public static int updateValueUtil(int start, int end, int indexToUpdate, int newValue, int currentIndex)
	{
		if (indexToUpdate < start || indexToUpdate > end)
		{
			return segmentTree[currentIndex];
		}

		if (start == end)
		{
			segmentTree[currentIndex] = newValue;
			return segmentTree[currentIndex];
		}
		
		int mid = getMiddle(start, end);
		segmentTree[currentIndex] = updateValueUtil(start, mid, indexToUpdate, newValue, 2 * currentIndex + 1) *
							updateValueUtil(mid + 1, end, indexToUpdate, newValue, 2 * currentIndex + 2);
		
		
		return segmentTree[currentIndex];
	}
}