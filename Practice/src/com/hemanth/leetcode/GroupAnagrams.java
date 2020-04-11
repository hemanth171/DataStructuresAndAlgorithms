package com.hemanth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        List<List<String>> outputList = new ArrayList<>();

        for (int i=0; i<strs.length; i++) {
            String in = strs[i];
            HashMap<Character, Integer> freqMap = new HashMap<>();
            for (int j=0; j<in.length(); j++) {
                if (freqMap.get(in.charAt(j)) != null) {
                    int x = freqMap.get(in.charAt(j));
                    freqMap.put(in.charAt(j), ++x);
                } else {
                    freqMap.put(in.charAt(j), 1);
                }
            }

            if (map.containsKey(freqMap)) {
                map.get(freqMap).add(in);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(in);
                map.put(freqMap, list);
            }
        }

        for (HashMap.Entry<HashMap<Character, Integer>, ArrayList<String>> entry: map.entrySet()) {
            outputList.add(entry.getValue());
        }
        return outputList;
    }

    // This algorithm ran better than the previous algorithm
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> outputList = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String in: strs) {
            char[] ch = in.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if (map.get(str) != null) {
                map.get(str).add(in);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(in);
                map.put(str, list);
            }
        }

        for (HashMap.Entry<String, List<String>> entry: map.entrySet()) {
            outputList.add(entry.getValue());
        }
        return outputList;
    }

    public static void main(String[] args) {
        String[] input = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        List<List<String>> outputList = groupAnagrams2(input);
        for (List<String> s: outputList) {
            System.out.println(s);
        }
    }
}
