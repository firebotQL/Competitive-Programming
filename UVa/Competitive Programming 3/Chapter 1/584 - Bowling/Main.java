import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int[] values = new int [100];
	public static int frames = 0;
	public static void populateValues()
	{
		for(int i = 48; i < 58; ++i)
			values[i] = i - 48;
		values['X'] = 10;
		values['/'] = 10;
	}
		
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int score = 0;
		populateValues();
		int step = 0;
		//long start = System.nanoTime();
		char currentValue, oneStepAwayValue, twoStepAwayValue;
		char[] array = null;
		while((line = reader.readLine()).charAt(0) != 'G')
		{
			score = 0;
			frames = 0;
			array = line.toCharArray();
			for(step = 0; step < array.length && frames != 20; step+=2)
			{
				frames += 1;
				currentValue = array[step];
				
				switch(currentValue)
				{ 
					case 'X':
						frames += 1;
						oneStepAwayValue = array[step+2];
						twoStepAwayValue = array[step+4];
						if (twoStepAwayValue == '/')
						{
							score += 20;
						}
						else 
						{
							score += 10 + values[oneStepAwayValue] + values[twoStepAwayValue];
						}
						break;
					case '/':
						score += 10 + values[array[step+2]] - values[array[step-2]];
						break;
					default:
						score += values[currentValue];
						break;
				}
				//System.out.print(score + " ");
			}
			//System.out.println();
			System.out.println(score);
		}
		//long end = System.nanoTime();
		//System.out.println("Execution time was "+(end-start)+" ns.");
	}
}