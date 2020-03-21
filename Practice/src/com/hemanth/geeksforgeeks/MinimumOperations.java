package com.hemanth.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumOperations {

    static class ComputeOperations {
        int count = 0;

        public int compute(int N) {
            if (N != 0) {
                if (N % 2 == 0) {
                    N = N / 2;
                    count = count + 1;
                } else {
                    N = N - 1;
                    count = count + 1;
                }
                compute(N);
            }
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            ComputeOperations op = new ComputeOperations();
            System.out.println(op.compute(N));
        }
    }
}
