import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int N, tracksCount, track;
	public static String[] separatedLine = null;
	public static int resultSum;
	public static String resultIndexes;
	
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		
		while((line = reader.readLine()) != null)
		{
			separatedLine = line.split("\\s+");
			N = Integer.valueOf(separatedLine[0]);
			tracksCount = Integer.valueOf(separatedLine[1]);
			resultSum = 0;
			sum(0, 0, "");
			System.out.println(resultIndexes.substring(1, resultIndexes.length()) + " sum:" + resultSum);
		}
	}
	
	public static boolean sum(int currentIndex, int sum, String indexes)
	{
		if (sum < N)
		{
			for(int i = currentIndex; i < tracksCount; i++)
			{
				if (sum(i + 1, sum + Integer.valueOf(separatedLine[i + 2]), indexes + " " + separatedLine[i + 2]))
				{
					if (sum > resultSum)
					{
						resultSum = sum;
						resultIndexes = indexes;
					}
				}
			}
			
			if (sum > resultSum)
			{
				resultSum = sum;
				resultIndexes = indexes;
			}
			return false;
			
		}
		else if (sum == N)
		{
			if (sum > resultSum)
			{
				resultSum = sum;
				resultIndexes = indexes;
			}
		}
		
		return true;

	}
}