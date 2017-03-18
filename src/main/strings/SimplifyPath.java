package main.strings;

import java.util.Stack;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Problem: 
 *  Given an absolute path for a file (UNIX-style), simiplify it. 
 * 
 * Examples: 
 * 	1. path = "/home/" ==> "/home"
 * 	2. path = "/a/./b/../../c/" ==> "/c"
 * 
 * Corner Cases: 
 * 	1. path = "/../" ==> "/"
 * 	2. (path contains multiple slashes) path = "/home//foo/" ==> "/home/foo"
 * 
 * Analysis: 
 * 	based on the nature of simplifying the paths
 * 	I should use a stack to push/pop path elements, 
 * 	the most concern should be when to "pop" elements 
 * 
 * @author yuchenyang
 *
 */
public class SimplifyPath
{	
	public static void main(String[] args)
	{
		String inputPath = "/a/./b/../../c/";
		String result = simplifyPath(inputPath);
		
		System.out.println(result);
	}
	
	public static String simplifyPath(String path)
	{
		Stack<String> dirs = new Stack<>();
		
		for(int i=0; i<path.length();)
		{
			i++;
			
			/*
			 * In path.indexOf("/", i)
			 * 	"/": the substring that we are looking for in path
			 * 	i: starting index in path
			 */
			int j = path.indexOf("/", i);
			if (j < 0)
			{
				//not found the desired "/" substring, set j to end condition
				j = path.length();
			}
			
			final String dir = path.substring(i, j);//the current examining dir segment(excluding the end "/")
			
			//MainLogic1, empty string or . will not have meaningful impact on the final result
			if(!dir.isEmpty() && !dir.equals("."))//
			{
				if(dir.equals(".."))
				{
					//MainLogic2, when encountering "..", pop the previous dir segment
					if(!dirs.isEmpty())
					{
						dirs.pop();//move up one level
					}
				}
				else
				{
					dirs.push(dir);
				}
				
				i = j;//update i
			}
		}
		
		//after parsing the whole input path, return simplified result
		StringBuilder result = new StringBuilder();
		if(dirs.isEmpty())
		{
			result.append("/");
		}
		else
		{
			for(final String dir: dirs)
			{
				result.append("/").append(dir);
			}
		}
		return result.toString();
	}
}	
