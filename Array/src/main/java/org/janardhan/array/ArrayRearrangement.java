package org.janardhan.array;

public class ArrayRearrangement {

	public static int[] rearrangeNegativePositionValInArray(int[] arr) {

		int arrSize = arr.length;
		int i = -1;
		int temp;

		/*
		 * Parition the array viz. Negative to the left side and Positive to the right
		 * side as in Quick Sort
		 */
		for (int j = 0; j < arrSize; j++) {

			if (arr[j] < 0) {
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		/*
		 * pos points to the first positive integer and neg to the first negative
		 * integer. Swap till the negative pointer remains to the left of positive
		 * pointer. Increment negative pointer by two and positive by one
		 */
		int pos = i + 1, neg = 0;

		while (pos < arrSize && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}
		return arr;
	}
}
