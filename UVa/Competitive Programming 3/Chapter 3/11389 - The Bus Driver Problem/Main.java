import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n, d, r, i, overtime, overtimeSum;
		String line = null;
		String[] separatedLine = null;
		int[] mornings = null;
		int[] afternoons = null;
		while((line = reader.readLine()) != null)
		{
			overtimeSum = 0;
			separatedLine = line.split("\\s+");
			n = Integer.valueOf(separatedLine[0]);
			d = Integer.valueOf(separatedLine[1]);
			r = Integer.valueOf(separatedLine[2]);
			if (n == 0 && n == d && d == r)
			{
				break;
			}
			mornings = new int[n];
			afternoons = new int[n];
			
			separatedLine = reader.readLine().split("\\s+");
			for(i = 0; i < n; i++)
			{
				mornings[i] = Integer.valueOf(separatedLine[i]);
			}
			
			separatedLine = reader.readLine().split("\\s+");
			
			for(i = 0; i < n; i++)
			{
				afternoons[i] = Integer.valueOf(separatedLine[i]);
			}
			
			Arrays.sort(mornings);
			Arrays.sort(afternoons);
			
			for(i = 0; i < n; i++)
			{
				overtime = (mornings[i] + afternoons[n-1-i]) - d;
				if (overtime > 0)
				{
					overtimeSum += overtime;
				}
			}
			
			System.out.println(overtimeSum * r);
		}
	}
}