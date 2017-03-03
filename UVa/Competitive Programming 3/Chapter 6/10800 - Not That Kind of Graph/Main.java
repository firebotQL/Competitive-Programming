import java.util.*;
import java.lang.*;

public class Main {
  public final static int offset = 65;
  public static char[] charMap = new char[36];

  static {
    charMap['R' - offset] = '/';
    charMap['F' - offset] = '\\';
    charMap['C' - offset] = '_';
  }

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      for(int caseNr = 1; caseNr <= N; caseNr++) {
        String line = sc.next();
        char[][] graph = buildEmptyGraph(line.length());
        char prev = ' ';
        int minY = 101, maxY = 0;
        for(int x = 0, y = 50; x < line.length(); x++) {
          char cur = line.charAt(x);
          switch(cur) {
            case 'R':
              if (prev != 'F' && prev != 'C') y += -1;
              break;
            case 'F':
              if (prev != 'R') y += 1;
              break;
            case 'C':
              if (prev == 'R') y += -1;
              break;
          }
          minY = Math.min(minY, y);
          maxY = Math.max(maxY, y);
          graph[y][x] = charMap[cur - offset];
          prev = cur;
        }
        print(graph, minY, maxY, line.length(), caseNr);
      }
  }

  // Could also calcualte Y axis to make map smaller every time
  public static char[][] buildEmptyGraph(int maxX) {
    char[][] graph = new char[102][maxX];
    for (char[] row: graph) {
        Arrays.fill(row, ' ');
    }
    return graph;
  }

  public static void print(char[][] graph, int minY, int maxY, int maxX, int caseNr) {
    System.out.println("Case #" + caseNr + ":");
    for(int y = minY; y <= maxY; y++) {
      System.out.println(("| " + new String(graph[y])).trim());
    }
    char[] xRow = new char[maxX+3];
    Arrays.fill(xRow, '-');
    xRow[0] = '+';
    System.out.println(xRow);
    System.out.println();
  }
}
