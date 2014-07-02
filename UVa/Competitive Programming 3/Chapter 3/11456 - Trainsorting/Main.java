import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] cars = new int[2001];
	public static int[] lis = new int[2001];
	public static int[] lds = new int[2001];
	
	public static int solution(int n)
	{
		Arrays.fill(lis, 0, n+1, 1);
		Arrays.fill(lds, 0, n+1, 1);
		
		int i, j, max = 0;
		
		for(i = n-1; i >= 0; i--)
		{
			for(j = i+1; j < n; j++)
			{
				if (cars[i] < cars[j] && lis[i] < lis[j] + 1)
				{
					lis[i] = lis[j] + 1;
				}
				
				if (cars[i] > cars[j] && lds[i] < lds[j] + 1)
				{
					lds[i] = lds[j] + 1;
				}
			}
		}

		for(i = 0; i < n; i++)
		{
			max = Math.max(max, lis[i] + lds[i] - 1);
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int cases = scanner.nextInt();
		int i, n;
		while(cases-- != 0)
		{
			n = scanner.nextInt();
			
			for(i = 0; i < n; i++)
			{
				cars[i] = scanner.nextInt();
			}
			
			System.out.println(solution(n));
		}
		
	}
}
