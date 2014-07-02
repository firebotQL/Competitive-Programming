import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;


public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			int H = Integer.valueOf(token.nextToken());
			int W = Integer.valueOf(token.nextToken());
			
			for(int i = 0; i < H; i++)
			{
				System.out.println(hexToBinary(reader.readLine()));
			}
		}
	}
	
	public static String hexToBinary(String Hex) {
		int i = Integer.parseInt(Hex, 16);
		String Bin = Integer.toBinaryString(i);
		return Bin;
	}
}