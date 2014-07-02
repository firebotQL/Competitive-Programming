import java.util.*;
import java.io.*;

class Main2 {
	public static int count = 0;
	public static long[] array = new long[10000000];
	public static long[] left = new long[10000000];
	public static long[] right = new long[10000000];
	
	public static void mergeSort(int startIdx, int endIdx) {
		if (startIdx < endIdx) {
			int middleIdx = (startIdx+endIdx)/2;
			mergeSort(startIdx, middleIdx);
			mergeSort(middleIdx+1, endIdx);
			merge(startIdx, middleIdx, endIdx);
		}
	}
	
	public static void merge(int startIdx, int middleIdx, int endIdx) {
		int sIdx, mIdx, eIdx, idx1 = 0, idx2 = 0;
		
		for(sIdx = startIdx; sIdx <= middleIdx; sIdx++) {
			left[idx1++] = array[sIdx];
		}
		
		for(sIdx = middleIdx+1; sIdx <= endIdx; sIdx++) {
			right[idx2++] = array[sIdx];
		}
		sIdx = mIdx = 0;
		eIdx = startIdx;
		while(sIdx < idx1 || mIdx < idx2) {
			if (sIdx < idx1 && mIdx < idx2) {
				if(left[sIdx] > right[mIdx]) {
					count += idx1 - sIdx;
					array[eIdx] = right[mIdx];
					mIdx++;
				} else {
					array[eIdx] = left[sIdx];
					sIdx++;
				}
			} else if (sIdx < idx1) {
				array[eIdx] = left[sIdx];
				sIdx++;
			} else if (mIdx < idx2) {
				array[eIdx] = right[mIdx];
				mIdx++;
			}
			eIdx++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String line;
		String[] tokens;
		int i, size;
		while(scan.hasNextInt()) {
			size = scan.nextInt();
			count = 0;
			for(i = 0; i < size; i++) {
				array[i] = scan.nextLong();
			}
			
			mergeSort(0, size-1);
			
			System.out.println(count);
		}
	}
}
