package com.hemanth.geeksforgeeks;

import java.util.Arrays;

public class QueriesToCount {

    public static void solve(int[] arr, int[] queries, int M) {
        Arrays.sort(arr);
        System.out.println(findPos(arr, queries[0], 0, arr.length-1));
    }

    public static int findPos(int[] arr, int q, int start, int end) {
        if (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] >= q) {
                return arr[mid];
            }
            if (q < arr[mid]) {
                return findPos(arr, q, start, mid-1);
            }
            return findPos(arr, q, mid+1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,8};
        int[] queries = {4,3,1};
        int M = 1;
        solve(arr, queries, M);
    }
}
