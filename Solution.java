import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		Set<Character> set = new HashSet<Character>();
		
		while((line = reader.readLine()) != null)
		{
			int[] map = new int[256];
			
			int cnt = Integer.parseInt(line);
			
			for(int i = 1; i <= cnt; ++i)
			{				
				String rock = reader.readLine();
				
				for(int j = 0; j < rock.length(); ++j)
				{
					char ch = rock.charAt(j);					
					if (set.add(ch))
					{
						map[ch] += 1;
					}
				}
				set.clear();
			}
			
			int result = 0;
			for(int i = 0; i < 256; i++)
			{
				if (map[i] == cnt)
				{
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
