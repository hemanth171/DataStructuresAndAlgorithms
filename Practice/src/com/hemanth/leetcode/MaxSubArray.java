package com.hemanth.leetcode;

public class MaxSubArray {

    public static int maxSubArray(int[] arr) {
        int max = 0;
        for (int i=0; i<arr.length; i++) {
            int count = 0;
            for (int j=i; j<arr.length; j++) {
                count = count + arr[j];
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }

    public static int midMaxArr(int[] arr, int l, int m, int r) {
        int sum = 0;
        int left_sum_max = Integer.MIN_VALUE;
        for (int i=m; i>=l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum_max) {
                left_sum_max = sum;
            }
        }

        sum = 0;
        int right_sum_max = Integer.MIN_VALUE;
        for (int i=m+1; i<=r; i++) {
            sum = sum + arr[i];
            if (sum > right_sum_max) {
                right_sum_max = sum;
            }
        }
        return left_sum_max + right_sum_max;
    }

    public static int maxArr(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int m = (l + r) / 2;

        return Math.max(Math.max(maxArr(arr, l, m), maxArr(arr, m+1, r)),
                        midMaxArr(arr, l, m, r));
    }

    public static int kadanesAlgorithm(int[] nums) {
        int max_end = 0;
        int max_so_far = 0;

        for (int i=0; i<nums.length; i++) {
            max_end = max_end + nums[i];
            if (max_end < 0) {
                max_end = 0;
            }
            if (max_end > max_so_far) {
                max_so_far = max_end;
            }
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
        int[] arr2 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr3 = {-1, 4, -8, 6};
        int[] arr4 = {2, 3, 4, 5, 7};
//        System.out.println(maxSubArray(arr2));
        System.out.println(maxArr(arr2, 0, arr2.length-1));
        System.out.println(kadanesAlgorithm(arr2));
    }
}
