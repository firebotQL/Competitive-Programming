import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.Character;


class Main {

	public static enum Directions {
		E,N,W,S,NONE
	}

	public static void fill(int[][] array, int n, int m) {
		int i, j;
		for(i = 0; i < n; i++) {
			for(j = 0; j < m; j++) {
				array[i][j] = -1;
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		Scanner sc;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] numbers;
		int b, w, i, j, digit;
		int sb = 0,sw = 0, sbb, sww;
		int[][] array;
		boolean found, first;
		Directions direction;
		while((line = reader.readLine()) != null 
			&& !line.equals("0 0")) {
			sc = new Scanner(line);
			b = sc.nextInt();
			w = sc.nextInt();
			array = new int[b+2][w+2];
			fill(array, b+2, w+2);

			for(i = 1; i <= b; i++) {
				line = reader.readLine();
				found = false;
				for(j = 1; j <= w; j++) {
					digit = Character.digit(line.charAt(j-1), 10);
					array[i][j] = digit == 1 ? -1 : digit;
					if (!found && digit == 0) {
						sw=i;sb=j;
						found = true;
					}
				}			
			}

			array[sw][sb]= 0;
			direction = getEastDirection(array, sb, sw);
			sbb = sb; sww = sw;
			int count = 0;
			int visits[] = new int[5];
			do {
				array[sw][sb]++;
				count++;
				switch(direction) {
					case E:
						sb++;
						direction = getEastDirection(array, sb, sw);
						break;
					case N:
						sw--;
						direction = getNorthDirection(array, sb, sw);
						break;
					case W:
						sb--;
						direction = getWestDirection(array, sb, sw);
						break;
					case S:
						sw++;
						direction = getSouthDirection(array, sb, sw);
						break;
				}
			} while(direction != Directions.NONE && (sw != sww || sb != sbb));
			for(i = 1; i < b+1; i++) {
					for(j = 1; j < w+1; j++) {
						if (array[i][j] != -1)
							visits[array[i][j]]++;
					}
			}	
			System.out.format("%3d%3d%3d%3d%3d%n", visits[0], visits[1], visits[2], visits[3], visits[4]);
		}
	}
	
	public static Main.Directions getEdirection(int[][] labirinth, int x, int y) {
		if (labirinth[y+1][x]==-1 &&  labirinth[y][x+1] >= 0) 
			return Main.Directions.E;
		else if (labirinth[y+1][x-1] == -1 && labirinth[y+1][x] >= 0)
			return Main.Directions.S;
		return Main.Directions.NONE;
	}

	public static Main.Directions getNdirection(int[][] labirinth, int x, int y) {
		if (labirinth[y][x+1]==-1 && labirinth[y-1][x] >= 0) 
			return Main.Directions.N;
		else if (labirinth[y+1][x+1] == -1 && labirinth[y][x+1] >= 0)
			return Main.Directions.E;
		return Main.Directions.NONE;		
	}

	public static Main.Directions getWdirection(int[][] labirinth, int x, int y) {
		if (labirinth[y-1][x]==-1 && labirinth[y][x-1] >= 0) 
			return Main.Directions.W;
		else if (labirinth[y-1][x+1]==-1 && labirinth[y-1][x] >= 0)
			return Main.Directions.N;
		return Main.Directions.NONE;
	}

	public static Main.Directions getSdirection(int[][] labirinth, int x, int y) {
		if (labirinth[y][x-1]==-1 && labirinth[y+1][x] >= 0) 
			return Main.Directions.S;
		else if (labirinth[y-1][x-1] == -1 && labirinth[y][x-1]>=0)
			return Main.Directions.W;
		return Main.Directions.NONE;
	}
	public static Main.Directions getEastDirection(int[][] labirinth, int x, int y) {
		Main.Directions direction;
		if ((direction =getEdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getNdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getWdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getSdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		return Main.Directions.NONE;
	}

	public static Main.Directions getNorthDirection(int[][] labirinth, int x, int y) {
		Main.Directions direction;
		if ((direction =getNdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getWdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getSdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getEdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		return Main.Directions.NONE;
	}

	public static Main.Directions getWestDirection(int[][] labirinth, int x, int y) {
		Main.Directions direction;
		if ((direction =getWdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getSdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getEdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getNdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		return Main.Directions.NONE;
	}
		
	public static Main.Directions getSouthDirection(int[][] labirinth, int x, int y) {
		Main.Directions direction;
		if ((direction =getSdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getEdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getNdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		if ((direction =getWdirection(labirinth, x, y)) != Main.Directions.NONE)
			return direction;
		return Main.Directions.NONE;	
	}
}
