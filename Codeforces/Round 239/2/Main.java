import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] table = new int[123];
	public static int[] table2 = new int[123];
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int result, i, t1, t2;
		char temp;
		while((line = reader.readLine()) != null)
		{
			table = new int[123];
			table2 = new int[123];
			
			for(i = 0; i < line.length(); i++)
			{
				table[line.charAt(i)]++;
			}
			
			line = reader.readLine();
			
			result = 0;
			
			for(i = 0; i < line.length(); i++)
			{
				temp = line.charAt(i);
				if (table[temp] == 0)
				{
					result = -1;
					break;
				}
				table2[temp]++;
			}
			
			if (result != -1)
			{
				for(i = 0; i < 123; i++)
				{
					t1 = table[i];
					t2 = table2[i];
					
					if (t1 >= t2)
					{
						result += t2;
					}
					else
					{
						result += t1;
					}
				}
			}
			
			System.out.println(result);
			
		}
	}
}