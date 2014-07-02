import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static int[] pairs = new int[40];
	public static long[][] table = new long[90601][40];
	
	public static int sqr(int coin, int eCoin)
	{
		return (int)coin * coin + eCoin * eCoin;
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int n, m = 0, S, i, j, sqr, sqrS;
		long x, y;
		
		// Fill the enteries for 0 value case (n = 0)
		for(i = 0; i < m; i++)
		{
			table[0][i] = 1;
		}
	    
		while(scanner.hasNext())
		{
			n = scanner.nextInt();
			while(n-- != 0)
			{
				m = scanner.nextInt();
				S = scanner.nextInt();
				
				for(i = 0; i < m; i++)
				{
					pairs[i] = sqr(scanner.nextInt(), scanner.nextInt());
				}
				
				sqrS = S * S;
				
				for(i = 1; i < sqrS + 1; i++)
				{
					for(j = 0; j < m; j++)
					{
						sqr = pairs[j];
						x = (i - sqr >= 0) ? table[i - sqr][j] : 0;
						
						y = (j >= 1) ? table[i][j - 1] : 0;
						
						table[i][j] = x + y;
					}
				}
				
				System.out.println(table[sqrS][m-1]);
			}
		}
	}
}