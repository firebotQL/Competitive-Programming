import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		long totalCount;
		int i, j, z;
		long foundA, foundB, foundC;
		Set<String> set;
		while((line = reader.readLine()) != null)
		{
			totalCount = 0;
			set = new HashSet<String>();
			
			for(i = 0; i < line.length(); i++)
			{
				for(j = 3; j < line.length() - i; j += 2)
				{
					foundA = foundB = foundC = 0;
					
					for(z = i; z < j + i; z++)
					{
						switch (line.charAt(z))
						{
							case 'A':
								foundA++;
								break;
							case 'B':
								foundB++;
								break;
							case 'C':
								foundC++;
								break;
						}
					}
					
					if (foundA == foundB && foundB== foundC)
					{
						//set.add(line.substring(i, i + j))
							totalCount++;
					}
				}
			}
		
			System.out.println(totalCount);
		}
	}
}