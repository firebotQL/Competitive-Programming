import java.util.Scanner;
import java.io.IOException;

class Main {
	public static int[] board = new int[101];
	public static int[] players = new int[1000002];
	
	public static void resetBoard() {
		for(int i = 0; i < 101; i++)
			board[i] = i+1;
				
	}

	public static void resetPlayers(int playerCount) {
		for(int i = 1; i <= playerCount; ++i) 
			players[i] = 1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int game, nr, shortcut, rolls, player, roll, playerPosition, i;
		boolean resultFound = false;
		if (scanner.hasNextInt()) {
			game = scanner.nextInt();
			while(game-- != 0) {
				resetBoard();
				nr = scanner.nextInt();
				resetPlayers(nr);
				player = nr > 0 ? 1 : 0;
				shortcut = scanner.nextInt();
				rolls = scanner.nextInt();
				while(shortcut-- != 0)
					board[scanner.nextInt()-1] = scanner.nextInt();
				//for(int j = 0; j < 100; ++j)
				//	System.out.print(board[j] + " ");
				//System.out.println(); 
				resultFound = false;
				while(rolls-- != 0) {
					if (resultFound == false) {
						player = player > nr ? 1 : player;	// NOTE: there should be a some way to reduce it
						roll = scanner.nextInt();
						//System.out.println("roll " + roll);
						//System.out.println("player pos: " + players[player]);
						playerPosition = players[player]+roll;
						
						if (playerPosition >= 100) {
							playerPosition = 100;
							resultFound = true;							
						}

						//System.out.println(resultFound);
						//System.out.println("board '" + board[playerPosition-1] + "' playerPosition '" + playerPosition + "'");
						if (board[playerPosition-1] != playerPosition)
							players[player] = board[playerPosition-1];
						else 
							players[player] = playerPosition;

						if (players[player] == 100) 
							resultFound = true;
						player++;
					} else {
						scanner.nextInt();
					}
					//System.out.println("Debug - Player '" + (player-1) + "' position is '" + (players[player-1]) + "'");
				}
				i = 1;
				while(i <= nr) 
					System.out.println("Position of player " + i + " is " + players[i++] + ".");
				
			}
		}
		
	}
}
