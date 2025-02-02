package com.adilaben.leetcode.prefixsum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContiguousArrayTest {

    @Test
    void findMaxLength() {
        ContiguousArray solution = new ContiguousArray();

        // Test Case 1: Basic case with a mix of 0s and 1s
        assertEquals(4, solution.findMaxLength(new int[]{0, 1, 0, 1}));

        // Test Case 2: Already balanced array
        assertEquals(6, solution.findMaxLength(new int[]{0, 1, 0, 1, 1, 0}));

        // Test Case 3: All zeros (should return 0)
        assertEquals(0, solution.findMaxLength(new int[]{0, 0, 0, 0}));

        // Test Case 4: All ones (should return 0)
        assertEquals(0, solution.findMaxLength(new int[]{1, 1, 1, 1}));

        // Test Case 5: Single element (should return 0)
        assertEquals(0, solution.findMaxLength(new int[]{0}));
        assertEquals(0, solution.findMaxLength(new int[]{1}));

        // Test Case 6: Alternating 0s and 1s
        assertEquals(2, solution.findMaxLength(new int[]{0, 1}));
        assertEquals(4, solution.findMaxLength(new int[]{0, 1, 0, 1}));

        // Test Case 7: Large input with a long balanced sequence
        assertEquals(12, solution.findMaxLength(new int[]{0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0}));
    }
}
