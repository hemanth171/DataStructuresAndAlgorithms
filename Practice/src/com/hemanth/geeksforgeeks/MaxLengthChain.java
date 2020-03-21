package com.hemanth.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Pair {
    int x;
    int y;

    Pair(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxLengthChain {

    public static int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.x - b.x;
            }
        });

        for (Pair pair: arr) {
            System.out.println(pair.x + " " + pair.y);
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int k=0; k<T; k++) {
            int N = Integer.parseInt(br.readLine());
            Pair pr[] = new Pair[N];
            int arr[] = new int[2*N];
            for (int i=0; i<2*N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            for (int i=0, j=0; i<2*N-1 && j<N; i=i+2, j++) {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            maxChainLength(pr, N);
        }
    }
}
