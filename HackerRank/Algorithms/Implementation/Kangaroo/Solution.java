import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        if (v2 >= v1) {
            System.out.println("NO");        
        } else {
            System.out.println((x2-x1)%(v1-v2) == 0 ? "YES" : "NO");
        }
    }
}
