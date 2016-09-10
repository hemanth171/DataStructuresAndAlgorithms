package com.hemanth.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class javaHashset {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque();
        Set set = new HashSet();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        int lastRemoved;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);
            if(deque.size() == m){
            	max = Math.max(max, set.size());
            	lastRemoved = (Integer) deque.removeFirst();
            	if(!(deque.contains(lastRemoved))){
            		set.remove(lastRemoved);
            	}
            }
        }
        in.close();
        System.out.println(max);
		
	}

}
