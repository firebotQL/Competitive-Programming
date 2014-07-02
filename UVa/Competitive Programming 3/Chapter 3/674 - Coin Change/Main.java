import java.util.*;
import java.io.*;

public class Main
{
	private static int N = 5;
	private static int[] coinValues = new int[] { 1, 5, 10, 25, 50 };
	private static int[][] memo = new int[5][7500];
	
	private static int ways(int type, int value)
	{
		if (value == 0) return 1;		
		if (value < 0 || type == N) return 0;	
		if (memo[type][value] != -1) return memo[type][value];	
		return memo[type][value] = ways(type + 1, value) + ways(type, value - coinValues[type]);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		for(int[] row : memo)
		{
				Arrays.fill(row, -1);
		}
		
		while((line = reader.readLine()) != null)
		{
			System.out.println(ways(0, Integer.parseInt(line)));
		}
		reader.close();
	}
}