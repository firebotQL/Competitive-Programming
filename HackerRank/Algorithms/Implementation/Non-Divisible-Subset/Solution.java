import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[k];
        for(int i = 0; i < n; i++) {
            arr[sc.nextInt() % k]++;
        }
        int cnt = 0;
        for(int i = 0; i <= k/2; i++) {
           if (i == 0 || (2*i == k)) {  // if start or end
               if (arr[i] > 0) cnt++; 
           } else {
               cnt += Math.max(arr[i], arr[k-i]);
           }
        }
        System.out.println(cnt);
    }
}
