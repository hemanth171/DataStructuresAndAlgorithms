package com.hemanth.leetcode;

public class countGoodNumbers {

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(3));
    }

    public static long countGoodNumbers(long n) {
        long mod = 1000000007;
        long even = 0;
        if (n % 2 == 0) {
            even = n / 2;
        } else {
            even = (n / 2) + 1;
        }
//        long even = n / 2;
        long odd = n - even;
        long ans = (modPow(5, even, mod) * modPow(4, odd, mod)) % mod;
        return ans;
    }

    public static long modPow(long base, long exp, long mod) {
        long result = base;
        while (exp > 1) {
            result = (result * base) % mod;
            exp = exp-1;
        }
        return result;
    }
}
