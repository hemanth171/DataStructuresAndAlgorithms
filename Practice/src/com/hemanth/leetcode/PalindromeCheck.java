package com.hemanth.leetcode;

public class PalindromeCheck {

    public static void main(String[] args) {
        // 48 - 57 - 97 - 122
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] charr = s.toCharArray();
        s = removeSplChars(charr);
        System.out.println(s);
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String removeSplChars(char[] charr) {
        StringBuilder sb = new StringBuilder();
        for (char c: charr) {
            int k = c;
            if (k >= 48 && k <= 57 || k >= 97 && k <= 122) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
