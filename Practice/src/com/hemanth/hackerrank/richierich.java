package com.hemanth.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Rich{
	private StringBuffer sb = new StringBuffer();
	int n;
	int k;
	public Rich(StringBuffer sb, int n, int k){
		this.sb  = sb;
		this.n = n;
		this.k = k;
	}
	
	public void equalCompare(){
		this.sb = equalCompare(sb, n, k);
	}
	
	public StringBuffer equalCompare(StringBuffer sb, int n, int k){
		if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
			if(k == 1){
				if(n % 2 != 0){
					int t = n/2;
					sb.setCharAt(t, '9');
				}
			}
			if(k > 1){
				int p1 = 0;
				int p2 = n - 1;
				while((k>0) && (p2>0) && (p1<n)){
					if(k>1){
						sb.setCharAt(p1++, '9');
						sb.setCharAt(p2--, '9');
						k = k - 2;
					} else if(k == 1){
						if(n % 2 != 0){
							int t = n/2;
							sb.setCharAt(t, '9');
							k--;
						}
					}
				}
			}
		}
		return sb;
	}
	
	public void compare(){
		this.sb = compare(sb, n, k);
	}
	
	public StringBuffer compare(StringBuffer sb, int n, int k){
		int r1 = 0;
		int r2 = n-1;
		while((k>0) && (r2>0) && (r1<n)){
			if(k == 1){
				if(sb.charAt(r1) != sb.charAt(r2)){
					if(sb.charAt(r1) > sb.charAt(r2)){
						sb.setCharAt(r2, sb.charAt(r1));
						k--;
					} else {
						sb.setCharAt(r1, sb.charAt(r2));
						k--;
					}
					r1++;
					r2--;
				}
			}
			else if(k > 1){
				if(sb.charAt(r1) != sb.charAt(r2)){
					sb.setCharAt(r1++, '9');
					sb.setCharAt(r2--, '9');
					k = k-2;
				}
			}
			r1++;
			r2--;
			if((sb.toString().equalsIgnoreCase(sb.reverse().toString())) && k>0){
				sb = equalCompare(sb, n, k);
				break;
			}
		}
		return sb;
	}
	
	public void display(){
		display(sb);
	}
	
	public void display(StringBuffer sb){
		if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
			System.out.println(sb.toString());
		} else {
			System.out.println("-1");
		}
	}
}

public class richierich {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer(br.readLine());
		if(sb.length() != n){
            int sub = n - sb.length();
            for(int i=0;i<sub;i++){
                sb.insert(i, '0');
            }
        }
		System.out.println(sb);
		if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
			equalCompare(sb,n,k);
			display(sb);
		} else {
			compare(sb,n,k);
			display(sb);
		}
	}

	
	public static StringBuffer equalCompare(StringBuffer sb, int n, int k){
		if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
			if(k == 1){
				if(n % 2 != 0){
					int t = n/2;
					sb.setCharAt(t, '9');
				}
			}
			if(k > 1){
				int p1 = 0;
				int p2 = n - 1;
				while((k>0) && (p2>0) && (p1<n)){
					if(k>1){
						sb.setCharAt(p1++, '9');
						sb.setCharAt(p2--, '9');
						k = k - 2;
					} else if(k == 1){
						if(n % 2 != 0){
							int t = n/2;
							sb.setCharAt(t, '9');
							k--;
						}
					}
				}
			}
		}
		return sb;
	}
	
	public static StringBuffer compare(StringBuffer sb, int n, int k){
		int r1 = 0;
		int r2 = n-1;
		while((k>0) && (r2>0) && (r1<n)){
			if(k == 1){
				if(sb.charAt(r1) != sb.charAt(r2)){
					if(sb.charAt(r1) > sb.charAt(r2)){
						sb.setCharAt(r2, sb.charAt(r1));
						k--;
					} else {
						sb.setCharAt(r1, sb.charAt(r2));
						k--;
					}
					r1++;
					r2--;
				}
			}
			else if(k > 1){
				if(sb.charAt(r1) != sb.charAt(r2)){
					sb.setCharAt(r1++, '9');
					sb.setCharAt(r2--, '9');
					k = k-2;
				}
			}
			r1++;
			r2--;
			if((sb.toString().equalsIgnoreCase(sb.reverse().toString())) && k>0){
				sb = equalCompare(sb, n, k);
				break;
			}
		}
		return sb;
	}
	
	public static void display(StringBuffer sb){
		if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
			System.out.println(sb.toString());
		} else {
			System.out.println("-1");
		}
	}
}
