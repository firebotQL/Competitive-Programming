import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int s, d, surplus;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null;
		int[] monthly = new int[12];
		while((line = reader.readLine()) != null)
		{
			splitLine = line.split("\\s+");
			s = Integer.valueOf(splitLine[0]);
			d = Integer.valueOf(splitLine[1]) * -1;
			
			surplus = Integer.MIN_VALUE;
			getResult(s, 1, monthly, 0);
			//getResult(d, 1, monthly, 0);
			
			if (surplus > 0)
			{
				System.out.println(surplus);
			}
			else
			{
				System.out.println("Deficit");
			}
		}
	}
	
	public static void getResult(int profit, int month, int[] monthly, int result)
	{
		if (month == 13)
		{
			if (surplus < result)
			{
				surplus = result;
			}
			return;
		}
		
		int fiveMonthResult = 0;
		
		monthly[month-1] = profit;
		
		if (month >= 5)
		{
			for(int i = month - 5; i < month; i++)
			{
				fiveMonthResult += monthly[i];
			}
			
			if (fiveMonthResult > 0)
			{
				return;
			}
		}
		
		getResult(s, month + 1, monthly, result + s);
		getResult(d, month + 1, monthly, result + d);
	}
}