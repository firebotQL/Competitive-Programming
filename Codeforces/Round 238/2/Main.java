import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line = reader.readLine()) != null)
		{	
			line = reader.readLine();
			
			int count = 0;
			int rightFallIndex = -1;
			int leftIndex
			for(int i = 0; i < line.length(); i++)
			{
				switch(line.charAt(i))
				{
					case 'L':
						if (rightFallIndex == -1)
						{
							count -= i;
						}
						else
						{
							int standing = (i - rightFallIndex - 1) % 2;
							rightFallIndex = -1;
							count += standing;
						}
						break;
					case 'R':
						if(rightFallIndex == -1)
						{
							rightFallIndex = i;
						}
						break;
					case '.':
						if (rightFallIndex == -1)
						{
							count++;
						}
						break;
				}
			}
			System.out.println(count);

		}
		
	}
}