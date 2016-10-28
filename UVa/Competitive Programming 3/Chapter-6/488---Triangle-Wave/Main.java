import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- != 0) {
            int amplitude = sc.nextInt();
            int frequency = sc.nextInt();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < frequency; i++) {
                for (int j = 1; j < amplitude; j++) {
                    for(int z = 1; z <= j; z++) {
                        sb.append(j);
                    }
                    sb.append('\n');
                }
                for (int j = amplitude; j > 0; j--) {
                    for(int z = 1; z <= j; z++) {
                        sb.append(j);
                    }
                    sb.append('\n');
                }
                if ((i + 1) != frequency) {
                	sb.append('\n');
            	}
            }
            if (T > 0) {
            	sb.append('\n');
        	}
        	System.out.print(sb.toString());
        }
    }
}
