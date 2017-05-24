import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- != 0) {
      int n = sc.nextInt() + 1;
      if (n == 2) n++;
      while(numSum(n) != primeSum(n)) {
        n++;
      }
      System.out.println(n);
    }
  }

  public static int numSum(int n) {
    int sum = 0;
    while(n >= 10) {
      sum += n % 10;
      n /= 10;
    }
    return sum + n;
  }

  public static int primeSum(int n) {
    List<Integer> list = primeFactors(n);
    int sum = 0;
    for(Integer prime : list) {
      sum += numSum(prime);
    }
    return sum;
  }

  public static List<Integer> primeFactors(int n) {
    List<Integer> list = new ArrayList<Integer>();
    while(n % 2 == 0) {
      list.add(2);
      n /= 2;
    }
    int sqrt = (int)Math.sqrt(n);
    for(int i = 3; i <= sqrt; i += 2) {
      while(n % i == 0) {
        list.add(i);
        n /= i;
      }
    }
    if (n > 2 && list.size() > 0) list.add(n);
    return list;
  }
}
