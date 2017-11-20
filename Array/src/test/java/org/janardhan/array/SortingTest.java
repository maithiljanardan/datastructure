package org.janardhan.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortingTest {

	@Test
	public void testInsertionSort() {

		int[] arr = { 10, 5, 3, 9, 2 };
		int[] expected = { 2, 3, 5, 9, 10 };
		assertArrayEquals(expected, Sorting.insertionSort(arr));
	}

}
