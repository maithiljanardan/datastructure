package org.janardhan.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testIfPairExistsInRotatedSortedArray() {

		ArrayMain arrayMain = new ArrayMain();
		int[] arr = { 11, 15, 6, 8, 10 };
		assertEquals(true, arrayMain.ifPairExistsInSortedRotatedArray(arr, 16));
	}
}
