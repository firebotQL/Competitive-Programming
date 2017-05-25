import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder(33);
    while(sc.hasNext()) {
      int I = sc.nextInt();
      if (I == 0) break;
      long P = 0, tmp = 0;
      sb.setLength(0);
      while (I != 0) {
        tmp = I % 2;
        sb.append(tmp);
        P += tmp;
        I >>= 1;
      }
      System.out.printf("The parity of %s is %d (mod 2).%n", sb.reverse().toString(), P);
    }
  }
}
