package org.janardhan.array;

/**
 * 
 * @author janardhan 2017
 */
public class Rotation {

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
	 *            The array to be rotated
	 * @param shiftBy
	 *            The position by which the array is to be shifted
	 * @author janardhan 2017
	 */
	public static void leftRotateArray(int[] arr, int shiftBy) {

		int arraySize = arr.length;

		int j, k, temp;

		/*
		 
		 */
		for (int i = 0; i < Misc.gCd(arraySize, shiftBy); i++) {

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

	/*
	 * For arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
	 */
	/*
	 * A = [1, 2] and B = [3, 4, 5, 6, 7]
	 */
	/*
	 * Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
	 */
	/*
	 * Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
	 */
	/*
	 * Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
	 * 
	 * @param arr
	 * 
	 * @param shiftBy
	 */
	public static void leftRotateArrayByReversal(int[] arr, int shiftBy) {

		Misc.reverserArray(arr, 0, shiftBy - 1);
		Misc.reverserArray(arr, shiftBy, arr.length - 1);
		Misc.reverserArray(arr, 0, arr.length - 1);

	}

	/**
	 * This method search an element in a sorted and rotated array.
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 * @param key
	 * @return
	 * @author janardhan 2017
	 */
	public static int binarySearchInSortedRotatedArray(int arr[], int l, int r, int key) {

		if (l > r)
			return -1;

		int mid = (l + r) / 2;
		if (arr[mid] == key)
			return mid;

		// If arr[l...mid] is sorted
		if (arr[l] <= arr[mid]) {

			if (key >= arr[l] && key <= arr[mid])
				return binarySearchInSortedRotatedArray(arr, l, mid - 1, key);

			return binarySearchInSortedRotatedArray(arr, mid + 1, r, key);
		}

		// If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		if (key >= arr[mid] && key <= arr[r])
			return binarySearchInSortedRotatedArray(arr, mid + 1, r, key);

		return binarySearchInSortedRotatedArray(arr, l, mid - 1, key);
	}

	/**
	 * This method checks if there exists a pair of element in the array whose sum
	 * equals the key.
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	public boolean ifPairExistsInSortedRotatedArray(int arr[], int key) {

		int arrSize = arr.length;

		int i;
		// Find the pivot element index
		for (i = 0; i < arrSize - 1; i++) {
			if (arr[i] > arr[i + 1])
				break;
		}

		// This position contains the lowest value element
		int l = (i + 1) % arrSize;

		// This position contains the highest value element
		int r = i;

		// Loop while the both pointers reach the same index
		while (l != r) {
			// If found, return true
			if (arr[l] + arr[r] == key)
				return true;

			// If sum is smaller than key then move the left pointer right
			if (arr[l] + arr[r] < key)
				l = (l + 1) % arrSize;

			// Else move the right pointer left
			else
				r = (arrSize + r - 1) % arrSize;
		}
		return false;
	}

	/**
	 * This method calcalute the max sum of i*arr[i] after every possible array
	 * rotation.
	 * 
	 * @param arr
	 * @return sum
	 */
	public int findMaxSumByRotatingArray(int[] arr) {

		// Find array sum and i*arr[i] with no rotation
		// Stores sum of arr[i]
		int arrSum = 0;

		// Stores sum of i*arr[i]
		int currVal = 0;

		for (int i = 0; i < arr.length; i++) {
			arrSum = arrSum + arr[i];
			currVal = currVal + (i * arr[i]);
		}

		// Initiali ze result as 0 rotation sum
		int maxVal = currVal;

		// Try all rotations one by one and find
		// the maximum rotation sum.
		for (int j = 1; j < arr.length; j++) {
			currVal = currVal + arrSum - arr.length * arr[arr.length - j];
			if (currVal > maxVal)
				maxVal = currVal;
		}

		// Return result
		return maxVal;

	}
}
