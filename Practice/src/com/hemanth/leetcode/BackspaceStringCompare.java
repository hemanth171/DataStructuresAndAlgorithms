package com.hemanth.leetcode;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        return removeHash(S).equalsIgnoreCase(removeHash(T));
    }

    public static String removeHash(String S) {
        StringBuffer sb = new StringBuffer(S);
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == '#') {
                sb.deleteCharAt(i);
                if (i > 0) {
                    sb.deleteCharAt(i-1);
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";
        System.out.println(backspaceCompare(S, T));
    }
}
