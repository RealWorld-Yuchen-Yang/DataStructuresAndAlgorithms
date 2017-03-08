package main.linearlist;

/**
 * Problem:
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its
 * next station(i+1). You begin the journey with an empty tank at one of the gas stations. 
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1. 
 * 
 * Analysis: 
 * 	Declare two variables, use sum to determine the current iteration's validity. 
 * 	Use total to determine if the whole array has a solution. 
 * 	If result exists, return the beginning index, otherwise return -1
 * @author yuchenyang
 *
 */
public class GasStation
{
	public static int canCompleteCircuit(int[] gas, int[] cost)
	{
		int total = 0;
		int j=-1;
		for(int i=0, sum=0; i<gas.length; i++)
		{
			sum +=gas[i]-cost[i];
			total +=gas[i]-cost[i];
			if(sum<0)
			{
				/*
				 * if this iteration's sum < 0, we can definately not start from it
				 * we will move on to check the next station
				 */
				j = i;//j is the step pointer
				sum = 0;
			}
		}
		return total >= 0 ? j +1:-1;
	}
}
