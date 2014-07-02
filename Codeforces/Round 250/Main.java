import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static class Answer
	{
		public char letter;
		public int size;
		public Answer(char l, int s)
		{
			letter = l;
			size = s;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line1 = null, line2, line3, line4;
		Answer[] array = new Answer[4];
		
		while((line1 = reader.readLine()) != null)
		{
			line2 = reader.readLine();
			line3 = reader.readLine();
			line4 = reader.readLine();
			
			int size1 = line1.length()-2;
			int size2 = line2.length()-2;
			int size3 = line3.length()-2;
			int size4 = line4.length()-2;
			
			array[0] = new Answer(line1.charAt(0), size1);
			array[1] = new Answer(line2.charAt(0), size2);
			array[2] = new Answer(line3.charAt(0), size3);
			array[3] = new Answer(line4.charAt(0), size4);
			
			Arrays.sort(array, new Comparator<Answer>()
			{
				public int compare(Answer a1, Answer a2)
				{
					return a1.size - a2.size;
				}
			});
			
			//System.out.println(array[0].size + " " + array[1].size + " " + array[2].size + " " + array[3].size);
			
			if (array[0].size <= array[1].size/2 && array[0].size <= array[2].size/2 && array[0].size <= array[3].size/2)
			{
				System.out.println(array[0].letter);
			}
			else if (array[3].size/2 >= array[0].size && array[3].size/2 >= array[1].size && array[3].size/2 >= array[2].size)
			{
				System.out.println(array[3].letter);
			}
			else
			{
				System.out.println("C");
			}
		}
	}
}