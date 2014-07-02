import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.concurrent.*;

public class Main
{
	public static int mapSizeConst = 18000;
	public static int[] mapOfPoints = new int[mapSizeConst + 1];
	public static int minStart = Integer.MAX_VALUE;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int sig;
		int count = 0;
		while(scanner.hasNextInt())
		{
			sig = scanner.nextInt();
			if (sig != 0)
			{
					count++;
					populateSetOfPointsTill5Hour(sig);
					setMinStart(sig);
			}
			else
			{
				printResult(count);
				mapOfPoints = new int[mapSizeConst + 1];
				minStart = Integer.MAX_VALUE;
				count = 0;
			}
		}
	}
	
	public static void setMinStart(int sig)
	{
		if (sig < minStart)
		{
			minStart = sig;
		}
	}
	
	public static void printResult(int count)
	{
		boolean intersect = false;
		
		if (count > 0)
		{
			long h, m, s;
			for(int i = minStart; i < mapOfPoints.length; i++)
			{
				if (mapOfPoints[i] == count)
				{
					h = TimeUnit.SECONDS.toHours(i);
					m = TimeUnit.SECONDS.toMinutes(i) - TimeUnit.HOURS.toMinutes(h);
					s = i - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(i));
					System.out.println(String.format("%02d:%02d:%02d", h, m , s));
					intersect = true;
					break;
				}
			}
			
			if (!intersect)
			{
				System.out.println("Signals fail to synchronise in 5 hours");
			}
		}
	}
	
	public static void populateSetOfPointsTill5Hour(int sig)
	{
		//System.out.println(sig);
		for(int i = 0; i <= mapSizeConst; i = i + 2*sig)
		{
			//System.out.print("start: " + i + " ");
			for(int green = i; green < (i+sig-5) && green <= mapSizeConst; green++)
			{
				mapOfPoints[green]++;
			}
			//System.out.println("end: " + (i + sig - 5));
		}
	}
}