package org.janardhan.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ArrayRearrangementTest {

	@Test
	public void test_rearrangeNegativePositionValInArray() {

		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int[] expected = { 4, -3, 5, -1, 6, -7, 2, 8, 9 };

		assertArrayEquals(expected, ArrayRearrangement.rearrangeNegativePositionValInArray(arr));
	}
}
