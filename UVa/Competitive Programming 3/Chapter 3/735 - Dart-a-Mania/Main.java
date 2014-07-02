import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	
	public static int combination, permutation;
	public static int[] availableValues = null;
	public static boolean[][][] taken = new boolean[61][61][61];
	
	public static int i, j, k, one, two, three, availableSize;
	
	public static void initialize()
	{	
		Set<Integer> tmpSet = new HashSet<Integer>();
		for(i = 0; i <= 20; i++)
		{
			tmpSet.add(i);
			tmpSet.add(i * 2);
			tmpSet.add(i * 3);
		}
		tmpSet.add(50);
		availableValues = new int[tmpSet.size()];
		Iterator<Integer> itr = tmpSet.iterator();
		
		for(i = 0; i < tmpSet.size(); i++)
		{
			availableValues[i] = itr.next();
		}

		availableSize = availableValues.length;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int score;
		initialize();
		
		while ((score = Integer.valueOf(reader.readLine())) > 0) {
			combination = 0;
			permutation = 0;
			
			if (score <= 180)
			{
				play(score);				
			}
			
			if (permutation > 0)
			{
				System.out.println("NUMBER OF COMBINATIONS THAT SCORES " + score + " IS " + combination + ".");
				System.out.println("NUMBER OF PERMUTATIONS THAT SCORES " + score +" IS " + permutation + ".");
			}
			else
			{
				System.out.println("THE SCORE OF " + score + " CANNOT BE MADE WITH THREE DARTS.");
			}
			System.out.println("**********************************************************************");	
		}
		System.out.println("END OF OUTPUT");
	}
	
	public static void play(int score)
	{
		taken = new boolean[61][61][61];
		for (i = 0; i < availableSize; i++) 
		{
			for (j = 0; j < availableSize; j++) 
			{
				for (k = 0; k < availableSize; k++) 
				{
						one = availableValues[i];
						two = availableValues[j];
						three = availableValues[k];
						
						if (one + two + three == score)
						{
							
							permutation++;
							if (!taken[one][two][three])
							{
								combination++;
								taken[one][two][three] = taken[one][three][two] = true;	// 1, 2, 3 : 1, 3, 2
								taken[two][one][three] = taken[two][three][one] = true;	// 2, 1, 3 : 2, 3, 1
								taken[three][one][two] = taken[three][two][one] = true; // 3, 1, 2 : 3, 2, 1
							}
						}
				}
			}
		}
	}

}