package org.janardhan.array;

/**
 * 
 * @author janardhan 2017
 *
 */
public class Sorting {

	public static void quickSort(int[] arr) {

	}

	/**
	 * 
	 * @param arr
	 */
	public static int[] insertionSort(int[] arr) {

		int arrSize = arr.length;

		int i = 1;
		while (i < arrSize) {

			int j = i;

			while (j > 0 && arr[j - 1] > arr[j]) {

				Misc.swap(arr, j - 1, j);
				j--;
			}
			i++;

		}
		
		return arr;
	}
}
