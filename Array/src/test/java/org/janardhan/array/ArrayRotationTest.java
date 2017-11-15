package org.janardhan.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ArrayRotationTest {

	@Test
	public void testIfPairExistsInRotatedSortedArray() {

		ArrayRotation arrayRotation = new ArrayRotation();
		int[] arr = { 11, 15, 6, 8, 10 };
		assertEquals(true, arrayRotation.ifPairExistsInSortedRotatedArray(arr, 16));
	}
}
