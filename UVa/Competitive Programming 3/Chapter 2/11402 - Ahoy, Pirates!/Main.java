import java.util.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static int[] segmentTree = null;
	public static int[] lazyTree = null;
	public static int result = 0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String testString = null;
		
		long T = Long.valueOf(reader.readLine());
		
		int M, times, Q, a, b, size, cases, queries;
		String[] splitLine = null;
		char cmd;

		StringBuilder builder = null;
		
		segmentTree = constructSegmentTree(1024001);
		lazyTree = constructSegmentTree(1024001);
		
		for(cases = 1; cases <= T; cases++)
		{
			System.out.println("Case " + cases + ":");
			
			M = Integer.valueOf(reader.readLine());
			builder = new StringBuilder();
			
			while(M-- != 0)
			{
				times = Integer.valueOf(reader.readLine());
				line = reader.readLine();
				while(times-- != 0)
				{
					builder.append(line);
				}
			}
			
			size = builder.length();
			
			constructSegmentTree(builder, 0, size-1, 0);
			
			Q = Integer.valueOf(reader.readLine());
			
			queries = 1;
			
			builder = new StringBuilder();
			
			while(Q-- != 0)
			{
				splitLine = reader.readLine().split("\\s+");
				cmd = splitLine[0].charAt(0);
				a = Integer.valueOf(splitLine[1]);
				b = Integer.valueOf(splitLine[2]);
				switch(cmd)
				{
					case 'S':
						builder.append('Q').append(queries++).append(": ").append(getSum(size, a, b)).append(System.lineSeparator());
						break;
					default:
						updateRangeUtil(0, size - 1, a, b, cmd, 0);
						break;
				}
			}
			System.out.print(builder.toString());
		}
		
	}
	
	public static int getMiddle(int s, int e) 
	{
		return s + (e - s) / 2;
	}
	
	public static int getMaxSize(int n)
	{
		int x = (int) Math.ceil(Math.log(n) / Math.log(2.0));
		return (int)(2 * Math.pow(2, x) - 1);
	}
	
	public static int[] constructSegmentTree(int n)
	{
		return new int[getMaxSize(n)];
	}
	
	public static int constructSegmentTree(StringBuilder arr, int start, int end, int index)
	{
		lazyTree[index] = 0;
		
		if (start == end)
		{
			segmentTree[index] = arr.charAt(start) - '0';
			return segmentTree[index];
		}
		
		int mid = getMiddle(start, end);
		
		segmentTree[index] = constructSegmentTree(arr, start, mid, index * 2 + 1) +
								constructSegmentTree(arr, mid+1, end, index * 2 + 2);
		return segmentTree[index];
	}
	
	public static int getSum(int n, int start, int end)
	{
		if (start < 0 || end > n - 1 || start > end)
		{
			return 0;
		}
		
		return getSumUtil(0, n-1, start, end, 0);
	}
	
	public static int getSumUtil(int start, int end, int queryStart, int queryEnd, int index)
	{	
		if (end < queryStart || start > queryEnd)
		{
			return 0;
		}
		
		if (queryStart <= start && queryEnd >= end)
		{
			return segmentTree[index];
		}
		
		int mid = getMiddle(start, end);
		return getSumUtil(start, mid, queryStart, queryEnd, 2 * index + 1) +
				getSumUtil(mid + 1, end, queryStart, queryEnd, 2 * index + 2);
	}
	
	public static int updateRangeUtil(int start, int end, int fromIndex, int toIndex, char CMD, int currentIndex)
	{
		
		// not withing the range we just exit to not propogate further
		if (end < fromIndex || start > toIndex)
		{
			return segmentTree[currentIndex];
		}
		
		// leaf Node
		if (start == end)
		{
			switch(CMD)
			{
				case 'F':
					// mutate to 1
					segmentTree[currentIndex] = 1;
					break;
				case 'E':
					// mutate to 0
					segmentTree[currentIndex] = 0;
					break;
				case 'I':
					// inverse 
					segmentTree[currentIndex] = segmentTree[currentIndex] ^ 1;
					break;
			}
			return segmentTree[currentIndex];
		}
		
		int mid = getMiddle(start, end);
		
		segmentTree[currentIndex] = updateRangeUtil(start, mid, fromIndex, toIndex, CMD, 2 * currentIndex + 1) +
				updateRangeUtil(mid + 1, end, fromIndex, toIndex, CMD, 2 * currentIndex + 2);
		
		return segmentTree[currentIndex];
	}
}