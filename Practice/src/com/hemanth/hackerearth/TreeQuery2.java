package com.hemanth.hackerearth;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class TreeQuery2 {

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TreeQuery2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
    }

    public TreeQuery2() {
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
            SegmentTree tree = new SegmentTree();
            for (int i=0;i<N-1;i++) {
                int a = fr.nextInt();
                int b = fr.nextInt();
                tree.build(a, b);
            }
            for (int i=0;i<Q;i++) {
                int t = fr.nextInt();
                int v = fr.nextInt();
            }
            tree.print();
        }
    }

    static class SegmentTree {
        TreeObj node;

        public SegmentTree() {
            node = new TreeObj(1, true, 1);
        }

        public void build(int leftVertex, int rightVertex) {
            build(node, leftVertex, rightVertex);
        }

        public void print() {
            print(node);
        }

        public int build(TreeObj node, int leftVertex, int rightVertex) {
            if (node != null) {
                if (node.vertex == leftVertex) {
                    if (node.left == null) {
                        node.left = new TreeObj(rightVertex, true, 1);
                        return node.count++;
                    } else {
                        node.right = new TreeObj(rightVertex, true, 1);
                        return node.count++;
                    }
                }
                int left = build(node.left, leftVertex, rightVertex);
                int right = build(node.right, leftVertex, rightVertex);
                node.count = 1 + left + right;
                return node.count;
            }
            return 0;
        }

        public void print(TreeObj node) {
            if (node != null) {
                System.out.println("vertex: "+node.vertex+" count: "+node.count);
                print(node.left);
                print(node.right);
            }
        }
    }

    static class TreeObj {
        int vertex;
        boolean state;
        int count;
        TreeObj left;
        TreeObj right;

        public TreeObj(int vertex, boolean state, int count) {
            this.vertex = vertex;
            this.state = state;
            this.count = count;
            this.left = null;
            this.right = null;
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
