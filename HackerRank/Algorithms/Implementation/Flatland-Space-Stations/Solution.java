import java.io.*;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == m) {
            System.out.println(0);
        } else {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < m; i++) {
                int stationLocation = sc.nextInt();
                for(int j = 0; j < n; j++) {
                    distances[j] = Math.min(distances[j], Math.abs(stationLocation - j));
                }
            }
            for(int i = 0; i < distances.length; i++) {
                max = Math.max(distances[i], max);
            }
            System.out.println(max);
        }
    }
}
