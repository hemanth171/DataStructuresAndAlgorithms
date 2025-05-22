package com.hemanth.dsa;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 8};
        List<Integer> list = new ArrayList<>();
        printSubSequences(0, list, arr);
    }

    public static void printSubSequences(int i, List<Integer> list, int[] arr) {
        if (i > arr.length-1) {
            System.out.println(list);
            return;
        }
        //take
        list.add(arr[i]);
        printSubSequences(i+1, list, arr);
        //not take
        list.remove(list.size()-1);
        printSubSequences(i+1, list, arr);
    }
}
