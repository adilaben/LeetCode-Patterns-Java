package com.adilaben.leetcode.prefixsum;

//https://leetcode.com/problems/range-sum-query-immutable/description/

/**
 * 303. Range Sum Query - Immutable:
 * Your RangeSumQueryImmutable object will be instantiated and called as such:
 * RangeSumQueryImmutable obj = new RangeSumQueryImmutable(nums);
 * int param_1 = obj.sumRange(left,right);
 */

public class RangeSumQueryImmutable {
    private int[] prefixSums;

    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        this.prefixSums = new int[n];
        this.prefixSums[0] = nums[0];

        for(int i=1;i<n;i++){
            this.prefixSums[i] = this.prefixSums[i-1] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        if(left==0){
            return this.prefixSums[right];
        }else{
            return this.prefixSums[right] - this.prefixSums[left -1];
        }
    }
}
