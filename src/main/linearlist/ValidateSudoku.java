package main.linearlist;

import java.util.Arrays;

/**
 * Problem:
 * 	Determine if a Sudoku is valid. 
 * 	That is if every row/column/3x3 boxes contains 1~9
 * 	The Sudoku board could be partially filled, 
 * 	where empty cells are filled with the '.'
 * 	
 * @author yuchenyang
 *
 */
public class ValidateSudoku
{
	public boolean isValidSudoku(char[][] board)
	{
		boolean[] used = new boolean[9];//if digit 1~9 has been used
		
		//check rows and columns
		for(int i=0; i<9; i++)
		{
			//check rows
			Arrays.fill(used, false);
			for(int j=0; j<9; i++)
			{
				if(!validCell(board[i][j]), used)
				{
					return false;
				}
			}
			
			//check columns
			Arrays.fill(used, false);
			for(int j=0; j<9; j++)
			{
				if(!validCell(board[j][i]), used)
				{
					return false;
				}
			}
		}
		
		//check boxes
		for(int row=0; row<3; row++)
		{
			for(int col=0; col<3; col++)
			{
				Arrays.fill(used, false);
				for(int i=row*3; i<row*3+3; i++)
				{
					for(int j=col*3; j<col*3+3;j++)
					{
						if(!validCell(board[i][j], used))
						{
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	private static boolean validCell(char ch, boolean[] used)
	{
		if(ch == '.') 
		{
			return true;
		}
		
		if(used[ch-'1'])
		{
			//if the current char number has been used, it is no longer valid
			return false;
		}
		//assign true to used[ch-'1'], and return true
		return used[ch-'1'] = true;
	}
}
