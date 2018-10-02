import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.valueOf(reader.readLine());
    while(t-- != 0) {
      String[] numbers = reader.readLine().split("\\s+");
      String a = new StringBuffer(numbers[0]).reverse().toString();
      String b = new StringBuffer(numbers[1]).reverse().toString();
      BigInteger aBigInt = new BigInteger(a);
      BigInteger bBigInt = new BigInteger(b);
      BigInteger resultBigInt = aBigInt.add(bBigInt);
      String sResult = new StringBuffer(resultBigInt.toString()).reverse().toString();
      BigInteger finalResult = new BigInteger(sResult);
      System.out.println(finalResult);
    }
  }
}
