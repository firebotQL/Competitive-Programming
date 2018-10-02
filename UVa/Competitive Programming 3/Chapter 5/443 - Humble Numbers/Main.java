import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] humbleNumbers = generateHumbleNumbers();
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.printf("The %d%s humble number is %d.%n", n, getOrdinal(n), humbleNumbers[n - 1]);
        }
    }

    public static int[] generateHumbleNumbers() {
        int[] humbleNumbers = new int[5842];
        humbleNumbers[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, t7 = 0, tmp;
        for(int i = 1; i < 5842; i++) {
            while(humbleNumbers[t2] * 2 <= humbleNumbers[i - 1]) t2++;
            while(humbleNumbers[t3] * 3 <= humbleNumbers[i - 1]) t3++;
            while(humbleNumbers[t5] * 5 <= humbleNumbers[i - 1]) t5++;
            while(humbleNumbers[t7] * 7 <= humbleNumbers[i - 1]) t7++;
            tmp = humbleNumbers[t2] * 2;
            if (humbleNumbers[t3] * 3 < tmp) tmp = humbleNumbers[t3] * 3;
            if (humbleNumbers[t5] * 5 < tmp) tmp = humbleNumbers[t5] * 5;
            if (humbleNumbers[t7] * 7 < tmp) tmp = humbleNumbers[t7] * 7;
            humbleNumbers[i] = tmp;
        }
        return humbleNumbers;
    }

    public static String getOrdinal(int n) {
        String[] s= { "th","st","nd","rd" };
        int v = n % 100;
        int z = (v - 20) % 10;
        if (z >= 0 && z < s.length) return s[z];
        else if (v < s.length) return s[v];
        else return s[0];
    }
}
