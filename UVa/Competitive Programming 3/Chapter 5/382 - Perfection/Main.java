import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("PERFECTION OUTPUT");
    while(sc.hasNext()) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      int sum = 0;
      for(int i = 1; i < n; i++) {
        if (n % i == 0) sum += i;
      }
      String stringIs = "PERFECT";
      if (sum > n) stringIs = "ABUNDANT";
      else if (sum < n) stringIs = "DEFICIENT";
      System.out.format("%5d%2s%s%n", n, "", stringIs);
    }
    System.out.println("END OF OUTPUT");
  }
}
