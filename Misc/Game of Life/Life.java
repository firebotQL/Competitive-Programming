import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Life {
    public static int generationCount = 1;

    public static void main(String[] args) throws IOException {
        List<String> gridLines = getGrid();
        printResult(gridLines);
        calculateGeneration(gridLines);
    }

    private static void calculateGeneration(List<String> gridLines) {
       for(int i = 0; i < gridLines.size(); i++) {
            String line = gridLines.get(i);
            for(int j = 0; j < line.length(); j++) {
                int nearbyCnt = getNearbyCount(gridLines, i, j);
                char[] charLine = line.toCharArray();
                if (nearbyCnt < 2 || nearbyCnt > 3) { // 1. dies
                    charLine[j] = '.';
                } else {    // 2. becomes alive
                    charLine[j] = '*';
                }
                line = new String(charLine);
                gridLines.set(i, line);
            }
        }
        printResult(gridLines); 
    }

    private static void printResult(List<String> gridLines) {
        System.out.println("Generation " + generationCount++ + ":");
        for(int i = 0; i < gridLines.size(); i++) {
            String line = gridLines.get(i);
            for(int j = 0; j < line.length(); j++) {
                System.out.print(line.charAt(j));
            }
            System.out.println();
        }
        System.out.println();
    }

	// Can add more adjacent edges (e.g. i = -1, j = -1)
    private static int getNearbyCount(List<String> gridLines, int i, int j) {
        return aliveCountByOffset(gridLines, i, j, -1, 0) +
                aliveCountByOffset(gridLines, i, j, 0, -1) +
                aliveCountByOffset(gridLines, i, j, 0, 1) +
                aliveCountByOffset(gridLines, i, j, 1, 0);
    }

    private static int aliveCountByOffset(List<String> gridLines, int i, int j, int offsetI, int offsetJ) {
        int ii = i + offsetI;
        int jj = j + offsetJ;
        if (ii < 0 || ii >= gridLines.size() ||
                jj < 0 || jj >= gridLines.get(ii).length()) {
            return 0;
        }

        return isAlive(gridLines.get(ii).charAt(jj)) ? 1 : 0;
    }

    private static boolean isAlive(char cell) {
        return cell == '*';
    }

    public static List<String> getGrid() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String line;
        List<String> gridLines = new ArrayList<String>();

        while((line = reader.readLine()) != null) {
            gridLines.add(line);
        }

        return gridLines;
    }
}
