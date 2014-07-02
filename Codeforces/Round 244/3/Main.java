import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] table = new int[5001][5001];
	public static int[] idx = new int[5001];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line1 = null, line2 = null;
		int fl, sl, s, f, i, j, minLen;
		HashSet<String> set = new HashSet<String>();
		while((line1 = reader.readLine()) != null)
		{
			line2 = reader.readLine();
			minLen = Integer.MAX_VALUE;
			
			fl = line1.length();
			sl = line2.length();
			set = new HashSet<String>();
			
			for(s=0; s <= sl; s++)
			{
			  table[0][s] = 0;
			  idx[s] = -1;
			}
			
			for(f=0; f <= fl; f++)
			{
			  table[f][0] = 0;
			}
		 
		 
		 
		 
			for (i = 1; i <= fl; i++) {
				for (j = 1; j <= sl; j++) {
					if (line1.charAt(i-1) == line2.charAt(j-1)) {
						if (i == 1 || j == 1) {
							table[i][j] = 1;
							idx[i] = 1;
						}
						else {
							if (idx[i - 1] != -1)
							{
								idx[i] = idx[i - 1];
							}
							else
							{
								idx[i] = i;
							}
							table[i][j] = table[i - 1][j - 1] + 1;
						}
						if (table[i][j] < minLen) {
							String tmp = line1.substring(idx[i], i);
							if (set.contains(tmp))
							{
								minLen = Integer.MAX_VALUE;
							}
							else
							{
								set.add(tmp);
								minLen = table[i][j];
							}
							
						}
					}
				}
			}
			
			if (minLen == Integer.MAX_VALUE)
			{
				System.out.println(-1);
			}
			else
			{
				System.out.println(minLen);
			}
		}
	}
}