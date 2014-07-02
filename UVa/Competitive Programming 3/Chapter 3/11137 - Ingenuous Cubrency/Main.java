import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] cubes = new int[21];
	public static long[][] memo = new long[21][10001];
	
	public static long ways(int type, int value)
	{
		if (value == 0) return 1;
		if (value < 0 || type == 21) return 0;
		if (memo[type][value] != -1) return memo[type][value];
		return memo[type][value] = ways(type + 1, value) + ways(type, value - cubes[type]);
	}
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int value;
		
		for(int i = 1; i <= 21; i++)
		{
			cubes[i-1] = (int)Math.pow(i, 3);
		}
		
		
		for(long[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		
		ways(0, 10000);
		
		while(scan.hasNextInt())
		{
			value = scan.nextInt();
			System.out.println(ways(0, value));
		}
	}
}