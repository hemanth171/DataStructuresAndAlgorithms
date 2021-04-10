//package com.hemanth.hackerearth;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.InputMismatchException;
//
//public class Main
//{
//
//	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	static class Solution
//	{
//		final long mod = 1000000007;
//		final int  max = (int)1e5;
//		final boolean SIEVE = false;
//		boolean[] prime;
//		ArrayList<Integer> al;
//
//		int[] a ;
//		int n,q;
//		int[] t = new int[2*max];
//	    public void solve(InputReader sc,PrintWriter out)
//	    {
//	       if(SIEVE)
//	       {
//	          al = new ArrayList<Integer>();
//	          prime = new boolean[max];
//	          for(int i=2;i<max;i++)
//	          {
//	              prime[i] = true;
//	          }
//	          for(int i=2;i<max;i++)
//	          {
//	              if(prime[i])
//	              {
//	                  al.add(i);
//	                  for(int j=2*i;j<max;j+=i)
//	                  {
//	                      prime[j] = false;
//	                  }
//	              }
//	          }
//	       }
//	       n = i();q=i();
//	       for(int i=0;i<n;i++)
//	       		t[n+i]=i();
//	       build();
//
//
//	       while(q-->0)
//	       {
//	       		String s = s();
//
//	       		int l = i()-1;
//	       		int r = i()-1;
//	       		if(s.equals("q"))	out.println(query(l,r+1));
//	       	    else					update(l,r+1);
//	       }
//
//    	}
//        void build(){
//        	for(int i=n-1;i>0;--i) t[i] = Math.min(t[i<<1],t[i<<1|1]);
//        }
//    	void update(int p,int value)
//    	{
//    		for(t[p+=n]=value;p>1;p>>=1) t[p>>1]=Math.min(t[p],t[p^1]);
//    	}
//    	int query(int l,int r)
//    	{
//    		int res=Integer.MAX_VALUE;
//    		for(l+=n,r+=n;l<r;l>>=1,r>>=1)
//    		{
//    			if((l&1)==1) res=Math.min(res,t[l++]);
//    			if((r&1)==1) res=Math.min(res,t[--r]);
//    		}
//    		return res;
//
//    	}
//
//    	///////////////////////////////Methods///////////////////////////////////////////////////////
//       int lower_bound(int n, int x) {
//    		int l = 0;
//    		int h = n; // Not n - 1
//    		while (l < h) {
//        		int mid = (l + h) / 2;
//        		if (x <= al.get(mid)) {
//            		h = mid;
//        		} else {
//            		l = mid + 1;
//        		}
//    		}
//    		return l;
//		}
//    	long fib(long n)
//        {
//			if(n==0) return 0;
//			long a=0, b=1, c=1, d=1, e=n-2;
//			long a1, b1, c1, d1, a2=0, b2=1, c2=1, d2=1;
//
//			while(e>0){
//				if(e%2==1){
//					a1 = (a*a2+b*c2)%mod;
//					c1 = (c*a2+d*c2)%mod;
//					b1 = (a*b2+ b*d2)%mod;
//					d1 = (b2*c+ d*d2)%mod;
//					a=a1; b=b1; c=c1; d= d1;
//				}
//				a1 = (a2*a2+b2*c2)%mod;
//				c1 = (c2*a2+d2*c2)%mod;
//				b1 = (a2*b2+ b2*d2)%mod;
//				d1 = (b2*c2+ d2*d2)%mod;
//				a2=a1; b2=b1; c2=c1; d2= d1;
//				e /= 2;
//			}
//			return d;
//        }
//        ////////////////////////////////////////////////////////////
//        public int i(){	return sc.nextInt();}
//		public long l(){ return sc.nextLong();}
//		public String s(){ return sc.next();}
//		public int[] iarr(int n){int[] ar = new int[n];for(int i=0;i<n;i++) ar[i] = sc.nextInt(); return ar; }
//		public void parr(int[] ar){	for(int i=0;i<ar.length;i++)	out.print(ar[i]+" ");
//			out.println();
//		}
//		public void parl(long[] ar){	for(int i=0;i<ar.length;i++)	out.print(ar[i]+" ");
//			out.println();
//		}
//        ///////////////////////////////////////Methods/////////////////////////////////////////////////////
// 	}
//
//
// 	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 	static	InputReader sc = new InputReader();
//	static    PrintWriter out= new PrintWriter(System.out);
//	Main() throws IOException {
//
//	    final long start = System.currentTimeMillis();
//		new Solution().solve(sc,out);
//		@SuppressWarnings("unused")
//		final long duration = System.currentTimeMillis()-start;
//		out.close();
//	}
//
//	public static void main(String args[]) {
//		new Thread(null, new Runnable() {
//			public void run() {
//				try {
//					new Main();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}, "1", 1 << 26).start();
//	}
//	static class InputReader{
//		final InputStream stream;
//		final byte[] buf = new byte[8192];
//		int curChar, numChars;
//		SpaceCharFilter filter;
//
//		public InputReader(){
//			this.stream = System.in;
//		}
//
//		public int read(){
//			if(numChars == -1){
//				throw new InputMismatchException();
//			}
//			if(curChar >= numChars){
//				curChar = 0;
//				try{
//					numChars = stream.read(buf);
//				} catch(IOException e){
//					throw new InputMismatchException();
//				}
//				if(numChars <= 0)
//					return -1;
//			}
//			return buf[curChar++];
//		}
//
//		public int nextInt(){
//			int c = read();
//			while(isSpaceChar(c))
//				c = read();
//			int sgn = 1;
//			if(c == '-'){
//				sgn = -1;
//				c = read();
//			}
//			int res = 0;
//			do{
//				if(c<'0' || c>'9'){
//					throw new InputMismatchException();}
//				res *= 10;
//				res += c - '0';
//				c = read();
//			} while(!isSpaceChar(c));
//			return res*sgn;
//		}
//
//		public long nextLong(){
//			int c = read();
//			while(isSpaceChar(c))
//				c = read();
//			int sgn = 1;
//			if(c == '-'){
//				sgn = -1;
//				c = read();
//			}
//			long res = 0;
//			do{
//				if(c<'0' || c>'9')
//					throw new InputMismatchException();
//				res *= 10;
//				res += c - '0';
//				c = read();
//			} while(!isSpaceChar(c));
//			return res*sgn;
//		}
//
//		public String next(){
//			int c = read();
//			while(isSpaceChar(c))
//				c = read();
//			StringBuilder res = new StringBuilder();
//			do{
//				res.appendCodePoint(c);
//				c = read();
//			}while(!isSpaceChar(c));
//			return res.toString();
//		}
//
//		public boolean isSpaceChar(int c){
//			if(filter != null)
//				return filter.isSpaceChar(c);
//			return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
//		}
//
//		public interface SpaceCharFilter{
//			public boolean isSpaceChar(int ch);
//		}
//	}
//
//}