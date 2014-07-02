import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int policeStack, events, event, i, crimeStack, crime;
		while((line = reader.readLine()) != null)
		{
			events = Integer.valueOf(line);
			policeStack = 0;
			split = reader.readLine().split("\\s+");
			crimeStack = 0;
			crime = 0;
			
			for(i = 0; i < events; i++)
			{
				event = Integer.valueOf(split[i]);
				
				if (event > 0)
				{
					policeStack += event;
					crimeStack += crime;
					crime = 0;
				}
				else if (event < 0)
				{
					policeStack--;
					if (policeStack < 0)
					{
						crime++;
					}
				}
				
				if (policeStack < 0)
				{
					policeStack = 0;
				}
			}
			
			crimeStack += crime;
			
			System.out.println(crimeStack);
		}
	}
}