package org.janardhan.array;

/**
 * 
 * @author janardhan 2017
 *
 */
public class Misc {

	/**
	 * This method swap two elements in an array
	 * 
	 * @param arr
	 *            The array whose elements are to be swapped
	 * @param i
	 *            the first element
	 * @param j
	 *            the second element
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * This method reverses an array
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void reverserArray(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}

	/**
	 * This method calculates the gcd for two given input numbers
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @author janardhan 2017
	 */
	public static int gCd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gCd(y, x % y);
	}

}
