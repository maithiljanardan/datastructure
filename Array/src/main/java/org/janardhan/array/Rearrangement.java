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

	/**
	 * This function finds a sorted subsequence of size 3
	 * 
	 * @param arr
	 */
	public static void find3Numbers(int[] arr) {

		int arrSize = arr.length;

		int max = arrSize - 1; // Index of maximum element from right side

		int min = 0; // Index of minimum element from left side

		int i;

		/*
		 * Create an array that will store index of a smaller element on left side. If
		 * there is no smaller element on left side, then smaller[i] will be -1.
		 */
		int[] smaller = new int[arrSize];

		smaller[0] = -1; // first entry will always be -1

		for (i = 1; i < arrSize; i++) {
			if (arr[i] <= arr[min]) {
				min = i;
				smaller[i] = -1;
			} else
				smaller[i] = min;
		}

		/*
		 * Create another array that will store index of a greater element on right
		 * side. If there is no greater element on right side, then greater[i] will be
		 * -1.
		 */
		int[] greater = new int[arrSize];

		greater[arrSize - 1] = -1; // last entry will always be -1

		for (i = arrSize - 2; i >= 0; i--) {
			if (arr[i] >= arr[max]) {
				max = i;
				greater[i] = -1;
			} else
				greater[i] = max;
		}

		// Now find a number which has both a greater number
		// on right side and smaller number on left side
		for (i = 0; i < arrSize; i++) {
			if (smaller[i] != -1 && greater[i] != -1) {
				System.out.print(arr[smaller[i]] + " " + arr[i] + " " + arr[greater[i]]);
				return;
			}
		}

		// If we reach number, then there are no such 3 numbers
		System.out.println("No such triplet found");
		return;
	}

	/**
	 * Returns the product of max product subarray. Assumes that the given array
	 * always has a subarray with product more than 1
	 */
	public static int maxSubarrayProduct(int arr[]) {

		int arrSize = arr.length;

		// max positive product ending at the current position
		int max_ending_here = 1;

		// min negative product ending at the current position
		int min_ending_here = 1;

		// Initialize overall max product
		int max_so_far = 1;

		/*
		 * Traverse through the array. Following values are maintained after the ith
		 * iteration: max_ending_here is always 1 or some positive product ending with
		 * arr[i] min_ending_here is always 1 or some negative product ending with
		 * arr[i]
		 */
		for (int i = 0; i < arrSize; i++) {
			/*
			 * If this element is positive, update max_ending_here. Update min_ending_here
			 * only if min_ending_here is negative
			 */
			if (arr[i] > 0) {
				max_ending_here = max_ending_here * arr[i];
				min_ending_here = Math.min(min_ending_here * arr[i], 1);
			}

			/*
			 * If this element is 0, then the maximum product cannot end here, make both
			 * max_ending_here and min_ending _here 0 Assumption: Output is alway greater
			 * than or equal to 1.
			 */
			else if (arr[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			}

			/*
			 * If element is negative. This is tricky max_ending_here can either be 1 or
			 * positive. min_ending_here can either be 1 or negative. next min_ending_here
			 * will always be prev. max_ending_here * arr[i] next max_ending_here will be 1
			 * if prev min_ending_here is 1, otherwise next max_ending_here will be prev
			 * min_ending_here * arr[i]
			 */
			else {
				int temp = max_ending_here;
				max_ending_here = Math.max(min_ending_here * arr[i], 1);
				min_ending_here = temp * arr[i];
			}

			// update max_so_far, if needed
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}

		return max_so_far;
	}

	/**
	 * Largest Sum Contiguous Subarray
	 * 
	 * @param a
	 * @return
	 */
	public static int maxSubArraySum(int a[]) {

		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}
}
