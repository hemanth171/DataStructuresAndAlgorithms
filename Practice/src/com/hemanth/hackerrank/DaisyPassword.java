package com.hemanth.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DaisyPassword {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++){
			String input = br.readLine();
			password(input);
		}
	}
	
	public static void password(String input){
		StringTokenizer st = new StringTokenizer(input);
		String S = st.nextToken();
		String P = st.nextToken();
		int index = P.indexOf(S);
		StringBuffer sb = new StringBuffer(P);
		sb.delete(index, index + S.length());
		if(S.equals(sb.toString())){
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
	}

}
