import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int countLine1, countLine2, i, j;
	
	public static int[] frequency = new int[256];
	
	public static String line1, line2;
	
	public static char ch;
	
	public static Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while((line1 = reader.readLine()) != null && (line2 = reader.readLine()) != null)
		{	
			System.out.println("[");
			
			if (line1.length() == line2.length())
			{
				generateStackIOSequences(line1.length());
			}
			System.out.println("]");
		}
	}

	static void generateStackIOSequences(final int N) {
        generateStackIOSequences(N, 0, 0, new char[N * 2], "", 0, 0);
    }
	
	static void generateStackIOSequences(int insertCount, int outCount, int index, char[] arr, String result, int line1Index, int line2Index) {
        while (outCount >= 0) {
            if (insertCount > 0) {
                arr[index] = 'i';
                generateStackIOSequences(insertCount - 1, outCount + 1, index + 1, arr, result + line1.charAt(line1Index), line1Index + 1, line2Index);
            }
            if (outCount-- > 0) {
            	
                arr[index++] = 'o';
				if (result.charAt(result.length() - 1) != line2.charAt(line2Index++))
				{
					return;
				}
				
				result = result.substring(0, result.length() - 1);
                
                if (index == arr.length) {
                    printResult(arr);
                }
            }
        }
    }
	
	public static void printResult(char[] ioArray)
	{	
		
		StringBuilder builder = new StringBuilder();
		
		for (j = 0; j < ioArray.length; j++)
		{
			builder.append(ioArray[j]).append(' ');
			
		}
		
		builder.setLength(builder.length() - 1);
		
		builder.append(System.lineSeparator());
		System.out.print(builder.toString());
	}
}