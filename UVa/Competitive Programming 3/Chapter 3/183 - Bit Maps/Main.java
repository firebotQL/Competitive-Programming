import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static char[][] array = null;
	public static char[] array2 = null;
	public static int r = 0, c = 0;
	public static int index = 0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null;
		String result = null;
		while((line = reader.readLine()) != null && line.charAt(0) != '#')
		{
			splitLine = line.split("\\s+");
			r = Integer.valueOf(splitLine[1]);
			c = Integer.valueOf(splitLine[2]);
			
			
			index = 0;
			result = "";

			int count = 0;
			
			switch (splitLine[0].charAt(0))
			{
				case 'B':
					if (r != 0 && c != 0)
					{
						line = reader.readLine();
						array = new char[r][c];
						for(int i = 0; i < r; i++)
						{
							for(int j = 0; j < c; j++)
							{
								int size = i*c+j;
								if (size == line.length())
								{
									line += reader.readLine();
								}
								array[i][j] = line.charAt(size);
							}
						}
						
						result = processFirst(0, 0, r, c);
					}
					
					System.out.printf("D%4d%4d\n", r, c);
					
					for(int i = 0; i < result.length(); i++)
					{
							if (count++ == 50) 
							{ 
								count = 1;
								System.out.println();
							}
							System.out.print(result.charAt(i));
					}
					System.out.println();
					
					break;
				case 'D':
					if (r != 0 && c != 0)
					{
						line = reader.readLine();
						array = new char[r][c];
						array2 = new char[line.length()];
						
						for(int i = 0; i < line.length(); i++)
						{
							array2[i] = line.charAt(i);
						}
						
						processSecond(0, 0, r, c);
					}
					
					System.out.printf("B%4d%4d\n", r, c);
					
					for(int i = 0; i < r; i++)
					{
						for(int j = 0; j < c; j++)
						{
							if (count++ == 50) 
							{ 
								count = 1;
								System.out.println();
							}
							System.out.print(array[i][j]);
						}
					}
					System.out.println();
			
					break;
			}
			
		}
	}
	
	public static String processFirst(int startR, int startC, int endR, int endC)
	{
		boolean zero = false;
		boolean one = false;
		
		if (startR == endR || startC == endC)
		{
			return "";
		}
		
		if (startR + 1 == endR && startC + 1 == endC)
		{
			return "" + array[startR][startC];
		}
		
		for(int i = startR; i < endR && (!zero || !one); i++)
		{
			for(int j = startC; j < endC && (!zero || !one); j++)
			{
				switch(array[i][j])
				{
					case '0':
						zero = true;
						break;
					case '1':
						one = true;
						break;
				}
			}
		}
		
		String result = "D";
		
		if (!zero && one)
		{
			return "1";
		}
		else if (zero && !one)
		{
			return "0";
		}
		
		int midR = (startR + endR + 1) / 2;
		int midC = (startC + endC + 1) / 2;

		result += processFirst(startR, startC, midR, midC) +	// top left 
				processFirst(startR, midC, midR, endC) + 	// top right
				processFirst(midR, startC, endR, midC) + // +	// bottom left
				processFirst(midR, midC, endR, endC);		// bottom right
		return result;
	}

	public static void processSecond(int startR, int startC, int endR, int endC)
	{
		if (startR == endR || startC == endC)
		{
			return;
		}
		
		if (startR + 1 == endR && startC + 1 == endC)
		{
			array[startR][startC] = array2[index++];
			return;
		}
		
		switch(array2[index])
		{
			case 'D':
				int midR = (startR + endR + 1) / 2;
				int midC = (startC + endC + 1) / 2;
				index++;
				processSecond(startR, startC, midR, midC); 	// top left
				processSecond(startR, midC, midR, endC); 		// top right
				processSecond(midR, startC, endR, midC);	 	// bottom left
				processSecond(midR, midC, endR, endC);		// bottom right
				// index??????
				break;
			default:
				for(int i = startR; i < endR; i++)
				{
					for(int j = startC; j < endC; j++)
					{
						array[i][j] = array2[index];
					}
				}
				index++;
				break;
		}
		return;
	}
}