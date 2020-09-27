package com.hemanth;

import java.util.Arrays;
import java.util.Scanner;

public class TestComparable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] pair = new Pair[n];
        for (int i=0;i<n;i++) {
            pair[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(pair);

        System.out.println(Arrays.deepToString(pair));

    }

    static class Pair implements Comparable<Pair> {
        int w, p;

        Pair(int w, int p) {
            this.w = w;
            this.p = p;
        }

        public int compareTo(Pair o) {
            return Integer.compare(w, o.w);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "w=" + w +
                    ", p=" + p +
                    '}';
        }
    }
}
