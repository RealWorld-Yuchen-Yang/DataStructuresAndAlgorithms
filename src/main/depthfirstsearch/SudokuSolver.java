package main.depthfirstsearch;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells
 * (Principles: 
 * 		1. gameboard size is 9x9
 * 		2. each row/column/3x3boxes should have digits from 1-9)
 * 
 * Solution is brute force depth-first-search
 * @author yuchenyang
 *
 */
public class SudokuSolver
{
	public static void solveSudoku(char[][] board)
	{
		solveSudukuHelper(board);
	}
	
	private static boolean solveSudukuHelper(char[][] board)
	{
		for(int i=0; i<9;i++)
		{
			for(int j=0; j<9; j++)
			{
				if(board[i][j] == '.')// '.' means space
				{
					for(int k=0; k<9; k++)
					{
						//brute force generate 0~9 for each empty cell, try one at a time, then restore state
						board[i][j] = Character.forDigit(k+1, 10);
						if(isValid(board, i, j) && solveSudukuHelper(board))
						{
							return true;
						}
						board[i][j] = '.';//restore state
					}
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * After brute-forcely adding a number to cell board[x][y] of the existing board,
	 * check its(the board's) current validity,
	 * that is if new cell board[x][y] violates each row/column/its 3x3box
	 * @param board, this input board is already added the "trial number"
	 * @param x, the newly added number's row number
	 * @param y, the newly added number's column number
	 * @return
	 */
	private static boolean isValid(char[][] board, int x, int y)
	{
		int i;
		int j;
		for(i=0; i<9; i++)
		{
			if(i!=x && board[i][y] == board[x][y])
			{
				//in column y, the newly added board[x][y] duplicate with an existing cell board[i][y]
				return false;
			}
		}
		for(j=0;j<9;j++)
		{
			if(j!=y && board[x][j] == board[x][y])
			{
				//in row x, the newly added board[x][y] duplicate with an existing cell board[x][j]
				return false;
			}
		}
		for(i=3*(x/3);i<3*(x/3+1);i++)
		{
			for(j=3*(y/3);j<3*(y/3+1);j++)
			{
				if((i!=x||j!=y)
				&& board[i][j] == board[x][y])
				{
					return false;
				}
			}
		}
		return true;
	}
}
