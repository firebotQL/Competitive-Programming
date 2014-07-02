import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static class Pair
	{
		public boolean bachelor = false;
		public int age;
		public Pair(boolean bachelor, int age)
		{
			this.bachelor = bachelor;
			this.age = age;
		}
	}
	
	public class AgeComparator implements Comparator<Pair>
	{
		@Override
		public int compare(Pair a, Pair b)
		{
			return a.age - b.age;
		}
	}
	
	public static void List<Pair> array = new ArrayList<Pair>();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int B, S;
		
		AgeComparator comp = new AgeComparator();
		int caseNr = 1;
		Pair leftSpinster = null;
		Pair rightSpinster = null;
		
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			B = Integer.valueOf(split[0]);
			S = Integer.valueOf(split[1]);
			
			if (B <= S)
			{
				System.out.println("Case " + caseNr + ": " + 0);
			}
			
			for(i = 0; i < B; i++)
			{
				array.add(new Pair(Integer.valueOf(reader.readLine(), true)));
			}
			
			for(i = 0; i < S; i++)
			{
				array.add(new Pair(Integer.valueOf(reader.readLine(), false)));
			}
			
			Collections.sort(array, comparator);
			
			Iterator<Pair> it = array.iterator();
			

			int totalSize = B + S;
			
			for(i = 0; i < totalSize; i++)
			{
				Pair currentPerson = array.get(i);
				
				if (!currentPerson.bachelor)
				{
					leftSpinster = currentPerson;
					continue;
				}
				
				for (j = i + 1; j < totalSize; j++)
				{
					rightSpinster = array.get(i);
				}
			}
			
			System.out.print("Case " + caseNr + ": " + array.size() + " " + array.get(i));
		}
	}
}