package com.hemanth.leetcode;

import java.util.HashMap;

public class HappyNumbers {

    public static boolean happyNumber(int n) {
        HashMap map = new HashMap();
        while (n > 0) {
            if (map.get(n) != null) {
                return false;
            }

            int num = n;
            int sqr = 0;
            while (num > 0) {
                int last = num % 10;
                sqr = sqr + (last * last);
                num = num / 10;
            }
            if (sqr == 1) {
                return true;
            }
            map.put(n, n);
            n = sqr;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i=0;i<101;i++) {
            if (happyNumber(i)) {
                System.out.println(i);
            }
        }
    }
}
