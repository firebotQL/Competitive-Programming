import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- != 0) {
            reader.readLine(); // skip line
            String line = reader.readLine();
            String[] splitLine = line.split("\\s+");
            int m = Integer.parseInt(splitLine[0]);
            int n = Integer.parseInt(splitLine[1]);
            String[] grid = new String[m];

            for(int i = 0; i < m; i++) {
                grid[i] = reader.readLine().toLowerCase();
            }

            int k = Integer.parseInt(reader.readLine());

            while(k-- != 0) {
                String word = reader.readLine().toLowerCase();

                Result rowResult = findInRows(m, n, grid, word);
                Result columnResult = findInColumns(m, n, grid, word);
                Result diagonalsResult = findInDiagonals(m, n, grid, word);

                Result result = getSmallerResult(rowResult, columnResult);
                result = getSmallerResult(result, diagonalsResult);

                System.out.println(String.format("%d %d", result.getRow() + 1,  result.getCol() + 1));
            }
            if (T != 0) {
              System.out.println();
            }
        }
    }

    private static Result findInRows(int maxRowIndexSize, int maxColumnIndexSize, String[] grid, String word) {
        Result result = null;

        if (word.length() <= maxColumnIndexSize) {
            for(int rowIndex = 0; rowIndex < maxRowIndexSize; rowIndex++) {
                // 1) normal direction
                String row = grid[rowIndex];
                int foundIdx = row.indexOf(word);
                if (foundIdx > -1) {
                    result = new Result(rowIndex, foundIdx);
                    break;
                }
                // 2) reverse direction
                String reverseRow = new StringBuilder(row).reverse().toString();
                foundIdx = reverseRow.indexOf(word);
                if (foundIdx > -1) {
                    result = new Result(rowIndex, maxColumnIndexSize - foundIdx - 1);
                    break;
                }
            }
        }

        return result;
    }

    private static Result findInColumns(int maxRowIndexSize, int maxColumnIndexSize, String[] grid, String word) {
        Result result = null;
        if (word.length() <= maxRowIndexSize) {
            StringBuffer sb = new StringBuffer(maxRowIndexSize);

            for (int columnIndex = 0; columnIndex < maxColumnIndexSize; columnIndex++) {
                sb.setLength(0);
                for (int rowIndex = 0; rowIndex < maxRowIndexSize; rowIndex++) {
                    sb.append(grid[rowIndex].charAt(columnIndex));
                }

                // 1) normal direction
                int foundIdx = sb.toString().indexOf(word);

                if (foundIdx > -1) {
                    result = new Result(foundIdx, columnIndex);
                    break;
                }

                // 2) reverse direction
                foundIdx = sb.reverse().toString().indexOf(word);
                if (foundIdx > -1) {
                    result = new Result(maxRowIndexSize - foundIdx - 1, columnIndex);
                    break;
                }
            }
        }
        return result;
    }


    private static Result getSmallerResult(Result result1, Result result2) {
        Result result = result1;

        if (result2 != null) {
            if (result == null || result2.getRow() < result.getRow() ||
                    (result2.getRow() == result.getRow() &&
                            result2.getCol() < result.getCol())) {
                result = result2;
            }
        }
        return result;
    }

    private static Result findInDiagonals(int maxRowIndexSize, int maxColumnIndexSize, String[] grid, String word) {
        Result result = null;

        int diagonalsMaxNumber = maxColumnIndexSize + maxColumnIndexSize - 1;
        int startRow = maxRowIndexSize - 1;
        int startCol = 0;

        int startRow2 = 0;
        int startCol2 = 0;
        for(int diagonalNumber = 0; diagonalNumber < diagonalsMaxNumber; diagonalNumber++) {
            StringBuffer sb = new StringBuffer(maxRowIndexSize);    // TODO: Check if correct

            for(int i = startRow, j = startCol; i < maxRowIndexSize && j < maxColumnIndexSize; i++, j++) {
                sb.append(grid[i].charAt(j));
            }

            int foundIndex = sb.toString().indexOf(word);

            if (foundIndex > -1) {
                result = getSmallerResult(result, new Result(startRow + foundIndex, startCol + foundIndex));
            }

            foundIndex = sb.reverse().toString().indexOf(word);

            if (foundIndex > -1) {
                result = getSmallerResult(result, new Result(startRow + (sb.length() - foundIndex - 1), startCol + (sb.length() - foundIndex - 1)));
            }

            if (startRow > 0) {
                startRow--;
            } else {
                startCol++;
            }

            StringBuffer sb2 = new StringBuffer(maxRowIndexSize);    // TODO: Check if correct

            for(int i = startRow2, j = startCol2; i >= 0 && j < maxColumnIndexSize; i--, j++) {
                sb2.append(grid[i].charAt(j));
            }

            foundIndex = sb2.toString().indexOf(word);

            if (foundIndex > -1) {
                result = getSmallerResult(result, new Result(startRow2 - foundIndex, startCol2 + foundIndex));
            }

            foundIndex = sb2.reverse().toString().indexOf(word);

            if (foundIndex > -1) {
                result = getSmallerResult(result, new Result(startRow2 - (sb.length() - foundIndex - 1), startCol2 + (sb.length() - foundIndex - 1)));
            }

            if ((startRow2 + 1) < maxRowIndexSize) {
                startRow2++;
            } else {
                startCol2++;
            }
        }

        return result;
    }

    public static class Result {
        private int row;
        private int col;

        public Result(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
