package main.depthfirstsearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * Additive number is a string whose digits can form additive sequence. A valid
 * additive sequence should contain at least three numbers. Except for the first
 * two. each subsequent number in the sequence must be the sum of the preceding
 * two.
 * 
 * Note: Numbers in the additive sequence cannot have leading 0s Given a string
 * containing only digits '0'-'9', write a function to determine if it's an
 * additive number.
 * 
 * Analysis: This is a multi-step problem, and only after examine the last
 * character can we determine the result, so this is a dfs problem. Considering
 * the state transform diagram, each time of the index changes, there will not
 * be duplicate cases. so the state transform graph is actually a tree.
 * 
 * @author yuchenyang
 *
 */
public class AdditiveNumber
{
	public static boolean isAdditiveNumber(String numString)
	{
		/*
		 * i starts from the second char of the numString, since i has at least
		 * its next number's length, i's length should be no more than half of
		 * numString's length
		 */
		for (int i = 1; i <= numString.length() / 2; i++)
		{
			// skipping: string with leading 0
			if (numString.charAt(0) == '0' && i > 1)
			{
				continue;
			}
			// after eliminating the corn cases, we can apply dfs
			for (int j = i + 1; j < numString.length(); j++)
			{
				if (numString.charAt(0) == '0' && j - 1 > 1)
				{
					continue;
				}
				if (dfs(numString, 0, i, j))
				{
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * [i,j) represents the first number [j,k) represents the second number
	 */
	private static boolean dfs(String numString, int i, int j, int k)
	{
		long num1 = Long.parseLong(numString.substring(i, j));
		long num2 = Long.parseLong(numString.substring(j, k));
		final String addition = String.valueOf(num1 + num2);// the third number
		if (!numString.substring(k).startsWith(addition))
		{
			return false;
		}
		if (k + addition.length() == numString.length())
		{
			return true;
		}
		return dfs(numString, j, k, k + addition.length());

	}

	@Test
	public void isAdditiveNumberTest()
	{
		String inputNumString = "199100199";
		Assert.assertTrue(isAdditiveNumber(inputNumString));
	}
}
