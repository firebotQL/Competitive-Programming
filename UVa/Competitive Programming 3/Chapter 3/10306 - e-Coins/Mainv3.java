import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static int[] pairs = new int[40];
	public static long[] table = new long[90601];
	
	public static int sqr(int coin, int eCoin)
	{
		return (int)(Math.pow(coin + coin, 2) + Math.pow(eCoin + eCoin, 2));
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int n, m = 0, S, i, j, sqr, sqrS;
		long x, y;
		
		// Fill the enteries for 0 value case (n = 0)
	    
		while(scanner.hasNext())
		{
			n = scanner.nextInt();
			while(n-- != 0)
			{
				Arrays.fill(table, 0);
		
				table[0] = 1;
				
				m = scanner.nextInt();
				S = scanner.nextInt();
				
				for(i = 0; i < m; i++)
				{
					pairs[i] = sqr(scanner.nextInt(), scanner.nextInt());
				}
				
				sqrS = S * S;
				
				for(i = 0; i < m; i++)
				{
					for(j = pairs[i]; j <= sqrS; j++)
					{
						table[j] += table[j - pairs[i]];
					}
				}
				
				System.out.println(table[sqrS]);
			}
		}
	}
}