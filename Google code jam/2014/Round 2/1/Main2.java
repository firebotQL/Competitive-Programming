import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main2
{
	private static final Pattern REGEX_PATTERN = Pattern.compile("(.)\\1*");
		
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		
		int cases = Integer.valueOf(reader.readLine());
		int N, j, z, min, max, result;
		
		String matching = null, newMatch = null, tmpLine;
		Set<String> set = new HashSet<String>();
		boolean noResult = false;
		
		for(int i = 1; i <= cases; i++)
		{
			N = Integer.valueOf(reader.readLine());
			set = new HashSet<String>();
			noResult = false;
			result = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			for(z = 0; z < N; z++)
			{
				line = reader.readLine();
				tmpLine = REGEX_PATTERN.matcher(line).replaceAll("$1");
				
				if (set.isEmpty())
				{
					set.add(tmpLine);
				}
				else if (!set.contains(tmpLine))
				{
					noResult = true;
					break;
				}
				
				min = Math.min(min, line.length());
				max = Math.max(max, line.length());
			}

			
			
			if (!noResult)
			{
				result = max - min;
			}
			
			if (noResult)
			{
				System.out.printf("Case #%d: Fegla Won%n", i);
			}
			else
			{
				System.out.printf("Case #%d: %d%n", i,  result);
			}
			
		}
	}
}