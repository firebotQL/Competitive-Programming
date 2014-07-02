import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
	static public class Pair implements Comparable<Pair>
	{
		public String a;
		public String b;
		
		public Pair(String a, String b)
		{
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Pair other){
			int first = this.a.compareTo(other.a);
			return first == 0 ? this.b.compareTo(other.b) : first;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(reader.readLine());
		String line = null;
		String noSpaceLine = null;
		String sortedKey = null;
		List<String> caseWords = new ArrayList<String>();
		Map<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
		reader.readLine();
		while(n-- != 0)
		{		
			anagrams = new HashMap<String, ArrayList<String>>(); 
			
			while ((line = reader.readLine()) != null && !line.isEmpty())
			{
				
				noSpaceLine = line.replaceAll("\\s+","");				
				
				char[] chars = noSpaceLine.toCharArray();
				Arrays.sort(chars);
				sortedKey = new String(chars);
				
				ArrayList<String> anagram = anagrams.get(sortedKey);	
				
				if (anagram == null)
				{
					anagram = new ArrayList<String>();
				}
				
				anagram.add(line);
				anagrams.put(sortedKey, anagram);
			}			
			
			ArrayList<String> keys = new ArrayList<String>(anagrams.keySet());
			
			Collections.sort(keys);
			
			ArrayList<Pair> resultArray = new ArrayList<Pair>();
			
			System.out.println("----" + keys.get(0) + "----");
			
			for(String key : keys)
			{
				ArrayList<String> values = anagrams.get(key);

				
				
				for(int i = 0; i < values.size(); i++)
				{
					for(int j = i+1; j < values.size(); j++)
					{
						resultArray.add(new Pair(values.get(i), values.get(j)));
					}
				}
			}
			
			Collections.sort(resultArray);
			
			for(Pair result: resultArray)
			{
				System.out.println(result.a + " = " + result.b);
			}
			 
			if (n != 0)
			{
				System.out.println();
			}	
		}
	}
}