package com.hemanth.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StockBuyAndSell {

    public static String calculateStock(int[] arr) {
        int buyIndex = 0;
        int sellShare = arr[0];
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<arr.length+1; i++) {
            if (i < arr.length && sellShare < arr[i]) {
                sellShare = arr[i];
                counter++;
            } else if (counter == 0) {
                if (i >= arr.length-1) {
                    break;
                }
                sellShare = arr[i];
                buyIndex = i;
            } else if (counter > 0){
                counter = 0;
                String str = "(" + buyIndex + " " + (i-1) + ")";
                sb.append(str);
                sb.append(" ");
                if (i < arr.length) {
                    buyIndex = i;
                    sellShare = arr[i];
                }
            }
        }
        String out = sb.toString().trim();
        if (out != null && !out.isEmpty()) {
            return out;
        } else {
            return "No Profit";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int[] arr = new int[N];
            int k = 0;
            while (st.hasMoreTokens()) {
                arr[k++] = Integer.parseInt(st.nextToken());
            }
            System.out.println(calculateStock(arr));
        }

        // Test cases
//        84
//        886 2777 6915 7793 8335 5386 492 6649 1421 2362 27 8690 59 7763 3926 540 3426 9172 5736 5211 5368 2567 6429 5782 1530 2862 5123 4067 3135 3929 9802 4022 3058 3069 8167 1393 8456 5011 8042 6229 7373 4421 4919 3784 8537 5198 4324 8315 4370 6413 3526 6091 8980 9956 1873 6862 9170 6996 7281 2305 925 7084 6327 336 6505 846 1729 1313 5857 6124 3895 9582 545 8814 3367 5434 364 4043 3750 1087 6808 7276 7178 5788

//        89
//        6764 3645 5181 5893 4542 6753 3996 5483 585 9895 2657 777 1343 4605 261 2225 959 9884 563 4131 6687 7528 6224 436 3333 110 2037 7007 4710 2310 7596 7827 2307 9129 72 3202 2234 4069 5037 2819 3964 7694 9948 5307 8652 6561 7532 9611 6445 8095 94 9484 1975 6319 9920 5308 6429 1958 8668 7491 620 6264 5318 2927 1745 5391 6129 3979 5812 1167 3150 9776 8861 3098 5083 3865 9659 8968 3476 6104 3415 9923 1940 1743 6242 1861 3403 9023 3819
    }
}
