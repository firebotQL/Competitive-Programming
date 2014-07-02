import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Character;



class Main {
	public static char board[][] = new char[12][12];

	public static void resetBoard() {
		int i,j;
		for(i = 0; i < 12; ++i) {
			for(j = 0; j < 12; ++j) {
				board[i][j] = '-';
			}
		}
	}

	public static void markPawnAttackedSquares(int rowIndex, int colIndex, boolean white) {
		int i;
		if (white) {
			i = -1;
		} else {
			i = 1;
		}
		if (board[rowIndex+i][colIndex-1] == '-') {
			board[rowIndex+i][colIndex-1] = 'a';
		}
		if (board[rowIndex+i][colIndex+1] == '-') {
			board[rowIndex+i][colIndex+1] = 'a';
		}
	}

	public static void markKnightAttackedSquares(int rowIndex, int colIndex) {
		if (board[rowIndex-1][colIndex-2] == '-') {
			board[rowIndex-1][colIndex-2] = 'a';
		}
		if (board[rowIndex-2][colIndex-1] == '-') {
			board[rowIndex-2][colIndex-1] = 'a';
		}
		if (board[rowIndex-2][colIndex+1] == '-') {
			board[rowIndex-2][colIndex+1] = 'a';
		}
		if (board[rowIndex-1][colIndex+2] == '-') {
			board[rowIndex-1][colIndex+2] = 'a';
		}

		if (board[rowIndex+1][colIndex-2] == '-') {
			board[rowIndex+1][colIndex-2] = 'a';
		}
		if (board[rowIndex+2][colIndex-1] == '-') {
			board[rowIndex+2][colIndex-1] = 'a';
		}
		if (board[rowIndex+2][colIndex+1] == '-') {
			board[rowIndex+2][colIndex+1] = 'a';
		}
		if (board[rowIndex+1][colIndex+2] == '-') {
			board[rowIndex+1][colIndex+2] = 'a';
		}
	}

	public static void markBishopAttackedSquares(int rowIndex, int colIndex) {
		int i = 1;
		while((rowIndex-i >= 0) && (colIndex-i >= 0)) {
			if (board[rowIndex-i][colIndex-i] == '-' || board[rowIndex-i][colIndex-i] == 'a')
				board[rowIndex-i][colIndex-i] = 'a';
			else 
				break;
			i++;
		}
		i = 1; 
		while((rowIndex-i >= 0) && (colIndex+i < 12)) {
			if (board[rowIndex-i][colIndex+i] == '-' || board[rowIndex-i][colIndex+i] == 'a')
				board[rowIndex-i][colIndex+i] = 'a';
			else 
				break;
			i++;
		}
		i = 1; 
		while((rowIndex+i < 12) && (colIndex+i < 12)) {
			if (board[rowIndex+i][colIndex+i] == '-' || board[rowIndex+i][colIndex+i] == 'a')
				board[rowIndex+i][colIndex+i] = 'a';
			else
				break;
			i++;
		}
		i = 1; 
		while((rowIndex+i < 12) && (colIndex-i >= 0)) {
			if (board[rowIndex+i][colIndex-i] == '-' || board[rowIndex+i][colIndex-i] == 'a')
				board[rowIndex+i][colIndex-i] = 'a';
			else
				break;
			i++;
		}
	}

	public static void markRookAttackedSquares(int rowIndex,int colIndex) {
		int i = 1;
		while((colIndex-i >= 0)) {
			if (board[rowIndex][colIndex-i] == '-' || board[rowIndex][colIndex-i] == 'a')
				board[rowIndex][colIndex-i] = 'a';
			else
				break;
			i++;
		}
		i = 1; 
		while((colIndex+i < 12)) {
			if (board[rowIndex][colIndex+i] == '-' || board[rowIndex][colIndex+i] == 'a')
				board[rowIndex][colIndex+i] = 'a';
			else
				break;
			i++;
		}
		i = 1; 
		while((rowIndex-i >= 0)) {
			if (board[rowIndex-i][colIndex] == '-' || board[rowIndex-i][colIndex] == 'a')
				board[rowIndex-i][colIndex] = 'a';
			else
				break;
			i++;
		}
		i = 1; 
		while(rowIndex+i < 12) {
			if (board[rowIndex+i][colIndex] == '-' || board[rowIndex+i][colIndex] == 'a')
				board[rowIndex+i][colIndex] = 'a';
			else 				
				break;
			i++;
		}
	}

	public static void markKingAttackedSquares(int rowIndex, int colIndex) {
		if (board[rowIndex][colIndex-1] == '-') {
			board[rowIndex][colIndex-1] = 'a';
		}
		if (board[rowIndex-1][colIndex-1] == '-') {
			board[rowIndex-1][colIndex-1] = 'a';
		}
		if (board[rowIndex-1][colIndex] == '-') {
			board[rowIndex-1][colIndex] = 'a';
		}
		if (board[rowIndex-1][colIndex+1] == '-') {
			board[rowIndex-1][colIndex+1] = 'a';
		}
		if (board[rowIndex][colIndex+1] == '-') {
			board[rowIndex][colIndex+1] = 'a';
		}
		if (board[rowIndex+1][colIndex+1] == '-') {
			board[rowIndex+1][colIndex+1] = 'a';
		}
		if (board[rowIndex+1][colIndex] == '-') {
			board[rowIndex+1][colIndex] = 'a';
		}
		if (board[rowIndex+1][colIndex-1] == '-') {
			board[rowIndex+1][colIndex-1] = 'a';
		}
	}
	
	public static void markAttackedSquare(int rowIndex, int colIndex, char figure) {
		switch(Character.toLowerCase(figure)) {
			case 'p':
				if (figure == 'p')
					markPawnAttackedSquares(rowIndex, colIndex, false);
				else 
					markPawnAttackedSquares(rowIndex, colIndex, true);
				break;
			case 'n':
				markKnightAttackedSquares(rowIndex, colIndex);
				break;
			case 'b':
				markBishopAttackedSquares(rowIndex, colIndex);
				break;
			case 'r':
				markRookAttackedSquares(rowIndex, colIndex);
				break;
			case 'q':
				markBishopAttackedSquares(rowIndex, colIndex);
				markRookAttackedSquares(rowIndex, colIndex);				
			case 'k':
				markKingAttackedSquares(rowIndex, colIndex);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] tokens = null;
		int colIndex, rowIndex;
		char lineChar = '-';
		int i, j, count;
		while((line = reader.readLine()) != null) {
			resetBoard();
			tokens = line.split("/");
			rowIndex = 2;
			for(String token : tokens) {
				colIndex = 2;
				for(i = 0; i < token.length(); i++) {
					lineChar = token.charAt(i);
					if (Character.isDigit(lineChar)) {
						colIndex += Character.getNumericValue(lineChar);
					} else { 
						board[rowIndex][colIndex] = lineChar;
						colIndex++;
					}						
				}
				rowIndex++;
			}

			for(i = 2; i < 10; ++i) {
				for(j = 2; j < 10; ++j) {
					markAttackedSquare(i, j, board[i][j]);
				}
			}
			count = 0;
			for(i = 2; i < 10; ++i) {
				for(j = 2; j < 10; ++j) {
					if (board[i][j] == '-')
						count++;
				}
			}
			System.out.println(count);
		}		
	}
}
