import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.Arrays;

class Main {

	public static boolean nextPermutation(char[] a)
	{
		int N=a.length;
		char temp;
		int i=N-2;
		for (; i>=0; i--) if (a[i]<a[i+1]) break;
		if (i<0) return false;
		
		for (int j=N-1; j>=i; j--)
		{
			if (a[j]>a[i])
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				break;		
			}
		}
		for (int j=i+1; j<(N+i+1)/2; j++)		//reverse from a[i+1] to a[N-1]
		{
			temp=a[j];
			a[j]=a[N+i-j];
			a[N+i-j]=temp;
		}
		return true;
	}
    

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String line = null;
		char[] temp;
		while(n-- != 0) {
			temp = reader.readLine().toCharArray();
			Arrays.sort(temp);
			do {
				System.out.println(temp);
			} while (nextPermutation(temp));			
		}
	}
}
