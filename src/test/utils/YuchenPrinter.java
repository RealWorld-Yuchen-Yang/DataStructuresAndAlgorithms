package test.utils;
public class YuchenPrinter
{
	public static void printArray(int[] array, String name)
	{
		if(array != null && array.length != 0)
		{
			System.out.print("Array-"+name+": {");
			for(int i=0; i<array.length; i++)
			{
				System.out.print(array[i]);
				if(i == array.length -1)
				{
					System.out.print("}\n");
				}
				else
				{
					System.out.print(",");
				}
			}
		}
	}
}
