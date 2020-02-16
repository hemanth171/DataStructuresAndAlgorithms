package com.hemanth.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubArray {

    public static void compute(int N, int S, int[] arr) {
//        int str = 0;
//        int end = 0;
//        int tot = arr[0];

//        while ((tot != S) && (end < N)) {
//            if (tot < S && end < N-1) {
//                end++;
//                tot = tot + arr[end];
//            } else if (tot > S && str <= end) {
//                tot = tot - arr[str];
//                str++;
//            }
//        }
//
//        if (tot == S) {
//            System.out.println((str+1) + " " + (end+1));
//        } else {
//            System.out.println(-1);
//        }

        int header = 0;
        int wsum = 0;
        int flag = 0;

        for (int i=0; i<N; i++) {
            wsum = wsum + arr[i];

            while (wsum > S) {
                wsum = wsum - arr[header];
                header++;
            }

            if (wsum == S) {
                flag = 1;
                System.out.println((header+1) + " " + (i+1));
                break;
            }
        }

        if (flag == 0) {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String sb = br.readLine();
            StringTokenizer st = new StringTokenizer(sb);
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            String sb_arr = br.readLine();
            StringTokenizer st_arr = new StringTokenizer(sb_arr);
            for (int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st_arr.nextToken());
            }
            /**
             * No of test cases
             * 1
             * Num of elements & Sum of Sub-array
             * 42 468
             * Array elements
             * 135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 96 48 127 172 139 70 113 68 100 36 95 104 12 123 134
             *
             * Output: start index and end index of sub-array
             * 38 42
             */
            compute(N, S, arr);
        }
    }
}
