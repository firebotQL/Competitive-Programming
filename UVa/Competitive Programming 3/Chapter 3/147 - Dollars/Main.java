import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	private static int denomCnt = 11;
	private static int[] denom = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };
	private static long[][] memo = new long[11][30001];
	
	private static long ways(int type, int value)
	{
		if (value == 0) 
		{
			return 1;
		}
		
		if (value < 0 || type == denomCnt)
		{
			return 0;
		}
		
		if (memo[type][value] != -1) 
		{
			return memo[type][value];
		}
		
		return memo[type][value] = ways(type + 1, value) + ways(type, value - denom[type]);
		
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		float value = 0;
		int intValue = 0;
		
		for(long[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		
		while(scan.hasNext())
		{
			value = scan.nextFloat();
			intValue = Math.round(value * 100);
			
			if (intValue == 0)
			{
				break;
			}
			
			System.out.printf("%6.2f%17d%n", value ,ways(0, intValue));
		}
	}
}