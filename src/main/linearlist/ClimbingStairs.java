package main.linearlist;

/**
 * Problem:
 * 	You are climbing a stair case, It takes n steps to reach to the top
 * 	Each time you either climb 1 or 2 steps. 
 * 	In how many distinct ways can you climb to the top?
 * 
 * Analysis: 
 * 	General expression: 
 * 		to climb n steps,
 * 		you can either go from (n-2) by 2 steps
 * 		or go from (n-1) by 1 step
 * 		So basically, it is a Fibonacci
 * 		
 * @author yuchenyang
 *
 */
public class ClimbingStairs
{
	public static int climbStairs(int n)
	{
		//Base cases:
		if(n<=0)
		{
			return 0;
		}
		if(n==1)
		{
			return 1;
		}
		if(n==2)
		{
			/*
			 * There are two ways to climb the stairs. 
			 * One solution is one step by another
			 * The other is two steps at one time. 
			 */
			return 2;
		}
		
		int oneStepBefore = 2;
		int twoStepsBefore = 1;
		int allWays = 0;
		for(int i=2; i<n; i++)
		{
			allWays = oneStepBefore+twoStepsBefore;
			twoStepsBefore = oneStepBefore;
			oneStepBefore = allWays;
		}
		return allWays;
	}

}
