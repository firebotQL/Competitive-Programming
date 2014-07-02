import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		List<Integer> arrayList = new ArrayList<Integer>();
		int index;
		while((line = reader.readLine()) != null)
		{
			Integer value = Integer.valueOf(line.trim());
			arrayList.add(value);
			Collections.sort(arrayList);
			index = arrayList.size()/2;
			if (arrayList.size() % 2 == 1)
			{
				System.out.println(arrayList.get(index));
			} 
			else
			{
				System.out.println((arrayList.get(index-1) + arrayList.get(index))/2);
			}
		}
	}
}