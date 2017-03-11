package main.linearlist;

/**
 * Problem: 
 * 	John Horton Conway's Game of Life. 
 * 	Given a board with m*n cells, 
 * 	each cell has an initial state live(1) or dead(0).
 * 	Each cell interacts with its eight neighbours(horizontal, vertical, diagonal)
 * 	using the following rules: 
 * 	1. two situations may cause death: 
 * 		1.1 die of loneliness: if <2 neighbors are alive(1)
 * 		1.2 die of over population: if >3 neighbors are alive(1)
 * 	2. one situation of rebirth: 
 * 		if exactly 3 neighbors are alive
 *  3. the left over conditions are if 2 or 3 neighbors are alive,
 *     then the current cell live on to the next generation
 *  
 *  Follow up: 
 *	1. Could you solve it in-place? Remember that the board needs to be updated at the same time: 
 *		You can not update some cells first and then use their updated values to update other cells
 *	2. In this question, we represent the board using a 2D array. 
 *     In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. 
 *     How would you address these problems?
 *     
 *     Analysis: 
 *     	The difficulty remains in the request that we need to update the board in-please. 
 *     	It is because if we update one cell, its original is overridden. 
 *     	However, its neighbor's update still depends on such original value. 
 *     	
 *     	Solution can be done by encoding the transformation of cell states:
 *     	condition0: deadCell -> deadCell
 *     	condition1: aliveCell -> aliveCell
 *     	condition2: aliveCell -> deadCell
 *     	condition3: deadCell -> aliveCell
 *     	By doing this encoding,
 *     	we are store the previous and current state of the board at the same time
 *     
 *     	to finally get the desired result of the next state of the board, 
 *     	we can decoding it by %(mode) the current cell value
 *     	0, 2 --> dead(0)
 *     	1, 3 --> alive(1)
 * @author yuchenyang
 *
 */
public class GameOfLife
{
	public static void gameOfLife(int[][] board)
	{
		final int m = board.length;
		final int n = board[0].length;
		
		/*
		 * clockwise, start from upper-left corner
		 * these are relative x, y indices of the current cell(x, y)
		 * 
		 *  dx:                  dy: 
		 *  	-1 | -1| -1      	-1 | 0 | 1
		 *  	------------        -----------
		 *  	 0 | x |  0         -1 | y | 1
		 *      ------------        -----------
		 *       1 | 1 |  1         -1 | 0 | 1
		 * 
		 */
		final int[] dx = new int[]{-1,-1,-1,0,1,1,1,0};//difference x
		final int[] dy = new int[]{-1,0,1,1,1,0,-1,-1};//difference y
		
		//encoding
		for(int i=0; i<m; i++)
		{
			for(int j=0; i<n; j++)
			{
				//Step1: check the previous encoded condition
				int live = 0;//
				for(int k=0; k<8; k++)
				{
					final int x = i+dx[k];
					final int y = j+dy[k];
					if(x>-1 && x<m && y>-1 && y<n//within board
					&&(board[x][y] == 1 || board[x][y] ==2))
					{
						live++;//live represent the number of live before state change
					}
				}
				
				/*
				 * Step2: update the cells' current condtion
				 * Cell state transformation depends on 
				 * 	1. previous state
				 * 	2. current neighbor condition 
				 */
				if(board[i][i] == 0 && live == 3)//the current cell was dead and it has 3 alive neighbors
				{
					board[i][j] = 3;//rebirth
				}
				else if(board[i][j]==1 && (live < 2 || live > 3))//the current cell was dead and its alive neighbors are either <2 or >3
				{
					board[i][j] =2;//alive->death
				}
			}
		}
		
		//decoding
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				board[i][j] %= 2;//store only the current alive/dead information in the result
			}
		}
	}
}
