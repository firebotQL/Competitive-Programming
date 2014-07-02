import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] height = new int[2000];
	public static int[] width = new int[2000];
	public static int[] lis_sum = new int[2000];
	public static int[] lds_sum = new int[2000];
	
	public static void solve(int n, int caseNr)
	{
		int i, j, max_i_w, max_d_w;
		max_i_w = max_d_w = lis_sum[0] = lds_sum[0] = width[0];
		
		for(i = 1; i < n; i++)
		{
			lis_sum[i] = lds_sum[i] = width[i];
			
			for(j = 0; j < i; j++)
			{
				if (height[i] > height[j])
				{
					lis_sum[i] = Math.max(lis_sum[i], lis_sum[j] + width[i]);
				}
				else if (height[i] < height[j])
				{
					lds_sum[i] = Math.max(lds_sum[i], lds_sum[j] + width[i]);
				}
			}
			
			max_i_w = Math.max(max_i_w, lis_sum[i]);
			max_d_w = Math.max(max_d_w, lds_sum[i]);
		}
		
		if (max_i_w >= max_d_w)
		{
			System.out.printf("Case %d. Increasing (%d). Decreasing (%d).%n", caseNr, max_i_w, max_d_w);
		}
		else
		{
			System.out.printf("Case %d. Decreasing (%d). Increasing (%d).%n", caseNr, max_d_w, max_i_w);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(reader.readLine());
		String[] splitHeight = null;
		String[] splitwidth = null;
		int i, caseNr, size;
		for(caseNr = 1; caseNr <= cases; caseNr++)
		{
			size = Integer.valueOf(reader.readLine());
			splitHeight = reader.readLine().split("\\s+");
			splitwidth = reader.readLine().split("\\s+");

			for(i = 0; i < size; i++)
			{
				height[i] = Integer.valueOf(splitHeight[i]);
				width[i] = Integer.valueOf(splitwidth[i]);
			}
			solve(size, caseNr);
		}
	}
}