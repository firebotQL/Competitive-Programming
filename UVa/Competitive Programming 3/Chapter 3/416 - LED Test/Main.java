import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static String[] led = { "YYYYYYN", "NYYNNNN", "YYNYYNY", "YYYYNNY", "NYYNNYY", "YNYYNYY", "YNYYYYY", "YYYNNNN", "YYYYYYY", "YYYYNYY" };
	public static boolean result = false;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] values = null;
		while((line = reader.readLine()) != null && line.charAt(0) != '0')
		{
			int N = Integer.valueOf(line.trim());
			values = new String[N];
			for(int i = 0; i < N; i++)
			{
				values[i] = reader.readLine().trim();
			}
			result = false;
			solve(values, 0, 0, 0);
			if (result)
			{
				System.out.println("MATCH");
			}
			else
			{
				System.out.println("MISMATCH");
			}
		}
	}
	
	public static void solve(String[] values, int currentIndex, int matchedLedIndex, int matchedCnt)
	{	
		for(int j = led.length-1; j >= 0 && !result; j--)
		{
			for(int i = 0; i < values.length && !result; i++)
			{
				boolean[] damagedLed = new boolean[7];
				if (initialMatchAndSetDamaged(values[i], led[j], damagedLed))
				{
					solve(values, i + 1, j - 1, matchedCnt + 1, damagedLed);
				}
			}
		}
	}
	
	public static void solve(String[] values, int currentIndex, int matchedLedIndex, int matchedCnt, boolean[] damagedLed)
	{
		if (matchedCnt == values.length)	// might be we want to check for matchedLedIndex
		{
			result = true;
			return;
		}
		
		if (currentIndex < values.length && matchedLedIndex >= 0)
		{
			if (!checkIsStillDamaged(values[currentIndex], damagedLed))
			{
				return;
			}
			
			if (initialMatchAndSetDamaged(values[currentIndex], led[matchedLedIndex], damagedLed))
			{
				solve(values, currentIndex + 1, matchedLedIndex - 1, matchedCnt + 1, damagedLed);
			}
		}
	}
	
	public static boolean checkIsStillDamaged(String currentLed, boolean[] damagedLed)
	{
		boolean result = true;
		
		for(int i = 0; i < 7 && result; i++)
		{
			if (damagedLed[i] && currentLed.charAt(i) == 'Y')
			{
				result = false;
			}
			
		}
		
		return result;
	}
	
	public static boolean initialMatchAndSetDamaged(String currentLed, String standardLed, boolean[] damagedLed)
	{
		boolean match = true;
		
		for(int i = 0; i < 7 && match; i++)
		{
			match = match && matchSegmentAndSetSegmentState(currentLed, standardLed, i, damagedLed);
		}

		return match;
	}
	
	public static boolean matchSegmentAndSetSegmentState(String currentLed, String standardLed, int index, boolean[] damagedLed)
	{
		char a = currentLed.charAt(index);
		char a2 = standardLed.charAt(index);
		
		if (a != a2)
		{
			if (a != 'N')
			{
				return false;
			}
			else
			{
				damagedLed[index] = true;
			}
		}
		return true;
	}
}