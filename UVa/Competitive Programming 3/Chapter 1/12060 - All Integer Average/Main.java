import java.io.*;
import java.lang.*;

class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splittedLine = null;
		int n, sum, gcd, numerator, denumerator, length, length2, length3, full, offset, caase = 1;
		String result = "";
		while((line = reader.readLine()) != null)
		{
			splittedLine = line.split("\\s+");
			
			if (splittedLine.length == 1)
			{
				break;
			}
			
			sum = 0;
			
			n	= Integer.valueOf(splittedLine[0]);
			
			for(int i = 1; i < splittedLine.length; i++)
			{
				sum += Integer.valueOf(splittedLine[i]);
			}	
			
			full = full(sum, n);
			//System.out.println("Full: " + full);
			offset = sum < 0 ? 2 : 0;
			full = Math.abs(full);
			
			System.out.println("Case " + caase++ + ":");
			//System.out.println("Sum: " + sum);
			
			if (!requireFraction(sum, n))
			{
				System.out.println(getOffset(offset) + String.valueOf(full));
			}
			else
			{
				numerator = numerator(Math.abs(sum), n);
				denumerator = n;
				gcd = GCD(numerator, n);
				numerator /= gcd;
				denumerator /= gcd;				
				
				if (full > 0)
				{
					length = (int)(Math.log10(full)+1);
				}
				else 
				{
					length = 0;
				}				
				
				length2 =  (int)(Math.log10(denumerator)+1);
				length3 = (int)(Math.log10(numerator)+1);
				
				String dashes = new String(new char[length2]).replace('\0', '-');
				
				
				result = String.format("%" + (length2 + offset+length) + "s", String.valueOf(numerator));
				System.out.println(result);
				
				if (full > 0)
				{
					result = String.format(getOffset(offset) + String.valueOf(full) + dashes);					
				}
				else
				{
					result = String.format(getOffset(offset) + dashes);
				}
				
				System.out.println(result);
				
				result = String.format("%" + (length2 + offset+length) + "s", String.valueOf(denumerator));
				System.out.println(result);
			}
			
		}
	}
	
	public static int full(int sum, int n)
	{
		return sum/n;
	}
	
	public static int numerator(int sum, int n)
	{
		return sum % n;
	}
	
	public static boolean requireFraction(int sum, int n)
	{
		return sum % n != 0;
	}
	
	public static int GCD(int a, int b) {
		if (b==0) return a;
		return GCD(b, a%b);
	}
	
	public static String getOffset(int offset)
	{
		return offset > 0 ? "- " : "";
	}
}