package org.janardhan.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class RotationTest {

	@Test
	public void testIfPairExistsInRotatedSortedArray() {

		Rotation arrayRotation = new Rotation();
		int[] arr = { 11, 15, 6, 8, 10 };
		assertEquals(true, arrayRotation.ifPairExistsInSortedRotatedArray(arr, 16));
	}
}
