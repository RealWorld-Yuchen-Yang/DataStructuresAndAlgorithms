package main.stack;

import java.util.Stack;

/**
 * Problem: 
 * 	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 	Valid operators are +, -, *, /.
 * 	Each operand may be an integer or another expression. 
 * 	
 * Example: 
 * 	["2", "1", "+", "3", "*"] -> ((2+1)*3) -> 9
 * 	["4", "13", "5", "/", "+"] ->(4+(13/5)) ->6
 * @author yuchenyang
 *
 */
public class EvaluateReversePolishNotation
{
	//Time Complexity O(n), Space Complexity O(logn)
	public int stackInterativeSolution(String[] tokens)
	{
		Stack<String> s = new Stack();
		for(String token: tokens)
		{
			/*
			 * Main logic of the Reverse Polish Expression evaluation
			 * if the current token is an operand, 
			 * 		push it onto the stack
			 * if the current token is an operator, 
			 * 		pop 2 operands from the stack,
			 * 		calculate the two operands by using the current operator
			 * 		push the result back onto the stack
			 */
			
			if(!isOperator(token))
			{
				s.push(token);
			}
			else
			{
				int operand1 = Integer.parseInt(s.pop());
				int operand2 = Integer.parseInt(s.pop());
				switch(token.charAt(0))
				{
				case '+':
					operand1+=operand2;
					break;
				case '-':
					operand1-=operand2;
					break;
				case '*':
					operand1*=operand2;
					break;
				case '/':
					operand1/=operand2;
					break;
				}
				s.push(String.valueOf(operand1));
			}
		}
		return Integer.parseInt(s.peek());
	}
	
	private static boolean isOperator(final String op)
	{
		return op.length() == 1 && OPERANDS.indexOf(op) != -1;
	}
	
	private static final String OPERANDS = "+-*/";
}
