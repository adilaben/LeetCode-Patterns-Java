package com.adilaben.leetcode.prefixsum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RangeSumQueryImmutableTest {

    private RangeSumQueryImmutable rangeSumQuery;

    @BeforeEach
    void setUp() {
        // Initialize the RangeSumQueryImmutable with some input array
        int[] nums = {1, 2, 3, 4, 5};
        rangeSumQuery = new RangeSumQueryImmutable(nums);
    }

    @Test
    void sumRangeTest() {
        // Test cases for the sumRange function

        // Sum of elements from index 0 to 2 (1 + 2 + 3)
        assertEquals(6, rangeSumQuery.sumRange(0, 2));

        // Sum of elements from index 1 to 4 (2 + 3 + 4 + 5)
        assertEquals(14, rangeSumQuery.sumRange(1, 4));

        // Sum of elements from index 2 to 3 (3 + 4)
        assertEquals(7, rangeSumQuery.sumRange(2, 3));

        // Sum of only the first element (1)
        assertEquals(1, rangeSumQuery.sumRange(0, 0));

        // Sum of the entire array (1 + 2 + 3 + 4 + 5)
        assertEquals(15, rangeSumQuery.sumRange(0, 4));
    }
}
