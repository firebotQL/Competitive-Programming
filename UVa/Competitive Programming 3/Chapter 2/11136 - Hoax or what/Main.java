import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n, k, value;
		long sum;
		StringTokenizer token = null;
		TreeMap<Integer, Integer> map = null;
		while((line = reader.readLine()) != null && line.charAt(0) != '0')
		{
			sum = 0;
			n = Integer.parseInt(line);
			map = new TreeMap<Integer, Integer>();
			while(n-- != 0)
			{
				token = new StringTokenizer(reader.readLine());
				k = Integer.parseInt(token.nextToken());

				while(k-- != 0)
				{
					if (!token.hasMoreTokens())
					{
						token = new StringTokenizer(reader.readLine());
					}
					
					value = Integer.parseInt(token.nextToken());
					Integer count = map.get(value);
					
					if (count == null)
					{
						count = 0;
					}
					map.put(value, count + 1);
				}
				
				Map.Entry<Integer, Integer> lowest = map.firstEntry();
	
				removeOrDecrementOccurence(map, lowest);
				
				Map.Entry<Integer, Integer> highest = map.lastEntry();
				
				removeOrDecrementOccurence(map, highest);
				
				sum += highest.getKey() - lowest.getKey();
				
			}
			System.out.println(sum);
		}
	}
	
	// Basically decrements occurance if key/bill occured more tha once or removes it if it occured once
	public static void removeOrDecrementOccurence(TreeMap<Integer, Integer> map, Map.Entry<Integer, Integer> entry)
	{
		if (entry.getValue() > 1)
		{
			map.put(entry.getKey(), map.get(entry.getKey()) - 1);
		}
		else
		{
			map.remove(entry.getKey());
		}
	}
}