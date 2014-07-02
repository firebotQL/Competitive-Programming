import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

	public static void main(String[] args)
	{
		getMin("TOPCODER", "", 3);
		System.out.println(maxString);
	}
	public static String maxString = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	
	public static void getMin(String letters, String prefix, int maxDistance)
	{
		int n = letters.length();
	    if (maxDistance == 0)
	    {
	    	if (prefix.compareTo(maxString) < 0)
	    	{
	    		maxString = letters;
	    	}
	    }
	    else {
	        for (int i = 0; i < maxDistance; i++)
	        	getMin(prefix + letters.charAt(i), letters.substring(0, i) + letters.substring(i+1, n), maxDistance);
	    }
	}
}