import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int[] dragons = new int[20000];
	public static int[] knights = new int[20000];
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int n, m, i, d, k;
		long sum, size;
		
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			n = Integer.valueOf(split[0]);
			m = Integer.valueOf(split[1]);
			
			if (n == 0 && m == 0)
			{
				break;
			}
			
			for(i = 0; i < n; i++)
			{
				dragons[i] = Integer.valueOf(reader.readLine());
			}

			for(i = 0; i < m; i++)
			{
				knights[i] = Integer.valueOf(reader.readLine());
			}
			
			if (n > m)
			{
				System.out.println("Loowater is doomed!");
				continue;
			}
			
			Arrays.sort(dragons, 0, n);
			Arrays.sort(knights, 0, m);
			
			d = 0;
			k = 0;
			sum = 0;
			
			while(d < n && k < m)
			{
			
				if (dragons[d] <= knights[k])
				{
					sum += knights[k];
					d++;
				}
				k++;
			}
			
			if (d == n)
			{
				System.out.println(sum);
			}
			else
			{
				System.out.println("Loowater is doomed!");
			}
		}
	}
}
