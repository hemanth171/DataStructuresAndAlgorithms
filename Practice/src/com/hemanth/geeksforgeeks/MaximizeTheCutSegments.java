package com.hemanth.geeksforgeeks;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MaximizeTheCutSegments {

    public static int solve(int lineLen, int[] cuts) {
        int[][] board = new int[cuts.length + 1][lineLen + 1];
        Arrays.sort(cuts);

        for (int i=0;i<=cuts.length;i++) {
            board[i][0] = 0;
        }
        for (int i=0;i<=lineLen;i++) {
            board[0][1] = 0;
        }

        for (int i=1;i<=cuts.length;i++) {
            for (int j=1;j<=lineLen;j++) {
                if (j < cuts[i-1]) {
                    board[i][j] = board[i-1][j];
                } else {
//                    System.out.println("i: " + i + " j: " + j);
                    board[i][j] = Math.max(1 + board[i][j - cuts[i-1]], board[i - 1][j]);
                }
            }
        }

//        System.out.println(Arrays.deepToString(board));
        return board[cuts.length][lineLen];
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int i=0;i<t;i++) {
            int N = fr.nextInt();
            int[] cuts = new int[3];
            cuts[0] = fr.nextInt();
            cuts[1] = fr.nextInt();
            cuts[2] = fr.nextInt();

            System.out.println(solve(N, cuts));
        }
    }

    static class FastReader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
