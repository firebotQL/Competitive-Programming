import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static class Coordinates
	{
		public int x;
		public int y;
		public Coordinates(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int M, i, j, path, maxMin;
		Map<Integer, Integer> pathCounts = null;
		List<Coordinates> threesCoordinates = null;
		List<Coordinates> onesCoordinates = null;
		String line = null;
		while((line = reader.readLine()) != null)
		{
			M = Integer.valueOf(line);
			threesCoordinates = new ArrayList<Coordinates>();
			onesCoordinates = new ArrayList<Coordinates>();
			for(i = 0; i < M; i++)
			{
				line = reader.readLine();
				for(j = 0; j < M; j++)
				{
					switch(line.charAt(j))
					{
						case '1':
							onesCoordinates.add(new Coordinates(i, j));
							break;
						case '3':
							threesCoordinates.add(new Coordinates(i, j));
							break;
					}
				}
			}

			maxMin = 0;
			
			for(i = 0; i < onesCoordinates.size(); i++)
			{
				Coordinates oneCoord = onesCoordinates.get(i);
				int min = 2 * M;
				for(j = 0; j < threesCoordinates.size(); j++)
				{
					Coordinates threeCoord = threesCoordinates.get(j);
					
					path = Math.abs(threeCoord.x - oneCoord.x) + Math.abs(threeCoord.y - oneCoord.y);
					
					if (path < min) 
					{
						min = path;
					}
				}
				
				if (min > maxMin)
				{
					maxMin = min;
				}
			}

			System.out.println(maxMin);
		}
	}
}