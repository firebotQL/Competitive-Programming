import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int minNumberOfMoves = 0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] separatedLine = null;
		int[] rowPositions = new int[9];
		int caseNr = 1;
		int i;
		while((line = reader.readLine()) != null)
		{
			separatedLine = line.split("\\s+");
			for(i = 0; i < 8; i++)
			{
				rowPositions[i] = Integer.valueOf(separatedLine[i]);
			}
			getSolution(rowPositions);
			System.out.println("Case " + caseNr++ + ": " + minNumberOfMoves);
		}
	}
	
	public static void getSolution(int[] rowPositions)
	{
		minNumberOfMoves = Integer.MAX_VALUE;
		int[] usedRows = new int[8];
		int[] usedLeftDiagonals = new int[16];
		int[] usedRightDiagonals = new int[16];
		
		getSolution(usedRows, usedLeftDiagonals, usedRightDiagonals, rowPositions, 0, 0);
	}
	
	public static void getSolution(int[] usedRows, int[] usedLeftDiagonals, int[] usedRightDiagonals, int[] rowPositions, int usedQueenNr, int numberOfMoves)
	{
		if (usedQueenNr == 8)
		{
			if (minNumberOfMoves > numberOfMoves)
			{
				minNumberOfMoves = numberOfMoves;
			}
			return;
		}
		
		for(int row = 0; row < 8; row++)
		{
			if (canPlaceQueen(usedRows, usedLeftDiagonals, usedRightDiagonals, row, usedQueenNr))
			{
				markUsedByQueen(usedRows, usedLeftDiagonals, usedRightDiagonals, row, usedQueenNr, 1);
				getSolution(usedRows, usedLeftDiagonals, usedRightDiagonals, rowPositions, usedQueenNr + 1, (rowPositions[usedQueenNr] != (row + 1) ? 1 : 0) + numberOfMoves);
				markUsedByQueen(usedRows, usedLeftDiagonals, usedRightDiagonals, row, usedQueenNr, -1);
			}
		}
	}
	
	public static boolean canPlaceQueen(int[] usedRows, int[] usedLeftDiagonals, int[] usedRightDiagonals, int row, int column)
	{
		return usedRows[row] == 0 && usedLeftDiagonals[column-row+7] == 0 && usedRightDiagonals[column+row] == 0;
	}
	
	public static void markUsedByQueen(int[] usedRows, int[] usedLeftDiagonals, int[] usedRightDiagonals, int row, int column, int value)
	{
		usedRows[row] += value;
		usedLeftDiagonals[column-row+7] += value;
		usedRightDiagonals[column+row] += value;
	}	
}