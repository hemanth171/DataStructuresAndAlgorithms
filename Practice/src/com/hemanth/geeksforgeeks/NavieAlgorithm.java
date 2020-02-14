package com.hemanth.geeksforgeeks;

public class NavieAlgorithm {

    public static void search(String txt, String pat) {
        int txt_len = txt.length();
        int pat_len = pat.length();

        for (int i=0; i<=txt_len-pat_len; i++) {
            if (txt.charAt(i) == pat.charAt(0)) {
                int k = i;
                boolean flag = true;
                k++;
                for (int j = 1; j<pat_len; j++) {
                    if (txt.charAt(k++) != pat.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Present at index: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "THIS IS A TEST TEXT";
        String pattern = "TEST";
        search(text, pattern);
    }
}
