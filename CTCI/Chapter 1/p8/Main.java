import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 1.8 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class Main {
    public static void main(String[] args) {
        int M = 4;
        int N = 5;
        int[][] matrix = getMatrix(M, N);
        printMatrix(matrix);
        crossMatrixZeros(matrix);
        printMatrix(matrix);
    }

    private static void crossMatrixZeros(int[][] matrix) {
        Set<Integer> rowsToConvert = new HashSet<Integer>();
        Set<Integer> columnsToConvert = new HashSet<Integer>();
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsToConvert.add(i);
                    columnsToConvert.add(j);
                }
            }
        }

        for(Integer row : rowsToConvert) {
            for(int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for (Integer column : columnsToConvert) {
                matrix[i][column] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] getMatrix(int M, int N) {
        int[][] matrix = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = 1;
            }
        }
        matrix[(int)(Math.random()*M)][(int)(Math.random()*N)] = 0;
        matrix[(int)(Math.random()*M)][(int)(Math.random()*N)] = 0;
        matrix[(int)(Math.random()*M)][(int)(Math.random()*N)] = 0;
        return matrix;
    }
}
