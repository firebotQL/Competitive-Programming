import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String decision = null;
		int L, i;
		String pointingDirection = "+x";
		while((line = reader.readLine()) != null && (L = Integer.valueOf(line)) != 0)
		{
			pointingDirection = "+x";
			String[] decisions = reader.readLine().split("\\s+");
			//System.out.println(decisions[0]);
			for(i = 0; i < decisions.length; i++)
			{
				
				if (decisions[i].equals("No"))
				{
					continue;
				}
				
				if (pointingDirection.equals("+x"))
				{
					pointingDirection = decisions[i];
				}
				else if (pointingDirection.equals("-x"))
				{
					 String invertedSymbol = decisions[i].charAt(0) == '-' ? "+" : "-";
					 pointingDirection = invertedSymbol + decisions[i].charAt(1);
				}
				else if (pointingDirection.equals("+y"))
				{
					if (decisions[i].equals("+y")) 
					{
						pointingDirection = "-x";
					}
					else if (decisions[i].equals("-y"))
					{
						pointingDirection = "+x";
					}
				}
				else if (pointingDirection.equals("-y"))
				{
					if (decisions[i].equals("+y")) 
					{
						pointingDirection = "+x";
					}
					else if (decisions[i].equals("-y"))
					{
						pointingDirection = "-x";
					}
				}
				else if (pointingDirection.equals("+z"))
				{
					if (decisions[i].equals("+z")) 
					{
						pointingDirection = "-x";
					}
					else if (decisions[i].equals("-z"))
					{
						pointingDirection = "+x";
					}
				}
				else if (pointingDirection.equals("-z"))
				{
					if (decisions[i].equals("+z")) 
					{
						pointingDirection = "+x";
					}
					else if (decisions[i].equals("-z"))
					{
						pointingDirection = "-x";
					}
				}
			}
			System.out.println(pointingDirection);
			
		}
	}
}