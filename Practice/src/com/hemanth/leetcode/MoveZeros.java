package com.hemanth.leetcode;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int insert_pos = -9090;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0 && count == 0) {
                insert_pos = i;
                count++;
            }
            else if (nums[i] != 0 && insert_pos != -9090) {
                nums[insert_pos] = nums[i];
                nums[i] = 0;
                insert_pos++;
                count++;
            }
        }

        for (int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
    }
}
