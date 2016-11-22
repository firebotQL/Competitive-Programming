import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = null;
    StringBuffer sb = new StringBuffer();
    while((line = reader.readLine()) != null) {
      if (line.indexOf('_') > -1) {
        continue;
      }
      byte strip = 0;
      int bits = 6;
      for(int i = 2; i < line.length() - 1; i++) {
        char ch = line.charAt(i);
        if (ch == 'o') {
          strip |= (1 << bits);
        } else if (ch == '.') {
          continue;
        }
        bits--;
      }
      sb.append((char)strip);
    }
    System.out.print(sb.toString());
  }
}
