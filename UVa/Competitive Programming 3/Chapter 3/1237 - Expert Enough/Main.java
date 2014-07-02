import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static class Car
	{
		public String name;
		public int L;
		public int H;
		
		public Car(String name, int L, int H)
		{
			this.name = name;
			this.L = L;
			this.H = H;
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null; 
		int T = Integer.valueOf(reader.readLine().trim());
		Car[] cars = null;
		Map<Integer, String> carNames = null;
		int L, H, D, Q, i, P, cnt, Llowest, Hhighest, j;
		String carName;
		for(j = 0;j < T; j++)
		{
			
			D = Integer.valueOf(reader.readLine());
			Llowest = Integer.MAX_VALUE;
			Hhighest = Integer.MIN_VALUE;
			cars = new Car[D];
			
			for(i = 0; i < D; i++)
			{
				splitLine = reader.readLine().split("\\s+");
				L = Integer.valueOf(splitLine[1]);
				H = Integer.valueOf(splitLine[2]);
				
				if (Llowest > L)
				{
					Llowest = L;
				}
				
				if (Hhighest < H)
				{
					Hhighest = H;
				}
				
				cars[i] = new Car(splitLine[0], L, H);
			}
			
			Q = Integer.valueOf(reader.readLine());
			
			carName = null;
			
			while(Q-- != 0)
			{
				P = Integer.valueOf(reader.readLine());
				cnt = 0;
				if (P >= Llowest && P <= Hhighest)
				{
					for(i = 0; i < D && cnt <= 1; i++)
					{
						Car car = cars[i];
						
						if (car.L <= P && car.H >= P)
						{
							cnt++;
							carName = car.name;
						}
					}					
				}
				
				switch(cnt)
				{
					case 1:
						System.out.println(carName);
						break;
					default:
						System.out.println("UNDETERMINED");
						break;
				}
			}
			
			if (j+1 < T)
			{
				System.out.println();
			}
		}
	}
}
