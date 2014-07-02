import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int cases = Integer.parseInt(reader.readLine());
		int n, count, index, snowFlake, max;
		Integer value;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while((line = reader.readLine()) != null)
		{
			map = new HashMap<Integer, Integer>();
			n = Integer.parseInt(line);
			count = 0;
			index = 0;
			max = Integer.MIN_VALUE;
			while(n-- != 0)
			{
				snowFlake = Integer.parseInt(reader.readLine());
				
				value = map.get(snowFlake);
				if (value != null && value >= index)
				{
					max = Math.max(max, count - index);
					index = map.get(snowFlake) + 1;
				}
				map.put(snowFlake, count++);
			}
			max = Math.max(max, count - index);
			System.out.println(max);
		}
	}
}