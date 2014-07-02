import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null; 
		int T = Integer.valueOf(reader.readLine().trim());
		int[] cars = null;
		Map<Integer, String> carNames = null;
		int L, H, D, Q, i, P, carIndex, foundCarIndex, Llowest, Hhighest, j;
		for(j = 0;j < T; j++)
		{
			
			D = Integer.valueOf(reader.readLine());
			Llowest = Integer.MAX_VALUE;
			Hhighest = Integer.MIN_VALUE;
			cars = new int[1000001];
			
			carNames = new HashMap<Integer, String>();
			
			carNames.put(0, "UNDETERMINED");
			carNames.put(1000001, "UNDETERMINED");
			
			for(i = 0; i < D; i++)
			{
				splitLine = reader.readLine().split("\\s+");
				L = Integer.valueOf(splitLine[1]);
				H = Integer.valueOf(splitLine[2]);
				carIndex = i + 1;
				carNames.put(carIndex, splitLine[0]);
				
				if (Llowest > L)
				{
					Llowest = L;
				}
				
				if (Hhighest < H)
				{
					Hhighest = H;
				}
				
				for(;L <= H; L++)
				{
					if (cars[L] == 0)
					{
						cars[L] = carIndex;
					}
					else
					{
						cars[L] = 1000001;
					}
				}
			}
			
			Q = Integer.valueOf(reader.readLine());
			foundCarIndex = 0;
			while(Q-- != 0)
			{
				P = Integer.valueOf(reader.readLine());
				System.out.println(carNames.get(cars[P]));
			}
			
			if (j+1 < T)
			{
				System.out.println();
			}
		}
	}
}
