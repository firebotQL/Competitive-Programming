/**
 * 1.7 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
 * the image by 90 degrees. Can you do this in place?
 */
public class Main {
    public static void main(String[] args) {
        int N = 3;
        int[][] matrix = new int[N][];
        initializeMatrix(matrix, N);
        printMatrix(matrix);
        invertMatrix(matrix);
        printMatrix(matrix);
    }

    private static void initializeMatrix(int[][] matrix, int N) {
        for(int i = 0; i < N; i++) {
            matrix[i] = new int[N];
            for(int j = 0; j < N; j++) {
                matrix[i][j] = i*N + j + 1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * O(n)
     * Clockwise In Place Rotation
     * @param matrix
     */
    private static void invertMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length/2; i++) {
            int je = matrix[i].length - i - 1;
            for (int j = i; j < je; j++) {
                swap(matrix, i, j, i+j, je);
                swap(matrix, i, j, je, je-j);
                swap(matrix, i, j, je-j, i);
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j, int a, int b) {
        int tmp = matrix[a][b];
        matrix[a][b] = matrix[i][j];
        matrix[i][j] = tmp;
    }
}
