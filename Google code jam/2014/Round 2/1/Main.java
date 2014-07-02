import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main
{
	public static int[][] counter = new int[101][101];
	private static final Pattern REGEX_PATTERN = Pattern.compile("(.)\\1*");
		
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		
		int cases = Integer.valueOf(reader.readLine());
		int N, j, z, min, max, result, g, maxG;
		
		String matching = null, newMatch = null, tmpLine;
		Set<String> set = new HashSet<String>();
		boolean noResult = false;
		
		for(int i = 1; i <= cases; i++)
		{
			N = Integer.valueOf(reader.readLine());
			set = new HashSet<String>();
			noResult = false;
			maxG = Integer.MIN_VALUE;
			
			for(z = 0; z < N; z++)
			{
				line = reader.readLine();
				if (!noResult)
				{
						
					tmpLine = REGEX_PATTERN.matcher(line).replaceAll("$1");
					
					
					//System.out.println(line.length());
					
					if (set.isEmpty())
					{
						set.add(tmpLine);
					}
					else if (!set.contains(tmpLine))
					{
						noResult = true;
						continue;
					}
					
					char prev = line.charAt(0);
					g = 0;
					
					for(j = 0 ; j < line.length(); j++)
					{
						char retCh = line.charAt(j);
						if (prev != retCh)
						{
							prev = retCh;
							g++;
						}
						counter[z][g]++;
					}
					maxG = Math.max(maxG, g);
				}
			}
			for(String el : set)
			{
			//	System.out.println(el.length());
			}
			result = 0;
			
			if (!noResult)
			{
				for(z = 0; z <= maxG; z++)
				{
					min = Integer.MAX_VALUE;
					max = Integer.MIN_VALUE;
					for(j = 0; j < N; j++)
					{
						min = Math.min(min, counter[j][z]);
						max = Math.max(max, counter[j][z]);
					}
					
					if (min != max)
					{
						//System.out.println((char)j + " - min: " + min + " max: " + max);
						if (min == 0 || max == 0)
						{
							result = -1;
							j = 128;
							break;
						}
						result += max - min;
					}
				}
			}
			
			if (result == -1 || noResult)
			{
				System.out.printf("Case #%d: Fegla Won%n", i);
			}
			else
			{
				System.out.printf("Case #%d: %d%n", i,  result);
			}
			
			for(z = 0; z < 101; z++)
			{
				for(j = 0; j < 101; j++)
				{
						counter[z][j]= 0;
				}
			}
		}
	}
}