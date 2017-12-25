package main.sorting.bubblesort;

/**
 * Problem: use bubble sort to sort an integer array in ascending order
 * <p>
 * Analysis:
 * 1. time complexity O(n^2)
 * 2. in each iteration (i),
 * comparison starts from the first element, and ends with the (n-1-i) element
 * since, the gist of this algorithm is comparing each adjacent elements,
 * if they violate the order, swap them,
 * and in each iteration (i+1), there will be i elements that have already been sorted sitting at the end of the array by previous i iterations
 *
 *
 * Optimized Implementation:
 * The above function always runs O(n^2) time even if the array is sorted.
 * It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        final int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j+1);
            }
        }
    }

    // An optimized version of Bubble Sort
    public static void optimizedBubbleSort(int arr[])
    {
        int i, j;
        boolean swapped;
        int n=arr.length;
        for (i = 0; i < n-1; i++)
        {
            swapped = false;
            for (j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }

            // IF no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /* Prints the array */
    private static void printArray(String msg, int arr[]) {
        System.out.print(msg);
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        printArray("Before sorting, arr[]:", arr);
//        sort(arr);
        System.out.print("OptimizedSolution ");
        optimizedBubbleSort(arr);
        printArray("After sorting, arr[]:", arr);
    }


}