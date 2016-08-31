import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int memo[] = new int[n];
        Arrays.fill(memo, -1);
        solve(c, memo, 0);
        System.out.print(memo[0]);
    }
    
    public static int solve(int c[], int memo[], int i) {
        if (c.length - 1 == i) return 0;
        if (c.length <= i || c[i] == 1) return Integer.MAX_VALUE;
        if (memo[i] > -1) return memo[i];
        return memo[i] = 1 + Math.min(solve(c, memo, i+2), solve(c, memo, i+1));
    }
}
