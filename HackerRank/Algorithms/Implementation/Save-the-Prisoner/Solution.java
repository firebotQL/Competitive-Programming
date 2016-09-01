import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int S = sc.nextInt();
            int result = (S + M - 2) % N + 1;
            System.out.println(result);
        }
    }
}
