import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[100];
        int sum = 0;
        while(n-- != 0) {
            ar[sc.nextInt()]++;
            sc.next();  // skipping text
        }
        for(int i = 0; i < 100; i++) {
            sum += ar[i];
            System.out.print(sum + " ");
        }
    }
}
