import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] Barray = new int[10000];
	public static int[] Sarray = new int[10000];
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int B, S, bachelor, spinster, minDifference, difference;
		
		AgeComparator comp = new AgeComparator();
		int caseNr = 1;
		Pair leftSpinster = null;
		Pair rightSpinster = null;
		
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			B = Integer.valueOf(split[0]);
			S = Integer.valueOf(split[1]);
			
			if (B <= S)
			{
				System.out.println("Case " + caseNr + ": " + 0);
			}
			
			for(i = 0; i < B; i++)
			{
				Barray[i] = Integer.valueOf(reader.readLine());
			}
			
			for(i = 0; i < S; i++)
			{
				Sarray[i] = Integer.valueOf(reader.readLine());
			}
			
			Arrays.sort(Barray, 0, B);
			Arrays.sort(Sarray, 0, S);
			
			for(i = B - 1; i >= 0; i--)
			{
				bachelor = Barray[i];
				minDifference = Integer.MAX_VALUE;
				
				for (j = S - 1; j >= 0; j--)
				{
					spinster = Sarray[j];
					difference = Math.abs(bachelor - spinster);
					
					if (difference < minDifference)
					{
						minDifference = difference;
					}
					else
					{
						break;
					}
				}
				
			}
			
			System.out.print("Case " + caseNr + ": " + array.size() + " " + array.get(i));
		}
	}
}