package main.bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent. 
 * A mapping of digit to letters(just like on the telephone buttons)
 * Results do not need to be in order
 * keyboard = {"","", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};//'0','1','2'
 * 
 * Analysis: 
 * Still use incremental construction approach
 * Time complexity O(3^n)
 * 
 * @author yuchenyang
 *
 */
public class LetterCombinationsOfAPhoneNumber
{
	private static final String[] keyboard = {"","", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};//'0','1','2'
	/**
	 * 
	 * @param digits, represents a sequence of inputs(digit chars) from the phone keyboard
	 * @return
	 */
	public static List<String> findCombinations(String digits)
	{
		List<String> result = new ArrayList();
		if(digits == null || digits.isEmpty())
		{
			return result;
		}
		dfs(digits, 0, "", result);
		return result;
	}
	
	/**
	 * 
	 * @param digits
	 * @param cur, represents the current index pointing to the input digits in one iteration
	 * @param stepResult
	 * @param result
	 */
	private static void dfs(String digits, int cur, String stepResult, List<String> result)
	{
		if(cur == digits.length())
		{
			result.add(stepResult);
			return;
		}
		
		final int curKeyIndex = digits.charAt(cur)-'0';
		final String keyCharSet = keyboard[curKeyIndex];//char set corresponds to one keyboard digit
		
		for(char c: keyCharSet.toCharArray())
		{
			dfs(digits, cur+1, stepResult+c,result);
		}
	}
	
public static void main(String[]  args)
{
	String digits = "23";
	List<String> combinationResult = findCombinations(digits);
	System.out.println(combinationResult.toString());
}
	
	
}
