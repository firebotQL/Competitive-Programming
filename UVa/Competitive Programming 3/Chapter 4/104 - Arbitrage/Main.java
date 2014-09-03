import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static int max = 20;
    public static double[][][] table;
    public static int[][][] path = new int[max][max][max];
    public static int n;
    
    public static void main(String[] args) throws IOException
    {
		Scanner scan = new Scanner(System.in);
       while(scan.hasNextInt())
        {
            n = scan.nextInt();
            table = new double[max][max][max];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                        if (i == j)
                        {
                            table[i][j][1] = 1.0;
                        }
                        else
                        {
                            table[i][j][1] = scan.nextDouble();
                        }
                        Arrays.fill(path[i][j], -1);
                }
            }
            
            boolean found = false;
            
            for(int steps = 2; steps <= n && !found; steps++)
            {       
                for(int k = 0; k < n; k++)
                {
                    for(int i = 0; i < n; i++)
                    {
                        for(int j = 0; j < n; j++)
                        {
                            double tmp = table[i][k][steps - 1] * table[k][j][1];
                            
                            if(tmp > table[i][j][steps]) 
                            {
                                table[i][j][steps] = tmp;
                                path[i][j][steps] = k;
                            }
                        }
                    }
                }
                
                for(int i = 0; i < n && !found; i++)
                {
                    if (table[i][i][steps] >= 1.01)
                    {
                       System.out.println(recursevlyGetPath(i, i, steps));
                       found = true;
                    }
                }
            }

            if (!found)
            {
                System.out.println("no arbitrage sequence exists");
            }
          
        }
    }
    
    public static String recursevlyGetPath(int x, int y, int s)
    {
        if (path[x][y][s] == -1)
        {
            return ((x + 1) + " " + (y + 1));
        }
        
        return recursevlyGetPath(x, path[x][y][s], s - 1) + " " + (y + 1);
    }
}
