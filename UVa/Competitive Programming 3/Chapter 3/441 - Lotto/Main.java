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
		int a,b,c,d,e,f, size;
		boolean nonFirst = false;
		while((line = reader.readLine()) != null && line.charAt(0) != '0')
		{
			if (nonFirst)
			{
				System.out.println();
			}
			nonFirst = true;
			separatedLine = line.split("\\s+");
			size = Integer.valueOf(separatedLine[0]);
			for(a = 1; a <= size; a++)
			{
				for(b = a + 1; b <= size; b++)
				{
					for(c = b + 1; c <= size; c++)
					{
						for(d = c + 1; d <= size; d++)
						{
							for(e = d + 1; e <= size; e++)
							{
								for(f = e + 1; f <= size; f++)
								{
									System.out.println(separatedLine[a] + " " + separatedLine[b] + " " +
														separatedLine[c] + " " + separatedLine[d] + " " +
														separatedLine[e] + " " + separatedLine[f]);
								}
							}
						}
					}
				}
			}
		}
	}
}