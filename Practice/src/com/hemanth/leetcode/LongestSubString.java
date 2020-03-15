package com.hemanth.leetcode;

public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        if (s.length() == 1)
        {
            return 1;
        }

        if (s != null && s.trim().isEmpty())
        {
            return 1;
        }
        int n = s.length();
        int no_of_chars = 256;
        int cur_len = 1;
        int max_len = 1;
        int prev_index;
        int i;
        int[] visited = new int[no_of_chars];

        for (i=0; i<no_of_chars; i++) {
            visited[i] = -1;
        }

        visited[s.charAt(0)] = 0;

        for (i=1; i<n; i++) {
            prev_index = visited[s.charAt(i)];

            if (prev_index == -1 || i - cur_len > prev_index) {
                cur_len++;
            } else {
                if (cur_len > max_len) {
                    max_len = cur_len;
                }
                cur_len = i - prev_index;
            }
            visited[s.charAt(i)] = i;
        }

        if (cur_len > max_len) {
            max_len = cur_len;
        }

        return max_len;
    }

    public static void main(String[] args) {
        String s = "    ";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
