class Solution {
    public boolean isValidSudoku(char[][] board) {
        int boardSize = 9;
        for(int i = 0; i < boardSize; i++) {
            int[] rowCount = new int[256];
            int[] columnCount = new int[256];
            for(int j = 0; j < boardSize; j++) {
                char ch = board[i][j];
                if (ch != '.' && ++rowCount[ch] > 1) return false;
                char chc = board[j][i];
                if (chc != '.' && ++columnCount[chc] > 1) return false;

                if (i % 3 == 0 && j % 3 == 0 && !isBlockValid(board, i, j)) return false;
            }
        }
        return true;
    }


    public boolean isBlockValid(char[][] board, int startR, int startC) {
        int[] blockCount = new int[256];
        for(int i = startR; i < startR + 3; i++) {
            for(int j = startC; j < startC + 3; j++) {
                char ch = board[i][j];
                if (ch != '.' && ++blockCount[ch] > 1) return false;
            }
        }
        return true;
    }
}
