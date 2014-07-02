import java.io.*;
import java.util.Arrays;


public class Main {
	public static int[] N = new int[200];
	public static int[][][] dp = new int[201][15][25];
	public static int N_size = 0;
	public static int D = 0;
	public static int sumMod = 0;
	
	public static int mod(int first, int second) 
	{
        return (first % second + second) % second;
    }
	
	public static int solve(int M, int sum, int index)
	{
		sumMod = mod(sum, D);
		
		if (M == 0)
		{
			if (sumMod != 0) return 0;
			return 1;		
		}
		
		if (index == N_size) return 0;
		
		if (dp[index][M][sumMod] != -1) return dp[index][M][sumMod];
		
		return dp[index][M][sumMod] = solve(M - 1, sum + N[index], index + 1) + solve(M, sum, index + 1);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i, j, Q_size, M, setNr = 1, count;
		String line = null;
		String[] split = null;
		
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			N_size = Integer.valueOf(split[0]);
			Q_size = Integer.valueOf(split[1]);
			
			if (N_size == 0 && Q_size == 0)
			{
				break;
			}
			

			
			for(i = 0; i < N_size; i++)
			{
				N[i] = Integer.valueOf(reader.readLine());
			}
			System.out.printf("SET %d:%n", setNr++);
			for(j = 1; j <= Q_size; j++)
			{
				for(int[][] twoDimension : dp)
				{
					for(int[] oneDimension : twoDimension)
					{
						Arrays.fill(oneDimension, -1);
					}
				}
				
				split = reader.readLine().split("\\s+");
				D = Integer.valueOf(split[0]);
				M = Integer.valueOf(split[1]);
				
				count = solve(M, 0,  0);
				
				System.out.printf("QUERY %d: %d%n", j, count);
			}
		}
	}
}