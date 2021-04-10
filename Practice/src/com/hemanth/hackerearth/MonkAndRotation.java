package com.hemanth.hackerearth;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;

public class MonkAndRotation {

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new MonkAndRotation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
    }

    public MonkAndRotation() {
        MonkAndRotation.InputReader fr = new MonkAndRotation.InputReader();
        final long start = System.currentTimeMillis();
        new MonkAndRotation.Solution().solve(fr);
        @SuppressWarnings("unused")
        final long duration = System.currentTimeMillis()-start;
    }

    static class Solution {
        public void solve(MonkAndRotation.InputReader fr) {
            int T = fr.nextInt();
            for (int ii=0;ii<T;ii++) {
                int N = fr.nextInt();
                int K = fr.nextInt();
                Deque<Integer> queue = new ArrayDeque();
                for (int i=0;i<N;i++) {
                    queue.addLast(fr.nextInt());
                }
                for (int j=0;j<K;j++) {
                    int last = queue.getLast();
                    queue.removeLast();
                    queue.addFirst(last);
                }
                for (int out: queue) {
                    System.out.print(out + " ");
                }
                System.out.println();
            }

        }
    }

    static class InputReader{
        final InputStream stream;
        final byte[] buf = new byte[8192];
        int curChar, numChars;
        MonkAndRotation.InputReader.SpaceCharFilter filter;

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
