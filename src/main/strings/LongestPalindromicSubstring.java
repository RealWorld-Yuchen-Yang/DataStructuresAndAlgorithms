package main.strings;

/**
 * Problem: 
 * 	Given a string s, find the longest palindromic substring in s
 * 	You may assume that the maximum length of s is 1000, 
 * 	and there exists one unique longest palindromic substring
 * 
 * Analysis: 
 * 	Since the palindromic string has recursive nature, 
 * 	we can use dynamic programming to solve this problem. 
 * 
 * 	step1: define f(i,j) as the longest palindromic between s's index i and j
 * 	step2: regularity experssions 
 * 		f(i,j) = 
 * 			case1: when i == j, 
 * 				   there is only 1 character in this case, then s[i] or s[j],
 *                 base case
 *                 
 * 			case2: when j = i+1, 
 *                 there are only 2 characters in this case, 
 *                 palindrome exists only if two endpoitns s[i] == s[j],  
 *                 base case
 * 
 * 			case3: when j > i+1, 
 * 				   there are more than 2 characters in this case,  	
 * 				   recursive definition: 
 * 				   palindrome exists only if two end points s[i] == s[j], 
 * 				   and the middle substring's palindrome is f(i+1, j-1) 
 * @author yuchenyang
 *
 */
public class LongestPalindromicSubstring
{
	public static String longestPalindrome(final String s)
	{
		final int n = s.length();
		final boolean[][] f = new boolean[n][n];
		int maxLen = 1, start = 0;
		
		for(int j=0; j<n; j++)
		{
			f[j][j] = true;
			for(int i= 0; i<j; i++)
			{
				f[i][j] = ((s.charAt(i) == s.charAt(j)) &&
						(j-i<2 || f[j+1][i-1]));
				
				/*
				 * if the current examing substring is palindrome 
				 * and its length is greater than the known max
				 */
				if(f[i][j] && maxLen<j-i+1)
				{
					maxLen = j-i+1;
					start = i;
				}
			}
		}
		
		return s.substring(start, start+maxLen);
	}
}
