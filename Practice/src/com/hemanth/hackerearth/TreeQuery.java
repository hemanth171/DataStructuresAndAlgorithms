package com.hemanth.hackerearth;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class TreeQuery {

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TreeQuery();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
    }

    public TreeQuery() {
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
            SegmentTree tree = new SegmentTree(N);
            Map<Integer, Integer> vertexMap = new HashMap<>();
            for (int i=0;i<N-1;i++) {
                int a = fr.nextInt();
                int b = fr.nextInt();
                tree.build(0, a, b);
            }
            for (int i=0;i<Q;i++) {
                int t = fr.nextInt();
                int v = fr.nextInt();
            }
            tree.print();
        }
    }

    static class SegmentTree {
        TreeObj[] segArr;

        public SegmentTree(int n) {
            segArr = new TreeObj[4*n];
            segArr[0] = new TreeObj(1, true, 1);
        }

        public int build(int index, int left_vertex, int right_vertex) {
//            System.out.println("index: "+index);
            if (index > segArr.length-1) {
                return 0;
            }
            if (segArr[index] != null && segArr[index].vertex == left_vertex) {
                if (segArr[2*index+1] == null) {
                    segArr[2*index+1] = new TreeObj(right_vertex, true, 1);
                    return 1;
                } else {
                    segArr[2*index+2] = new TreeObj(right_vertex, true, 1);
                    return 1;
                }
            }
            segArr[index].count += build((2*index+1), left_vertex, right_vertex) + build((2*index+2), left_vertex, right_vertex);
            return segArr[index].count;
        }

        public void lightUp(int index, int lightVertex) {
            if (index > segArr.length-1) {
                return;
            }
            if (segArr[index] != null && segArr[index].vertex == lightVertex) {
                if (segArr[index].state) {
                    segArr[index].state = false;
                    return;
                } else {
                    segArr[index].state = true;
                    return;
                }
            }
            lightUp((2*index+1), lightVertex);
            lightUp((2*index+2), lightVertex);
        }

        public void print() {
            for (TreeObj obj: segArr) {
                if (obj != null) {
                    System.out.println("Vertex: " + obj.vertex + " state: " + obj.state+" count: "+obj.count);
                } else {
                    System.out.println("xxx");
                }
            }
        }
    }

    static class TreeObj {
        int vertex;
        boolean state;
        int count;

        public TreeObj(int vertex, boolean state, int count) {
            this.vertex = vertex;
            this.state = state;
            this.count = count;
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
