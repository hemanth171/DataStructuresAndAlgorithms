package com.hemanth.leetcode;

import java.util.HashMap;

public class CountingElements {

    public static int countElements(int[] arr) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int num: arr) {
            if (map.get(num) != null) {
                int n = map.get(num);
                map.put(num, ++n);
            } else {
                map.put(num, 1);
            }
        }

        for (int num: arr) {
            if (map.get(num+1) != null) {
                int v = map.get(num+1);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2};
        System.out.println(countElements(arr));
    }
}
