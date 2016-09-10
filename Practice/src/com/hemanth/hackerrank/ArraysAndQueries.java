package com.hemanth.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ArraysAndQueries {

public static void main(String args[]) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int input = Integer.parseInt(br.readLine());
	int size = (input * 2) - 1;
	int[] list = new int[size];
	Arrays.fill(list, 0);
	int temp = 0;
	for (int i=0;i<input;i++){
		int output =0;
		int type = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		if (type == 1){
			temp = temp + a;
			list[b] = temp;
		} else if (type == 2) {
			while (a != -1) {
				output = list[a];
				if (output == 0) {
					a--;
				} else {
					a = -1;
					System.out.println(output);
					break;
				}
			}
		}
	}
        
}
    
}