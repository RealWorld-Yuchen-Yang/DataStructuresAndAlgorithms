package main.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Queen attack same rank, file,diagonally
 * 
 * Given n*n board place n queen on this board
 * so that they do not attack each other
 * @author yuchenyang
 *
 */
public class NQueens
{
	/**
	 * Entry method of solving NQueen problem
	 * @param n, dimension of the game board
	 * @return
	 */
	public static List<List<String>> solveNQueens(int n)
	{
		List<List<String>> result = new ArrayList();
		Position[] positions = new Position[n];//Position array's index is the row number of the Queen
		solve(0, positions, result, n);
		return result;
	}
	
	/**
	 * Recursive helper method of solving NQueen problem
	 * @param current, represents the current row
	 * @param positions, this is the position array which we use to store intermediate and final result of Queens
	 * @param result, is the final string representation of the board
	 * @param n, given dimension of the board
	 */
	private static void solve(int current, Position[] positions, List<List<String>> result, int n)
	{		
		//terminate condition, only when we have recursively called this method "#current" of times will we reach here
		if(n == current)
		{
			//then we transform the "positions" result information into "stringList" result information
			StringBuffer sb = new StringBuffer();
			List<String> stepResult = new ArrayList();//string representation of a row of " .(spaces) and Q(Queens) "
			for(Position p: positions)
			{
				/*
				 * again, we only need the col information to loop through the Queen positions,
				 * for we only have one Queen on each row 
				 */
				for(int i=0; i<n;i++)
				{
					if(p.col == i)
					{
						sb.append("Q");
					}
					else
					{
						sb.append(".");
					}
				}
				stepResult.add(sb.toString());
				sb = new StringBuffer();
			}
			result.add(stepResult);
			return;
		}
		
		/*
		 * Once this recursive method is firstly called, this is the first place to come
		 * In this outer for loop, 
		 * i represents column,
		 * we are trying to find one safe position, Position(current,i), 
		 * which will be added to the "positions" array
		 */
		for(int i=0; i<n; i++)
		{
			boolean foundSafe = true;
			for(int j=0; j<current; j++)
			{
				/*
				 *  positions now is storing previously found positions for old queens
				 *  since each row can have only 1 Queen,
				 *  we use j to represent the row of the Queen
				 *  and we skip comparing Position(curent, i) with previous queens
				 *  so we only need to extract the column information to compare queens
				 *  say:
				 *  position[j].col: stores Queen in Position(j, col),
				 *  position[j].row" stores Queen in Position(j, row)
				 */
				if(i == positions[j].col//potential Position(current,i) is on the same column with previous queen Position(j,col), so invalid
				|| Math.abs(i-current) == Math.abs(positions[j].col - positions[j].row))//potential position Position(current, i) is on same diagonal of a previous queen(position[j]), so invalid
					//Note we have no way of knowing previous Queen position[j]'s col number unless we read the stored information position[j].col from it
				{
					foundSafe = false;
					break;
				}
			}
			//only if we have found a safe position will we add it into the positions array
			if(foundSafe)
			{
				positions[current] = new Position(current, i);
				//we have finished examining the current row, so we can move on to the next row, recursively
				solve(current + 1, positions, result,n);
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		int inputN = 4;
		List<List<String>> result = solveNQueens(inputN);
		for(List<String> stepResult: result)
		{
			System.out.println("Result: ");
			for(String s: stepResult)
			{
				System.out.println(s);
			}
			System.out.println();
		}
	}
	
	
	public static class Position
	{
		int row;
		int col;
		public Position(int row, int col)
		{
			this.row = row;
			this.col = col;
		}
	}
}
