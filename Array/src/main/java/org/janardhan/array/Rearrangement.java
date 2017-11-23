package org.janardhan.array;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author janardhan 2017
 *
 */
public class Rearrangement {

	/**
	 * This method changes the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], to
	 *
	 * [9,-7, 8, -3, 5, -1, 2, 4, 6]
	 *
	 * @param arr
	 * @return
	 */
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

	/**
	 * This method rearranges Input: arr[] = {3, 6, 5, 10, 7, 20}
	 *
	 * Output: arr[] = {6, 3, 10, 5, 20, 7}
	 *
	 * i.e. arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]
	 *
	 * The algorithm is to visited even indexes i.e. 0,2 and check if the the
	 * current index is smaller than previous and greater than next , swap them
	 *
	 *
	 */
	public static void sortArrayInWaveForm(int[] arr) {

		int arrSize = arr.length;

		for (int i = 0; i < arrSize; i += 2) {
			// If current even element is smaller than previous
			if (i > 0 && arr[i - 1] > arr[i])
				Misc.swap(arr, i - 1, i);

			// If current even element is smaller than next
			if (i < arrSize - 1 && arr[i] < arr[i + 1])
				Misc.swap(arr, i, i + 1);
		}

	}

	/**
	 * Given an array of n distinct elements and a number x,this method prints array
	 * elements according to the absolute difference with x, i. e., element having
	 * minimum difference comes first and so on.
	 *
	 * If two or more elements are at equal distance arrange them in same sequence
	 * as in the given array.
	 *
	 *
	 * @param arr
	 * @param val
	 */
	public static void sortOnAbsDiff(int[] arr, int val) {

		int arrSize = arr.length;

		TreeMap<Integer, ArrayList<Integer>> multiMap = new TreeMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < arrSize; i++) {

			ArrayList<Integer> arrayList;

			// If the absolute difference is not present in the map, create a new list and
			// add the element. Else get the list and append the element
			if (multiMap.get(Math.abs(val - arr[i])) == null) {

				arrayList = new ArrayList<Integer>();
				arrayList.add(arr[i]);

			} else {
				arrayList = multiMap.get(Math.abs(val - arr[i]));
				arrayList.add(arr[i]);

			}

			multiMap.put(Math.abs(val - arr[i]), arrayList);
		}

		for (Map.Entry<Integer, ArrayList<Integer>> entry : multiMap.entrySet()) {

			if (entry.getValue().size() > 1) {
				for (Integer i : entry.getValue()) {
					System.out.print(i);
				}
			} else {
				System.out.print(entry.getValue().get(0));
			}
		}
	}

	/**
	 * Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}
	 *
	 * lowVal = 14, highVal = 20
	 *
	 * Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}
	 *
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] threeWayPartition(int[] arr, int low, int high) {

		int arrSize = arr.length;

		// Initialize ext available positions for
		// smaller (than range) and greater lements
		int start = 0, end = arrSize - 1;

		// Traverse elements from left
		for (int i = 0; i < end;) {

			// If current element is smaller than
			// range, put it on next available smaller
			// position.

			if (arr[i] < low) {

				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
				i++;

			}

			// If current element is greater than
			// range, put it on next available greater
			// position.
			else if (arr[i] > high) {

				int temp = arr[end];
				arr[end] = arr[i];
				arr[i] = temp;
				end--;

			}

			else
				i++;
		}

		return arr;
	}

	/**
	 * This method rearranges an array such that the max and min numbers come
	 * adjacent
	 *
	 * Input : arr[] = { 7, 6, 5, 4, 3, 2, 1 }
	 *
	 * Output : arr[] = {7, 1, 6, 2, 5, 3, 4}
	 *
	 */
	public static int[] rearrrangeInMaxMinForm(int[] arr) {

		int arrSize = arr.length;

		// Auxiliary array to hold modified array
		int[] temp = new int[arrSize];

		// Indexes of smallest and largest elements
		// from remaining array.
		int l = 0, h = arrSize - 1;

		// To indicate whether we need to copy remaining
		// largest or remaining smallest at next position
		boolean flag = true;

		// Store result in temp[]
		for (int i = 0; i < arrSize; i++) {
			if (flag)
				temp[i] = arr[h--];
			else
				temp[i] = arr[l++];

			flag = !flag;
		}
		return arr;
	}

}
