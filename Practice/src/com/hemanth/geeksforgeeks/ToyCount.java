package com.hemanth.geeksforgeeks;

import java.util.*;

public class ToyCount {

    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes) {

        if (topToys > numToys) {
            ArrayList<String> toyCount2 = new ArrayList<>();

            for (String toy: toys) {
                for (String quote: quotes) {
                    if (toy.toLowerCase().contains(quote.toLowerCase())) {
                        toyCount2.add(toy);
                    }
                }
            }
            return toyCount2;
        }

        TreeMap<String, Integer> toyCount = new TreeMap<>();
        for (String toy : toys) {
            int count = 0;
            for (String quote: quotes) {
                if (toy.toLowerCase().contains(quote.toLowerCase())) {
                    count++;
                }
            }
            toyCount.put(toy, count);
        }
        List<Map.Entry<String, Integer> > list = new LinkedList<>(toyCount.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        ArrayList<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: temp.entrySet()) {
            if (topToys > 0) {
                output.add(entry.getKey());
            }
            topToys--;
        }

        return output;
    }

    public static void main(String[] args) {

    }
}
