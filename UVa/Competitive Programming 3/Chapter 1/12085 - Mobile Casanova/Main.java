import java.io.*;
import java.math.*;

class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int N, counter = 1;
		BigInteger currentNumber = new BigInteger("0");
		BigInteger previousNumber = null;
		BigInteger initialNumber = new BigInteger("0");
		BigInteger endNumber = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		boolean found = false;
		String initialNumberString = null;
		String endNumberString = null;
		int index = 0;
		while((line = reader.readLine()) != null && (N = Integer.valueOf(line)) != 0)
		{
			found = false;
			
			System.out.println("Case " + counter++ + ":");
			
			// Case where 1 element
			if (N == 1)
			{
				System.out.println(reader.readLine());
			}
			else
			{
				// Using P (previous) and C (current) index carriages
				previousNumber = new BigInteger(reader.readLine());
				
				for(int i = 1; i < N; i++)
				{	
					currentNumber =  new BigInteger(reader.readLine());
		
					while (currentNumber.subtract(previousNumber).compareTo(one) == 0 && i++ < N)		// Add N restriction
					{
						
						if (!found)
						{
							initialNumber = previousNumber;
							found = true;
						}
						
						previousNumber = currentNumber;
						
						if (i < N) 
						{
							currentNumber= new BigInteger(reader.readLine());
						}
						
					}
					
					endNumber = previousNumber;
							
					if (!found)
					{
						System.out.println("0" + endNumber.toString());
					}
					else
					{
						initialNumberString = initialNumber.toString();
						endNumberString = endNumber.toString();
						index = getBigIntegerDifferentIndex(initialNumberString, endNumberString);
						System.out.println("0"+ initialNumberString + "-" + endNumberString.substring(index, endNumberString.length()));
						found = false;
					}
					previousNumber = currentNumber;
				}
				
				// When end is not pointing to the last element then we print last element
				if (endNumber != previousNumber)
				{
					System.out.println("0" + previousNumber.toString());
				}
				
			}
			
			System.out.println();	
				
		}
	}
	
	public static int getBigIntegerDifferentIndex(String one, String two)
	{
		int result = -1;
		
		for(int j = 0; j < one.length(); j++)
		{
			if (one.charAt(j) != two.charAt(j))
			{
				result = j;
				break;
			}
		}
		return result;
	}
}