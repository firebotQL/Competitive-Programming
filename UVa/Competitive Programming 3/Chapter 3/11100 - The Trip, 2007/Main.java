import java.util.*;
import java.lang.*;
import java.io.*;

/**
* NOTE:
* Befware that next read line for all the bags might be not on the same line
* Dont use BuffereReader
**/
public class Main
{
	public static int[] bags = new int[10001];
	public static void main(String[] args) throws IOException
	{
		Scanner reader = new Scanner(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int n, i, j, bagSize, duplicateCnt, maxDuplicateCnt;
		StringBuffer buffer = null;
		ArrayList<ArrayList<Integer> > list = null;
		ArrayList<Integer> bag = null;
		String lineSeparator = System.getProperty("line.separator");

		boolean first = true;
		
		while(reader.hasNextInt())
		{
			n = reader.nextInt();
			
			if (n == 0)
			{
				break;
			}
			
			if (!first)
			{
				System.out.println();
			}
			
			first = false;			
			buffer = new StringBuffer();
			
			for(i = 0; i < n; i++)
			{
				bags[i] = reader.nextInt();
			}
			
			Arrays.sort(bags, 0, n);
			
			duplicateCnt = 1;
			maxDuplicateCnt = 1;
			
			for(i = 0; i < n-1; i++)
			{
				if (bags[i] == bags[i+1])
				{
					duplicateCnt++;
				}
				else
				{
					maxDuplicateCnt = Math.max(duplicateCnt, maxDuplicateCnt);
					duplicateCnt = 1;
				}
			}
			
			maxDuplicateCnt = Math.max(duplicateCnt, maxDuplicateCnt);

			list = createArrayBySize(maxDuplicateCnt);
			
			for(i = 0; i < n; i++)
			{
				list.get(i % maxDuplicateCnt).add(bags[i]);
			}
			
			for(i = 0; i < maxDuplicateCnt; i++)
			{
				bag = list.get(i);
				bagSize = bag.size();
				for(j = 0; j < bagSize; j++)
				{
					if (j != 0)
					{
						buffer.append(' ');
					}
					buffer.append(bag.get(j));
				}
				buffer.append(lineSeparator);
			}
			
			System.out.println(maxDuplicateCnt);
			System.out.print(buffer.toString());
		}
	}
	
	public static ArrayList<ArrayList<Integer> > createArrayBySize(int size)
	{
		ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >(size);
		
		while(size-- != 0)
		{
			list.add(new ArrayList<Integer>());
		}
		
		return list;
	}
}