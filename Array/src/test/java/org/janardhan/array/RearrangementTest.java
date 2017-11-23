package org.janardhan.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class RearrangementTest {

	@Test
	public void test_rearrangeNegativePositionValInArray() {

		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int[] expected = { 4, -3, 5, -1, 6, -7, 2, 8, 9 };

		assertArrayEquals(expected, Rearrangement.rearrangeNegativePositionValInArray(arr));
	}

	@Test
	public void testSortOnAbsDiff() {
		// Rearrangement.sortOnAbsDiff(new int[] { 10, 5, 3, 9, 2 }, 7);
	}

	@Test
	public void testRearrrangeInMaxMinForm() {

		// assertArrayEquals(new int[] { 7, 1, 6, 2, 5, 3, 4 },
		// Rearrangement.rearrrangeInMaxMinForm(new int[] { 7, 6, 5, 4, 3, 2, 1 }));
		assertArrayEquals(new int[] { 9, 1, 8, 2, 7, 3, 6, 4, 5, },
				Rearrangement.rearrrangeInMaxMinForm(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }));
	}
}
