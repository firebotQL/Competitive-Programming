import java.io.*;
import java.util.*;

// 1, 3, 6, 10
// 1, 2, 3, 4, 5
// i + ++i;
// 1. i = 0
//
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()) {
      int value = sc.nextInt();
      int higher = 0;
      int lower = 0;
      int denominator = 1;
      int numerator = 1;
      for(int i = 0; i < 4473; i++) {
        lower = higher + 1;
        higher += i;
        System.out.println("Low:" + lower + " - High: " + higher);
        if (value <= higher) {
          denominator = value - lower; // lower
          numerator = higher - value + 1; // higher
          System.out.println("Den:" + denominator + " - Num: " + numerator);
          if (i % 2 == 1) {
              int tmp = denominator;
              denominator = numerator;
              numerator = tmp;
          }
          break;
        }
      }
      System.out.printf("TERM %d IS %d/%d%n", value, numerator, denominator);
    }
  }
}
