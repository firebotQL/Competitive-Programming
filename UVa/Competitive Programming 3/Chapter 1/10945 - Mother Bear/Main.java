import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		boolean isPalindrome = false;
		while((line = reader.readLine()) != null && !line.equals("DONE"))
		{
			isPalindrome = true;
			line = line.replaceAll("[\\.\\,\\!\\?\\s++]", "");
			line = line.toLowerCase();
			for(int i = 0; i < line.length()/2; i++)
			{
				if (line.charAt(i) != line.charAt(line.length()-1-i))
				{
					isPalindrome = false;
					break;
				}
			}
			
			if (isPalindrome)
			{
				System.out.println("You won't be eaten!");
			}
			else
			{
				System.out.println("Uh oh..");
			}
		}
	}
}