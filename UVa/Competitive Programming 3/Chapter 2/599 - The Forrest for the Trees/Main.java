import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static String delim1 = "[(,)]";
	public static String delim2 = ",";
	
	public static int[] components = null;
	public static int count;
	public static int i;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(reader.readLine());
		
		boolean[] vertices = null;
		
		String line = null;
		String[] splitLine = null;
		
		int acorns, a1, a2;
		
		StringTokenizer token = null;
		
		while(n-- != 0)
		{
			acorns = 0;
			initComponents();
			vertices = new boolean[26];
			
			while((line = reader.readLine()) != null && line.charAt(0) != '*')
			{
				splitLine = line.split(delim1);
				a1 = splitLine[1].charAt(0) - 65;
				a2 = splitLine[2].charAt(0) - 65;
				vertices[a1] = true;
				vertices[a2] = true;
				
				if (connected(a1, a2)) continue;
				union(a1, a2);
			}
			
			splitLine = reader.readLine().split(delim2);
			
			for(i = 0; i < splitLine.length; i++)
			{
				if (!vertices[splitLine[i].charAt(0) - 65])
				{
					acorns++;
				}
			}
			
			System.out.println("There are " + (splitLine.length - (26 - count) - acorns) + " tree(s) and " + acorns + " acorn(s).");
			
		}
	}
	
	public static void initComponents()
	{
		count = 26;
		components = new int[26];
		for(i = 0; i < 26; i++)
		{
			components[i] = i;
		}
	}
	
	public static int find(int a1)
	{
		return components[a1];
	}
	
	public static boolean connected(int a1, int a2)
	{
		return components[a1] == components[a2];
	}
	
	public static void union(int a1, int a2)
	{
		if (connected(a1, a2)) return;
		int pid = components[a1];
		for(i = 0; i < components.length; i++)
		{
			if (components[i] == pid) components[i] = components[a2];
		}
		count--;
	}
}