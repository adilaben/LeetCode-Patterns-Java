package com.adilaben.leetcode.prefixsum;

/*
* The prefix sum at each index i stores the cumulative sum of the array from 0 to i.
* For a query to get the sum from index i to j, we can use the formula: [ {sumRange}(i, j) = {prefixSum}[j] - {prefixSum}[i-1] ]
* This reduces the time complexity of each query to O(1).
*/

public class PrefixSum {

    // Method to compute prefix sum array in 0(n)
    public static int[] computePrefixSum(int[] arr) {
        int n = arr.length;

        // Handle edge case of empty array
        if (arr == null || n == 0) {
            return new int[0];  // Return empty array if input is empty
        }

        int[] prefixSum = new int[n];

        prefixSum[0] = arr[0];

        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }
        return prefixSum;
    }

    // Method to get range sum in O(1) using prefix sum array
    public static int getRangeSum(int[] prefixSum, int start, int end) {
        // Check if the input is valid
        if (prefixSum == null || prefixSum.length == 0 || start < 0 || end >= prefixSum.length || start > end) {
            throw new IllegalArgumentException("Invalid range or empty array");
        }

        if(start == 0){
            return prefixSum[end];
        }
        return prefixSum[end] - prefixSum[start-1];
    }
}
