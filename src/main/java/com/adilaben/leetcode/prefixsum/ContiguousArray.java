package com.adilaben.leetcode.prefixsum;

/*
    525. Contiguous Array : https://leetcode.com/problems/contiguous-array/description/
    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
*/

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }

            sum += nums[i];

            if(sum==0){
                res=i+1;
            }

            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return res;
    }
}
