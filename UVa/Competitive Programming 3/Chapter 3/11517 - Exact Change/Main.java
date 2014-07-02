import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int notesCnt;
	public static int minNotesUsed, minValue;
	public static List<Integer> notes = new ArrayList<Integer>();
	public static int[] change = new int[30001];
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int cases, totalValue, i, v, result = 0;
		cases = scanner.nextInt();
		
		while(cases-- != 0)
		{
			totalValue = scanner.nextInt();
			notesCnt = scanner.nextInt();
			notes.clear();
			
			for(i = 0; i < notesCnt; i++)
			{
				notes.add(scanner.nextInt());
			}
			
			Collections.sort(notes);
			
			Arrays.fill(change, Integer.MAX_VALUE);
			change[0] = 0;
			
			minNotesUsed = Integer.MAX_VALUE;
			minValue = Integer.MAX_VALUE;
			
			for(Integer note : notes)
			{
				for(v = 30001 - note - 1; v >= 0; v--)
				{
					if (change[v] < Integer.MAX_VALUE)
					{
						change[v + note] = Math.min(change[v + note], change[v] + 1);
					}
				}
			}
			
			for(v = totalValue; v < 30001; v++)
			{
				if (change[v] < Integer.MAX_VALUE)
				{
					result = v;
					break;
				}
			}
			
			System.out.println(result + " " + change[result]);
		}
	}
}