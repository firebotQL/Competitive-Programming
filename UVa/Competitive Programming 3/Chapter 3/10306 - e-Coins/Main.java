import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static List<Integer> eCoins = new ArrayList<Integer>();
	public static int[][] memo = new int[41][90001];
	
	public static int ways(int value)
	{
		if (value == 0) return 0;
		if (value < 0) return 
	}
	
	public static int sqr(int value1, int value2)
	{
		return (value1+value1) * (value1+value1) + (value2+value2) * (value2 + value2);
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int n, m, ways, S, i, j, sqr, sqrS;
		long x, y;
		
		// Fill the enteries for 0 value case (n = 0)
	    
		while(scanner.hasNext())
		{
			n = scanner.nextInt();
			while(n-- != 0)
			{
				eCoins.clear();
				for(int[] row : memo)
				{
					Arrays.fill(row, -1);
				}
				
				m = scanner.nextInt();
				S = scanner.nextInt();
				
				for(i = 0; i < m; i++)
				{
					eCoins.add(sqr(scanner.nextInt(), scanner.nextInt()));
				}
				
				sqrS = S * S;
				ways = ways(0, sqrS);
				
				if (ways != -1)
				{
					System.out.println(ways);
				}
				else
				{
					System.out.println("not possible");
				}
			}
		}
	}
}