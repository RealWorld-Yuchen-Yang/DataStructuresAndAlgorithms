package test.sorting.mergesort;

import org.junit.Test;

import main.sorting.mergesort.MergeTwoSortedArrays;
import test.utils.YuchenPrinter;

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
		YuchenPrinter.printArray(inputA, "InputA");
		YuchenPrinter.printArray(inputB, "InputB");
		MergeTwoSortedArrays.merge(inputA, inputM, inputB, inputN);
		YuchenPrinter.printArray(inputA, "After Merge Sort");
	}
	
	private void initializeArrayWithFactor(int[] array, int number, int factor)
	{
		for(int i=0; i<number; i++)
		{
			array[i] = factor*i;
		}
	}
	

	
	
}
