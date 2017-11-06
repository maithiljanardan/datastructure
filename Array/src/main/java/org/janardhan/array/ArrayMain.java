package org.janardhan.array;

/**
 * 
 *
 */
public class ArrayMain {

	public static void leftRotateArray(int[] arr, int shiftBy) {

		int arraySize = arr.length;

		int j, k, temp;

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

	public static int gCd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gCd(y, x % y);
	}

}
