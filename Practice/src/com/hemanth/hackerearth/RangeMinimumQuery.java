package com.hemanth.hackerearth;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class RangeMinimumQuery {

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new RangeMinimumQuery();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
    }

    public RangeMinimumQuery() {
        InputReader fr = new InputReader();
        final long start = System.currentTimeMillis();
        new Solution().solve(fr);
        @SuppressWarnings("unused")
        final long duration = System.currentTimeMillis()-start;
    }

    static class Solution {

        public void solve(InputReader fr) {
            int N = fr.nextInt();
            int Q = fr.nextInt();
            int[] A = new int[N];
            for (int ii=0;ii<N;ii++) {
                A[ii] = fr.nextInt();
            }
            int n = A.length;
            Tree segTree = new Tree(A, n-1);
            segTree.build(0, 0, n-1);
            for (int i=0;i<Q;i++) {
                String q = fr.next();
                int l = fr.nextInt();
                int r = fr.nextInt();
                if (q.equals("q")) {
                    System.out.println(segTree.query(0, 0, n-1, l-1, r-1));
                } else {
                    segTree.update(0, 0, n-1, l-1, r);
                }
            }
        }
    }

    static class Tree {
        int[] tree;
        int[] arr;

        public Tree(int[] arr, int n) {
            // 2 * 2 pow (log n) -1
            this.arr = arr;
            tree = new int[4*n];
        }

        public void build(int index, int start, int end) {
            // sum = left + right;
            if (start == end) {
                tree[index] = arr[start];
                return;
            }
            int mid = (start + end) / 2;
            build((2*index+1), start, mid);
            build((2*index+2), mid+1, end);
            tree[index] = Math.min(tree[2*index+1], tree[2*index+2]);
        }

        public int query(int index, int start, int end, int l, int r) {
            if (start>=l && end <=r) {
                return tree[index];
            }
            else if (start > r || end < l) return Integer.MAX_VALUE;
            else {
                int mid = (start + end) / 2;
                int left = query((2*index+1), start, mid, l, r);
                int right = query((2*index+2), mid+1, end, l, r);
                return Math.min(left, right);
            }
        }

        public int update(int index, int start, int end, int upt_in, int val) {
            if (start == end) {
                if (upt_in == start) {
//                    System.out.println("index: "+index+" start: "+start+" end: "+end);
                    tree[index] = val;
                    return tree[index];
                } else {
                    return tree[index];
                }
            } else if (start > index || end < index) {
                return tree[index];
            } else {
                int mid = (start + end) / 2;
//                System.out.println("index: "+index+" start: "+start+" mid: "+mid+" upt_in: "+upt_in+" val: "+val);
                int left = update((2*index+1), start, mid, upt_in, val);
                int right = update((2*index+2), mid+1, end, upt_in, val);
                tree[index] = Math.min(left, right);
                return tree[index];
            }
        }
    }

    static class InputReader{
        final InputStream stream;
        final byte[] buf = new byte[8192];
        int curChar, numChars;
        SpaceCharFilter filter;

        public InputReader(){
            this.stream = System.in;
        }

        public int read(){
            if(numChars == -1){
                throw new InputMismatchException();
            }
            if(curChar >= numChars){
                curChar = 0;
                try{
                    numChars = stream.read(buf);
                } catch(IOException e){
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt(){
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-'){
                sgn = -1;
                c = read();
            }
            int res = 0;
            do{
                if(c<'0' || c>'9'){
                    throw new InputMismatchException();}
                res *= 10;
                res += c - '0';
                c = read();
            } while(!isSpaceChar(c));
            return res*sgn;
        }

        public long nextLong(){
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-'){
                sgn = -1;
                c = read();
            }
            long res = 0;
            do{
                if(c<'0' || c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while(!isSpaceChar(c));
            return res*sgn;
        }

        public String next(){
            int c = read();
            while(isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do{
                res.appendCodePoint(c);
                c = read();
            }while(!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c){
            if(filter != null)
                return filter.isSpaceChar(c);
            return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);
        }
    }
}
