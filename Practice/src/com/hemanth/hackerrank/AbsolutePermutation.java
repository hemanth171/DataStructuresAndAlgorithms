package com.hemanth.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AbsolutePermutation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++){
			permutation(br.readLine());
		}
		
	}
	
	public static void permutation(String S){
		StringTokenizer st = new StringTokenizer(S);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		boolean flag = false;
		if(K == 0){
			for(int i=1;i<=N;i++){
				sb.append(i+" ");
			}
		}
		else if(N % K == 0){
			int t = 1;
			while(t <= N){
				int c1 = K;
				while(c1 > 0){
					if((t+K) <= N){
						sb.append((t+K)+" ");
						t++;
						c1--;
					} else {
						flag = true;
						break;
					}
				}
				int c2 = K;
				while(c2 > 0){
					if(Math.abs(t-K) <= N){
						sb.append((Math.abs(t-K))+" ");
						t++;
						c2--;
					} else {
						flag = true;
						break;
					}
				}
			}
		} else {
			flag = true;
		}
		if(flag == false){
			System.out.println(sb);
		} else {
			System.out.println("-1");
		}
	}

}
