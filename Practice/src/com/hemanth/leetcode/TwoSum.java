package com.hemanth.leetcode;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 22;

        int[] out_arr = twoSum(nums, target);
        for (int i=0; i<out_arr.length; i++) {
            System.out.println(out_arr[i]);
        }
    }
}
