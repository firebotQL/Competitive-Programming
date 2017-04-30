import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i = 1; i <= t; i++) {
      int d = sc.nextInt();
      int v = sc.nextInt();
      int u = sc.nextInt();
      if (v >= u || v == 0 || u == 0) {
        System.out.println(String.format("Case %d: can't determine", i));
      } else {
        double t1 = d/(double)u;
        double t2 = d/Math.sqrt(u*u - v*v);
        System.out.println(String.format("Case %d: %.3f", i, Math.abs(t2 - t1)));
      }

    }
  }
}
