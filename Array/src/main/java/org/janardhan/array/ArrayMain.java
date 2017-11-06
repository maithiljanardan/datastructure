package org.janardhan.array;

/**
 * 
 *
 */
public class ArrayMain {

	/**
	 * This methods left rotates the array by shiftBy positions.
	 * 
	 * The inner loop increments in steps of d, and stops when it gets back to the
	 * starting point, i.e. a total span which is some multiple of n. That multiple
	 * is LCM(n, d). Thus the number of elements in that cycle is LCM(n, d) / d. The
	 * total number of such cycles is n / (LCM(n, d) / d), which is equal to GCD(n,
	 * d).
	 * 
	 * @param arr
	 * @param shiftBy
	 * @author janardhan 2017
	 */
	public static void leftRotateArray(int[] arr, int shiftBy) {

		int arraySize = arr.length;

		int j, k, temp;

		/*
		 
		 */
		for (int i = 0; i < gCd(arraySize, shiftBy); i++) {

			temp = arr[i];
			j = i;

			while (true) {

				k = j + shiftBy;
				if (k >= arraySize)
					k = k - arraySize;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}

			arr[j] = temp;
		}
	}

	/**
	 * 
	 * @param arr
	 * @param shiftBy
	 */
	public static void leftRotateArrayByReversal(int[] arr, int shiftBy) {

		reverserArray(arr, 0, shiftBy - 1);
		reverserArray(arr, shiftBy, arr.length - 1);
		reverserArray(arr, 0, arr.length - 1);

	}

	private static void reverserArray(int[] arr, int start, int end) {
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
	private static int gCd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gCd(y, x % y);
	}

}
