import java.util.*;
import java.io.*;

class Main {
	public static int count = 0;
	public static int maxSize = 1000000;
	public static int[] array = new int[maxSize];
	public static int[] temp = new int[maxSize];
	public static int size = 0;
	
	public static void mergeSort(int i, int j) {
		if (i < j) {
			int m = (i+j)/2;
			mergeSort(i, m);
			mergeSort(m+1, j);
			merge(i, m, j);
		}
	}
	
	public static void merge(int i, int m, int j) {
		int x = i, z = m+1, k = i;
		System.out.print("merge low-"+ i + " mid-" + m + " high-" + j + ": ");
		for(int b = i; b < j; b++) {
			System.out.print(array[b]);
		}
		System.out.println();
		
		while((x <= m) && (z <= j)) {
			if (array[x] < array[z]) {
				temp[k] = array[x];
				k++;
				x++;
			} else {
				temp[k] = array[z];
				k++;
				z++;
				count++;
			}
		}
		
		while(x <= m) {
			temp[k] = array[x];
			k++;
			x++;
		}
		
		while(z <= j) {
			temp[k] = array[z];
			k++;
			z++;
		}
		
		for(x = i; x < k; x++) {
			array[x] = temp[x];
			System.out.print(temp[x]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String line;
		String[] tokens;
		int c,i;
		while(scan.hasNextInt()) {
			size = scan.nextInt();
			count = 0;
			for(i = 0; i < size; i++) {
				array[i] = scan.nextInt();
			}
			
			for(int j = 0; j < size; j++) 
				System.out.print(array[j] + " "	);
			System.out.println();
			mergeSort(0, size-1);
			for(int j = 0; j < size; j++) 
				System.out.print(array[j] + " "	);
			System.out.println();
			System.out.print(count);
		}
	}
}
