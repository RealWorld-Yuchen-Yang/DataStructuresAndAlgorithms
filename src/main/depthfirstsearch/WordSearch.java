package main.depthfirstsearch;

/**
 * Given a 2D board and a word, find if the word exists in the grid
 * The word can be constructed from letters of sequentially adjacent cell,
 * where adjacent cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once
 * @author yuchenyang
 *
 */
public class WordSearch
{
	public boolean exists(char[][] board, String word)
	{
		final int m = board.length;
		final int n = board[0].length;
		
		boolean[][] visited = new boolean[m][n];//helper 2D array
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(dfs(board, word, 0, i, j, visited))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param board
	 * @param word
	 * @param index, pointer to the "word's letter"
	 * @param i, rowIndex of the currently examining board cell board[i][j]
	 * @param j, columnIndex of the currently examining board cell board[i][j]
	 * @param visited
	 * @return
	 */
	private static boolean dfs(char[][] board, String word, 
			int index, int i, int j, boolean[][] visited)
	{
		if(index == word.length())
		{
			//word is found
			return true;
		}
		
		if(i<0 || j<0 || i>=board.length || j>=board[0].length)
		{
			//current cell pointer (i,j) is out of board
			return false;
		}
		
		if(visited[i][j])
		{
			//cut "crossing path"
			return false;
		}
		
		if(board[i][j] != word.charAt(index))
		{
			//start point of char discrepancy
			return false;
		}
		
		//nothing prevents from trying the current cell now, so try it
		visited[i][j] = true;
		//move on to the next step based on the current movement
		boolean nextStepValid =
				dfs(board, word, index+1, i-1, j, visited)
				|| dfs(board, word, index+1, i+1, j, visited)
				|| dfs(board, word, index+1, i, j-1, visited)
				|| dfs(board, word, index+1, i-1, j+1, visited);
		visited[i][j] = false;//restore state
		return nextStepValid;
		
		
		
		
		
		
		
		
		
		
		
	}
}
