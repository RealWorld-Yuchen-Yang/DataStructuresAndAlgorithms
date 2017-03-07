package main.linearlist;

/**
 * Given a number represented as an array of digits, plus one to the number
 * @author yuchenyang
 *
 */
public class PlusOne
{
	public static int[] plusOne(int[] digits)
	{
		return add(digits, 1);
	}
	
	private static int[] add(int[] digits, int digit)
	{
		int carry = digit;
		for(int i=digits.length-1; i>=0; i--)
		{
			digits[i] += carry;//sum of the input value and the current digit
			carry = digits[i]/10;//calculate the sum's carry value
			digits[i]%=10;//calculate the digit left to store in the current index i
		}
		
		if(carry > 0)
		{
			//if the biggest digit has a carry
			int[] tmp = new int[digits.length+1];
			System.arraycopy(digits, 0, tmp, 1, digits.length);
			tmp[0] = carry;
			return tmp;
		}
		else
		{
			//if no carry
			return digits;
		}
	}
}
