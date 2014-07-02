import java.util.*;
import java.lang.*;
import java.io.*;

public class Main2
{
	public static void main(String[] args) throws IOException
	{
		int[] permutations = new int[9];
		printPermutations(permutations, 0);
	}
	
	public static void printPermutations(int[] permutations, int count)
	{
		if (count == 9)
		{
			for(int i = 1; i < 9; i++)
			{
				if (i != 8)
				{
					System.out.print(permutations[i] + " ");
				}
				else
				{
					System.out.print(permutations[i]);
				}
			}
			System.out.println();
			return;
			
		}
		
		for(int i = 1; i < 9; i++)
		{
			permutations[count] = i;
			printPermutations(permutations, count + 1);
		}
	}
}