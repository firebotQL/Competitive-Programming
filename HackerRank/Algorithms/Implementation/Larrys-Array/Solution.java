import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0) {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	for(int i = 0; i < N; i++) {
        		arr[i] = sc.nextInt();
        	}

        	int count = 0;
        	for(int i = 0; i < N-1; i++) {
        		for(int j = i + 1; j < N; j++) {
        			if (arr[i] > arr[j]) 
        				count++;
        		}
        	}
        	if (count % 2 == 0) {
        		System.out.println("YES");
        	} else {
        		System.out.println("NO");
        	}
        }
    }
}
