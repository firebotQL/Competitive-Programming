class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // horizontal swap
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
                if (i != j) {
                    swap(matrix, j, i, n - 1 - i, n - 1 - j);
                }
            }
        }

        // vertical flip
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                swap(matrix, j, i, n - 1 - j, i);
            }
        }
    }

    public void swap(int[][] matrix, int idx1r, int idx1c, int idx2r, int idx2c) {
        int tmp = matrix[idx1r][idx1c];
        matrix[idx1r][idx1c] = matrix[idx2r][idx2c];
        matrix[idx2r][idx2c] = tmp;
    }
}
