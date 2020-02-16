package com.hemanth.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EquilibriumPoint {

    public static void compute(int[] arr, int N, int tot) {
        int sum = 0;
        int equ = 0;
        int tmp = 0;
        boolean flag = false;
        for (int i=0; i<N; i++) {
            equ = arr[i];
            tmp = tot - sum;
            tmp = tmp - equ;
            if (sum == tmp) {
                System.out.println(i+1);
                flag = true;
                break;
            }
            sum = sum + arr[i];
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            String arr_ele = br.readLine();
            StringTokenizer st_arr = new StringTokenizer(arr_ele);
            int[] arr = new int[N];
            int tot = 0;
            for (int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st_arr.nextToken());
                tot = tot + arr[j];
            }
            compute(arr, N, tot);
        }
    }
}
