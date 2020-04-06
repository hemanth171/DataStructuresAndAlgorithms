package com.hemanth.leetcode;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int out = 0;
        for (int i=0; i<nums.length; i++) {
            out = out ^ nums[i];
        }

        return out;
    }

    public static void main(String[] args) {
        int[] in = {2,5,7,3,2,5,3};
        System.out.println(singleNumber(in));
    }
}
