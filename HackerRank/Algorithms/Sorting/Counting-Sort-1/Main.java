import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[100];
        while(n-- != 0) {
            ar[sc.nextInt()]++;
        }           
        for(int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }
}
