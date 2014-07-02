import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] separatedLine = null;
		
		while((line = reader.readLine()) != null)
		{
			int n = Integer.valueOf(line);
			separatedLine = reader.readLine().split("\\s+");
			Integer[] box = new Integer[n];
			
			for(int i = 0; i < n; i++)
			{
				box[i] = Integer.valueOf(separatedLine[i]);
			}

			Arrays.sort(box);
			
			for(int i = 0; i < n; i++)
			{
				if ((i + 1) != n)
				{
					System.out.print(box[i] + " ");
				}
				else
				{
					System.out.print(box[i]);
				}
			}
			System.out.println();

		}
		
	}
}