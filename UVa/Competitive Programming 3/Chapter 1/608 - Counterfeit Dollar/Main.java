import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static Set<Character> even = new HashSet<Character>();
	public static List<HashSet<Character>> up = new ArrayList<HashSet<Character>>();
	public static List<HashSet<Character>> down = new ArrayList<HashSet<Character>>();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(reader.readLine());
		String[][] trys = new String[3][];
		while(cases-- != 0)
		{
			even = new HashSet<Character>();
			up = new ArrayList<HashSet<Character>>();
			down = new ArrayList<HashSet<Character>>();
			
			trys[0] = reader.readLine().split("\\s+");
			trys[1] = reader.readLine().split("\\s+");
			trys[2] = reader.readLine().split("\\s+");
			addDataToSets(trys);
			printResult(trys);
		}
	}
	
	public static void printResult(String[][] trys)
	{
		Set<Character> upSet = new HashSet<Character>();
		
		if (up.size() > 0)
		{
			upSet.addAll(up.get(0));
		}
		
		Set<Character> downSet = new HashSet<Character>();
		
		if (down.size() > 0)
		{
			downSet.addAll(down.get(0));
		}
		
		for(int i = 1; i < up.size(); i++)
		{
			upSet.retainAll(up.get(i));
		}
		
		for(int i = 1; i < down.size(); i++)
		{
			downSet.retainAll(down.get(i));
		}
		
		upSet.removeAll(even);
		downSet.removeAll(even);
		
		if (upSet.size() > 0)
		{
			for(Character t : upSet)
			{
				System.out.println(t + " is the counterfeit coin and it is light.");
			}
		} 
		else if (downSet.size() > 0)
		{
			for(Character t : downSet)
			{
				System.out.println(t + " is the counterfeit coin and it is heavy.");
			}
		}
		
	}
	
	public static void addDataToSets(String[][] trys)
	{
		for(int i = 0; i < trys.length; i++)
		{
			if (trys[i][2].equals("even"))
			{
				addStringToSet(trys[i][0], even);
				addStringToSet(trys[i][1], even);
			}
			else if (trys[i][2].equals("up"))
			{
				HashSet<Character> upSet = new HashSet<Character>();
				HashSet<Character> downSet = new HashSet<Character>();
				addStringToSet(trys[i][0], downSet);
				addStringToSet(trys[i][1], upSet);
				up.add(upSet);
				down.add(downSet);
			}
			else if (trys[i][2].equals("down"))
			{
				HashSet<Character> upSet = new HashSet<Character>();
				HashSet<Character> downSet = new HashSet<Character>();
				addStringToSet(trys[i][0], upSet);
				addStringToSet(trys[i][1], downSet);
				up.add(upSet);
				down.add(downSet);
			}
		}
	}
	
	public static void addStringToSet(String string, Set set)
	{
		for(int i = 0; i < string.length(); i++)
		{
			set.add(string.charAt(i));
		}
	}
	
	public static Character[] toCharacterArray(String s) {
	   if (s == null) {
		 return null;
	   }
	   Character[] array = new Character[s.length()];
	   for (int i = 0; i < s.length(); i++) {
		  array[i] = new Character(s.charAt(i));
	   }

	   return array;
	}
}