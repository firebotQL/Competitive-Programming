import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
		int k, a, b, v;
		String[] splitLine = null;
		while((line = reader.readLine()) != null)
		{
			splitLine = line.split("\\s+");
			k = Integer.valueOf(splitLine[0]);
			a = Integer.valueOf(splitLine[1]);
			b = Integer.valueOf(splitLine[2]);
			v = Integer.valueOf(splitLine[3]);
			
			int requiredBoxes = 0;
			int overallCells = a / v + (a % v > 0 ? 1 : 0);		// 4 cells

			
			int fullDividedBoxes = b / (k - 1);		// how many boxes fully divided  1
			int leftDividers = b % (k - 1);
			
			int neededFullDividedBoxes = overallCells / k;
			
			if (fullDividedBoxes > neededFullDividedBoxes)
			{
				overallCells = overallCells % k;
				requiredBoxes = neededFullDividedBoxes;
			} 
			else
			{
				overallCells -= fullDividedBoxes * k;
				requiredBoxes = fullDividedBoxes;
			}
			
			if (overallCells > 0 && leftDividers > 0)
			{
				overallCells -= (leftDividers + 1);
				requiredBoxes++;
			}
			
			if (overallCells > 0)
			{
				requiredBoxes += overallCells;
			}
			
			System.out.println(requiredBoxes);
		}
	 }
}