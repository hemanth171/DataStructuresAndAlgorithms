package com.hemanth.geeksforgeeks;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MinimumCoinChange {

    public static void minCoins(int[] S, int w, PrintWriter out) {

        int[][] board = new int[S.length+1][w+1];

        for (int i=0;i<S.length;i++) {
            board[i][0] = 0;
        }

        for (int i=0;i<=S.length;i++) {
            for (int j=1;j<=w;j++) {
                if (i == 0) {
                    board[i][j] = Integer.MAX_VALUE;
                } else if (j < S[i-1]) {
                    board[i][j] = board[i-1][j];
                } else {
                    board[i][j] = Math.min(board[i - 1][j], 1 + board[i][j-S[i-1]]);
                }
            }
        }

        // Find the min coins
        int i = S.length, j = w;
        while (i > 0 && j > 0) {
            if (board[i][j] == board[i-1][j]) {
                i--;
                continue;
            }
            out.print(S[i-1] + " ");
            j = j-S[i-1];
        }
        out.println();

//        return board[S.length][w];
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int[] S = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int T = fr.nextInt();
        for (int tt=0;tt<T;tt++) {
            int N = fr.nextInt();
            minCoins(S, N, out);
        }
        out.close();
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
