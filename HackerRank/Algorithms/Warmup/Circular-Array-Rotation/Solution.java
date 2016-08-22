import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        int init = k % n;
        for(int i = init; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < init; i++) {
            arr[i] = sc.nextInt();
        }
        while(q-- != 0) {
            System.out.println(arr[sc.nextInt()]);
        }
    }
}
