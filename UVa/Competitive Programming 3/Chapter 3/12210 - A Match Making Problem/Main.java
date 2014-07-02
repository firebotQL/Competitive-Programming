import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int i, B, S, temp = 0, min;
		
		int caseNr = 1;

		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			B = Integer.valueOf(split[0]);
			S = Integer.valueOf(split[1]);
			
			if (B == 0 && S == 0)
			{
				break;
			}
			
			if (B <= S)
			{
				temp = B + S;
				
				while(temp-- != 0)
				{
					reader.readLine();
				}
				
				System.out.println("Case " + caseNr++ + ": " + 0);
				continue;
			}
			
			min = Integer.MAX_VALUE;
			
			for(i = 0; i < B; i++)
			{
				temp = Integer.valueOf(reader.readLine());	
				if (min > temp)
				{
					min = temp;
				}
			}
			
			for(i = 0; i < S; i++)
			{
				reader.readLine();
			}

			System.out.println("Case " + caseNr++ + ": " + (B-S) + " " + min);
		}
	}
}