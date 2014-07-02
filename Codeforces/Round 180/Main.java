import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String wind = null;
		String[] vars = null;
		int t,sx,sy,ex,ey,result;
		double distance1;
		while ((line = reader.readLine()) != null) {
			vars = line.split("\\s+");
			t = Integer.parseInt(vars[0]);
			sx = Integer.parseInt(vars[1]);
			sy = Integer.parseInt(vars[2]);
			ex = Integer.parseInt(vars[3]);
			ey = Integer.parseInt(vars[4]);
			wind = reader.readLine();
			result = -1;
			for(int i = 0; i < t; i++) {
				distance1 = getDistance(ex, ey, sx, sy);
				switch(wind.charAt(i)) {
					case 'N':
						sy += (distance1 > getDistance(sx, sy+1, ex, ey)) ? 1 : 0;
						break;
					case 'S':
						sy += (distance1 > getDistance(sx, sy-1, ex, ey )) ? -1 : 0;	
						break;
					case 'W':
						sx += (distance1 > getDistance(sx-1, sy, ex, ey )) ? -1 : 0;
						break;
					case 'E':
						sx += (distance1 > getDistance(sx+1, sy, ex, ey )) ? 1 : 0;
						break;
				}
				if (sy == ey && sx == ex) {
					result = i+1;
					break;
				}
			}
			
			System.out.println(result);
			
		}
	}

	public static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y2-y1)*(y2-y1));
	}
}