import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n+1];
        while(n-- != 0) {
            ar[sc.nextInt()]++;
        }
        for(int i = 0; i < ar.length; i++) {
            int cnt = ar[i];
            while(cnt-- != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
