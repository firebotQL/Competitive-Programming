import java.util.*;
import java.lang.*;
import java.io.*;

public class Gen
{
	public static void main(String[] args) throws IOException
	{
		System.out.println(1);
		System.out.println(50000);
		for(int i = 1; i < 50000; i++)
		{
			System.out.printf("%d %d%n", i , i+1);
		}
	}
}