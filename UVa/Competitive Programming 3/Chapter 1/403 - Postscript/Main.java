import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static char[][] grid = new char[60][60];
	public static Map<Character, ArrayList<String>> c1Font = new HashMap<Character, ArrayList<String>>();
	public static Map<Character, ArrayList<String>> c5Font = new HashMap<Character, ArrayList<String>>();
	
	
	public static void initialize()
	{
		fillGrid();
	}
	
	public static void fillGrid()
	{
		for(int i = 0; i < 60; i++)
		{
			for(int j = 0; j < 60; j++)
			{
				grid[i][j] = '.';
			}
		}
	}
	
	public static void fillFonts()
	{
		String firstFont = "ABCDEFGHIJKLMNOPQRSTUVWXYZ .*";
		for(int i = 0 ; i < firstFont.length(); i++)
		{
			char cchar = firstFont.charAt(i);
			ArrayList<String> printableFont = new ArrayList<String>();
			String string = "";
			string += cchar;
			printableFont.add(string);
			
			c1Font.put(cchar, printableFont);
		}
		
		String fifthFont = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
		
		String[][] c5Chars = {{ ".***..", "*...*.", "*****.", "*...*.", "*...*." },
								   { "****..", "*...*.", "****..", "*...*.", "****.." },
								   { ".****.", "*...*.", "*.....", "*.....", ".****." },
								   { "****..", "*...*.", "*...*.", "*...*.", "****.." },
								   { "*****.", "*.....", "***...", "*.....", "*****." },
								   { "*****.", "*.....", "***...", "*.....", "*....." },
								   { ".****.", "*.....", "*..**.", "*...*.", ".***.." },
								   { "*...*.", "*...*.", "*****.", "*...*.", "*...*." },
								   { "*****.", "..*...", "..*...", "..*...", "*****." },
								   { "..***.", "...*..", "...*..", "*..*..", ".**..." },
								   { "*...*.", "*..*..", "***...", "*..*..", "*...*." },
								   { "*.....", "*.....", "*.....", "*.....", "*****." },
								   { "*...*.", "**.**.", "*.*.*.", "*...*.", "*...*." },
								   { "*...*.", "**..*.", "*.*.*.", "*..**.", "*...*." },
								   { ".***..", "*...*.", "*...*.", "*...*.", ".***.." },
								   { "****..", "*...*.", "****..", "*.....", "*....." },
								   { ".***..", "*...*.", "*...*.", "*..**.", ".****." },
								   { "****..", "*...*.", "****..", "*..*..", "*...*." },
								   { ".****.", "*.....", ".***..", "....*.", "****.." },
								   { "*****.", "*.*.*.", "..*...", "..*...", ".***.." },
								   { "*...*.", "*...*.", "*...*.", "*...*.", ".***.." },
								   { "*...*.", "*...*.", ".*.*..", ".*.*..", "..*..." },
								   { "*...*.", "*...*.", "*.*.*.", "**.**.", "*...*." },
								   { "*...*.", ".*.*..", "..*...", ".*.*..", "*...*." },
								   { "*...*.", ".*.*..", "..*...", "..*...", "..*..." },
								   { "*****.", "...*..", "..*...", ".*....", "*****." },
								   { "......", "......", "......", "......", "......" }
								 };
		
		
		for(int i = 0; i < fifthFont.length(); i++)
		{
			char cchar = fifthFont.charAt(i);
			ArrayList<String> printableFont = new ArrayList<String>();
			
			for(int j = 0; j < 5; j++)
			{
				
				printableFont.add(c5Chars[i][j]);
			}
			
			c5Font.put(cchar, printableFont);
		}
		
		
	}
	
	public static void printGrid()
	{
		for(int i = 0; i < 60; i++)
		{
			for(int j = 0; j < 60; j++)
			{
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
				
		for(int i = 0; i < 60; i++)
		{
			System.out.print('-');
		}
		
		System.out.println();
		System.out.println();
	}
	
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splittedLine = null;
		String[] splittedText = null;
		initialize();
		fillFonts();		
		int R = 0;
		int C = 0;
		char cmd;
		Map<Character, ArrayList<String>> usedFonts = null;
		
		while((line = reader.readLine()) != null)
		{			
			splittedLine = line.split("\\s+");
			splittedText = line.split("\\|+");
			if (splittedLine[0].equals(".EOP"))
			{
				printGrid();
				initialize();
				continue;
			}
			char size = splittedLine[1].charAt(1);
			switch(size)
			{
				case '1':
					usedFonts = c1Font;
					break;
				case '5':
					usedFonts = c5Font;
					break;
			}
			
			R = Integer.valueOf(splittedLine[2]) - 1;
			
			cmd = splittedLine[0].charAt(1);
			
			String text = splittedText[1];
			
			switch(cmd)
			{
				case 'P':
					C = Integer.valueOf(splittedLine[3]) - 1;
					break;
				case 'L':
					C = 0;	
					break;
				case 'R':
					C = 59;
					break;
				case 'C':
					C = 29;
					break;
			}
			
			//System.out.println(text);
			printString(usedFonts, text, R, C, cmd, size - 48);
		}
		
	}
	
	public static void printString(Map<Character, ArrayList<String>> usedFonts, String text, int R, int C, char cmd, int step)
	{
		int initialR = R;
		int initialC = C;
		switch(cmd)
		{
			case 'P':
			case 'L':			
				for(int i = 0; i < text.length(); i++)
				{
					initialR = R;
					
					char letter = text.charAt(i);
					//System.out.println(usedFonts);
					ArrayList<String> stringArray = usedFonts.get(letter);
					
					for (int j = 0; j < stringArray.size(); j++)
					{
						String string = stringArray.get(j);
						
						step = string.length();
						
						for(int z = 0; z < string.length(); z++)
						{
							char textChar = string.charAt(z);
							int indexX = initialR + j;
							int indexY = initialC + z;
							if (indexX >= 60 || indexY >= 60 || textChar == '.' || textChar == ' ') 
							{
								continue;
							}
							
							grid[indexX][indexY] = textChar;
						}
					}
					initialC += step ;
				}
				break;
			case 'R':
				for(int i = text.length() - 1; i >= 0 ; i--)
				{
					initialR = R;
					
					char letter = text.charAt(i);
					//System.out.println(usedFonts);
					ArrayList<String> stringArray = usedFonts.get(letter);
					
					for (int j = 0; j < stringArray.size(); j++)
					{
						String string = stringArray.get(j);
						step = string.length();
						for(int z = string.length()-1; z >= 0 ; z--)
						{
							char textChar = string.charAt(z);
							int indexX = initialR + j;
							int indexY = initialC - ((string.length()-1) - z);
							if (indexX >= 60 || indexY < 0 || textChar == '.' || textChar == ' ') 
							{
								continue;
							}
							
							grid[indexX][indexY] = textChar;
						}
					}
					initialC -= step;	
				}
				break;
			case 'C':
			
				int offset = text.length() % 2;
				
				if (offset != 0)
				{
					C += (step+1)/2;
				}
				
				int initialCLeft = C;
				int initialCRight = C + 1;
				
				int mid = text.length()/2 - 1 + offset;
				
				//System.out.println(mid);
				
				for(int i = mid; i >= 0; i--)
				{
					//System.out.println(i + " " + j);
					initialR = R;
					
					char lletter = text.charAt(i);
					
					//System.out.println(usedFonts);
					ArrayList<String> stringArray = usedFonts.get(lletter);
					
					for (int j = 0; j < stringArray.size(); j++)
					{
						String string = stringArray.get(j);
						
						step = string.length();
						
						for(int z = string.length()-1; z >= 0 ; z--)
						{
							char textChar = string.charAt(z);
							int indexX = initialR + j;
							int indexY = initialCLeft - ((string.length()-1) - z);
							if (indexX >= 60 || indexY < 0 || textChar == '.' || textChar == ' ') 
							{
								continue;
							}
							
							grid[indexX][indexY] = textChar;
						}
					}
					
					
					
					initialCLeft -= step;	
					
				}
				
				for(int x = mid + 1; x < text.length() ; x++)
				{
					//System.out.println(i + " " + j);
					initialR = R;
					char rletter = text.charAt(x);
					
					ArrayList<String> stringArray = usedFonts.get(rletter);
						
					for (int j = 0; j < stringArray.size(); j++)
					{
						String string = stringArray.get(j);
						
						step = string.length();
						
						for(int z = 0; z < string.length(); z++)
						{
							char textChar = string.charAt(z);
							int indexX = initialR + j;
							int indexY = initialCRight + z;
							if (indexX >= 60 || indexY >= 60 || textChar == '.' || textChar == ' ') 
							{
								continue;
							}
							
							grid[indexX][indexY] = textChar;
						}
					}
					initialCRight += step;
				}
				
				break;
		}
	}
}