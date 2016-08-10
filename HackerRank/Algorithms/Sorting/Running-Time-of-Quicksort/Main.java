import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for(int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		int[] arr1 = Arrays.copyOf(ar, ar.length);
		int[] arr2 = Arrays.copyOf(ar, ar.length);
	
		int insertionSortCount = insertionSort(arr1);
		int quickSortCount = quickSort(arr2, 0 , arr2.length - 1);
		System.out.println(insertionSortCount - quickSortCount);
	}

	/** Insertion Sort **/
    public static int insertionSort(int[] arr) {
    	int count = 0;
    	for(int i = 1; i < arr.length; i++) {
    		int j = i;
    		while(j > 0 && arr[j-1] > arr[j]) {
    			swap(arr,j-1, j);
    			count++;
    			j--;
    		}
    	}
    	return count;
    }

	/** Quick Sort **/
	public static int quickSort(int[] arr, int lo, int hi) {
		int count = 0;
		if (lo < hi) {
			int i = lo;
			int pivot = arr[hi];
			for(int j = lo; j < hi; j++) {
				if (arr[j] < pivot) {
					swap(arr, i, j);
					i++;
					count++;
				}
			}
			swap(arr, i, hi);
			count++;
			count += quickSort(arr, lo, i - 1) + quickSort(arr, i + 1, hi);
		}
		return count;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
