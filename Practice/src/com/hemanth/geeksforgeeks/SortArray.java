package com.hemanth.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortArray {

    public static void compute(int zero, int one, int two) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<zero; i++) {
            sb.append("0" + " ");
        }
        for (int i=0; i<one; i++) {
            sb.append("1" + " ");
        }
        for (int i=0; i<two; i++) {
            sb.append("2" + " ");
        }
        String output = sb.toString();
        System.out.println(output.trim());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            String arr_ele = br.readLine();
            StringTokenizer st_arr = new StringTokenizer(arr_ele);
            int zero = 0;
            int one = 0;
            int two = 0;
            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(st_arr.nextToken());
                if (num == 0) {
                    zero++;
                } else if (num == 1) {
                    one++;
                } else {
                    two++;
                }
            }
            compute(zero, one, two);
        }
    }
}
