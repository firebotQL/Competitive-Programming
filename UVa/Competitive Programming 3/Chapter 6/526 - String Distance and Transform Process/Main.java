import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line1, line2;
    while((line1 = reader.readLine()) != null &&
          (line2 = reader.readLine()) != null) {
           Result result = createLevenshteinDistanceMatrix(line1, line2);
           int operations = result.d[line1.length()][line2.length()];
           System.out.println(operations);
           List<String> steps = getSteps(line1, line2, result.d, result.steps, operations);
           for(int i = steps.size() - 1; i >= 0; i--) {
               System.out.println(steps.get(i));
           }
           System.out.println();
    }
  }

  public static Result createLevenshteinDistanceMatrix(String line1, String line2) {
        int[][] d = new int[line1.length() + 1][line2.length() + 1];
        int[][] steps = new int[line1.length() + 1][line2.length() + 1];

        for(int i = 1; i <= line1.length(); i++) {
            d[i][0] = i;
        }

        for(int j = 1; j <= line2.length(); j++) {
            d[0][j] = j;
        }
        for(int j = 1; j <= line2.length(); j++) {
            for(int i = 1; i <= line1.length(); i++) {
                int cost = line1.charAt(i - 1) == line2.charAt(j - 1) ? 0 : 1;
                Step deletion = new Step(d[i - 1][j] + 1,1);
                Step insertion = new Step(d[i][j - 1] + 1,-1);
                Step substitution = new Step(d[i - 1][j - 1] + cost,  0);

                Step result = min(deletion, insertion, substitution);

                d[i][j] = result.value;
                steps[i][j] = result.from;
            }
        }

        return new Result(d, steps);
    }

    public static class Result {
        public int[][] d;
        public int[][] steps;
        public Result(int[][] d, int[][] steps) {
            this.d = d;
            this.steps = steps;
        }
    }

    public static class Step {
        public int value;
        public int from;
        public Step(int value, int from) {
            this.value = value;
            this.from = from;
        }
    }


    public static void print(int[][] d, String line1, String line2) {
        for (int i = 0; i <= line1.length(); i++) {
            for(int j = 0; j <= line2.length(); j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

    }
    
    public static Step min(Step del, Step ins, Step subs) {
        Step result = subs.value <= del.value ? subs : del;
        if (ins.value < result.value) {
            result = ins;
        }
        return result;
    }

    public static List<String> getSteps(String line1, String line2, int[][] d, int[][] steps, int count) {
        int i = line1.length();
        int j = line2.length();

        List<String> result = new ArrayList<>();
        while (i != 0 && j != 0) {
            int current = d[i][j];
            switch(steps[i][j]) {
                case 0:
                    int diag = d[i - 1][j - 1];
                    if (diag < current) {
                        result.add(count-- + " Replace " + (i - 1) + "," + line2.charAt(j - 1));
                    }
                    i--;
                    j--;
                    break;
                case -1:
                    result.add(count-- + " Insert " + j + "," + line2.charAt(j - 1));
                    j--;
                    break;
                case 1:
                    result.add(count-- + " Delete " + (i - 1));
                    i--;
                    break;
            }
        }
        while(i != 0) {
            result.add(count-- + " Delete " + i);
            i--;
        }
        while(j != 0) {
            result.add(count-- + " Insert " + j + "," + line2.charAt(j - 1));
            j--;
        }
        return result;
    }

}
