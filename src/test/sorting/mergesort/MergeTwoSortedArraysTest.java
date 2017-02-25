package test.sorting.mergesort;

import org.junit.Test;

import main.sorting.mergesort.MergeTwoSortedArrays;

public class MergeTwoSortedArraysTest
{
	@Test
	public void mergeTest()
	{
		int inputM = 6;
		int inputN = 5;
		int sizeA = inputM+inputN;
		int[] inputA = new int[sizeA];
		int[] inputB = new int[inputM];
		initializeArrayWithFactor(inputA, inputM, 3);
		initializeArrayWithFactor(inputB, inputN, 2);
		printArray(inputA, "InputA");
		printArray(inputB, "InputB");
		MergeTwoSortedArrays.merge(inputA, inputM, inputB, inputN);
		printArray(inputA, "After Merge Sort");
	}
	
	private void initializeArrayWithFactor(int[] array, int number, int factor)
	{
		for(int i=0; i<number; i++)
		{
			array[i] = factor*i;
		}
	}
	
	private void printArray(int[] array, String name)
	{
		if(array != null && array.length != 0)
		{
			System.out.print("Array-"+name+": ");
			for(int i=0; i<array.length; i++)
			{
				System.out.print(array[i]);
				if(i == array.length -1)
				{
					System.out.print("\n");
				}
				else
				{
					System.out.print(",");
				}
			}
		}
	}
	
	
}
