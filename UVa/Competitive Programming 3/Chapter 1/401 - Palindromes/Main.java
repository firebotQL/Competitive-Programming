import java.io.*;
import java.lang.*;
import java.util.*;

class Main
{
	public static Map<Character, Character> reverseMap;
	
	static {
		reverseMap = new HashMap<Character, Character>();
		reverseMap.put('A', 'A');
		reverseMap.put('E', '3');
		reverseMap.put('H', 'H');
		reverseMap.put('I', 'I');
		reverseMap.put('J', 'L');
		reverseMap.put('L', 'J');
		reverseMap.put('M', 'M');
		reverseMap.put('O', 'O');
		reverseMap.put('S', '2');
		reverseMap.put('T', 'T');
		reverseMap.put('U', 'U');
		reverseMap.put('V', 'V');
		reverseMap.put('W', 'W');		
		reverseMap.put('X', 'X');
		reverseMap.put('Y', 'Y');
		reverseMap.put('Z', '5');
		reverseMap.put('1', '1');
		reverseMap.put('2', 'S');
		reverseMap.put('3', 'E');
		reverseMap.put('5', 'Z');
		reverseMap.put('8', '8');
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int mirrored, palindrome, lineHalfLength;
		while((line = reader.readLine()) != null)
		{
			mirrored = 0; palindrome = 0;
			lineHalfLength = line.length()/2;
			
			for(int i = 0; i < lineHalfLength; i++)
			{
				char aChar = line.charAt(i);
				char bChar = line.charAt(line.length()-1-i);
				Character mirroredPoint = reverseMap.get(aChar);
				//System.out.println(aChar + " " + bChar);
				
	
				if (mirroredPoint != null && mirroredPoint.compareTo(bChar) == 0)
				{
					mirrored++;
				}
				
				if (aChar == bChar)
				{	
					palindrome++;
				}
			}

			//System.out.println(mirrored + " " + palindrome);
			if (lineHalfLength == 0)
			{
				if (!reverseMap.containsKey(line.charAt(0)))
				{
					System.out.println(line + " -- is a regular palindrome.");
				}
				else
				{
					System.out.println(line + " -- is a mirrored palindrome.");
				}
			}
			else	if (mirrored == lineHalfLength && palindrome == lineHalfLength)
			{
				System.out.println(line + " -- is a mirrored palindrome.");
			}
			else if (mirrored == lineHalfLength)
			{
				System.out.println(line + " -- is a mirrored string.");
			}
			else if (palindrome == lineHalfLength)
			{
				System.out.println(line + " -- is a regular palindrome.");
			}
			else
			{
				System.out.println(line + " -- is not a palindrome.");
			}
			
			System.out.println();
		}
	}
	
	
}