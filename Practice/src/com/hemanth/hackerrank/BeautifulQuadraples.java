package com.hemanth.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulQuadraples {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++){
			int input = Integer.parseInt(br.readLine());
			rod(input);
		}
	}
	
	public static void rod(int input){
		int count = 0;
		while((input > 1) && (input % 2 != 0)){
			input = input / 2;
			count++;
		}
		System.out.println(String.valueOf(count));
	}

}
