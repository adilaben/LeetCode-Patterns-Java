package com.adilaben.leetcode.prefixsum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrefixSumTest {

    private PrefixSum prefixSum;

    @BeforeEach
    void setUp() {
        prefixSum = new PrefixSum(); // Initialize the PrefixSum instance before each test
    }

    @AfterEach
    void tearDown() {
        prefixSum = null; // Clean up after each test
    }

    @Test
    void computePrefixSum() {
        // Test 1: Compute prefix sum for a sample array
        int[] input = {3, 1, 4, 1, 5, 9, 2};
        int[] expected = {3, 4, 8, 9, 14, 23, 25};
        int[] result = prefixSum.computePrefixSum(input);
        assertArrayEquals(expected, result, "Prefix sum computation failed.");

        // Test 2: Empty array
        input = new int[]{};
        expected = new int[]{};
        result = prefixSum.computePrefixSum(input);
        assertArrayEquals(expected, result, "Prefix sum for an empty array failed.");

        // Test 3: Single-element array
        input = new int[]{5};
        expected = new int[]{5};
        result = prefixSum.computePrefixSum(input);
        assertArrayEquals(expected, result, "Prefix sum for a single-element array failed.");
    }

    @Test
    void getRangeSum() {
        // Setup prefix sum array for a known input
        int[] prefixArray = {3, 4, 8, 9, 14, 23, 25};

        // Test 1: Sum from index 2 to 5
        int result = prefixSum.getRangeSum(prefixArray, 2, 5);
        assertEquals(19, result, "Range sum from index 2 to 5 should be 19.");

        // Test 2: Sum from index 0 to 3
        result = prefixSum.getRangeSum(prefixArray, 0, 3);
        assertEquals(9, result, "Range sum from index 0 to 3 should be 9.");

        // Test 3: Sum from index 4 to 4 (single element)
        result = prefixSum.getRangeSum(prefixArray, 4, 4);
        assertEquals(5, result, "Range sum from index 4 to 4 should be 5.");

        // Test 4: Sum from index 0 to 6 (entire array)
        result = prefixSum.getRangeSum(prefixArray, 0, 6);
        assertEquals(25, result, "Range sum from index 0 to 6 should be 25.");

        // Test 5: invalid range (throws exception)
        assertThrows(IllegalArgumentException.class, () -> {
            prefixSum.getRangeSum(prefixArray, -1, 5);
        }, "Invalid start index should throw exception.");
        assertThrows(IllegalArgumentException.class, () -> {
            prefixSum.getRangeSum(prefixArray, 2, 10);  // Out of bounds
        }, "Invalid end index should throw exception.");
    }
}
