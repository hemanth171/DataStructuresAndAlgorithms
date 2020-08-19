package com.hemanth.geeksforgeeks;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CoinChange {

    public static int coin(int[] c,int m, int w) {
        if (w == 0) {
            return 1;
        }
        if (w < 0 || m < 0) {
            return 0;
        }

        //include current coin
        int incl = coin(c, m, (w-c[m]));

        //exclude current coin
        int excl = coin(c, m-1, w);

        return incl + excl;
    }

    public static int coinChangeDP(int[] S, int w) {
        int[][] board = new int[S.length+1][w+1];
        // Fill arrays with o's
        for (int[] row: board) {
            Arrays.fill(row, 0);
        }

        for (int i=1;i<=S.length;i++) {
            for (int j=0;j<=w;j++) {
                if (j == 0) {
                    board[i][j] = 1;
                }
                else if (j < S[i-1]) {
                    board[i][j] = board[i-1][j];
                }
                else {
                    board[i][j] = board[i-1][j] + board[i][j-S[i-1]];
                }
            }
        }
        return board[S.length][w];
    }

    public static void main(String[] args) {
        int[] c = {2, 3, 5, 10};
        int w = 15;
        System.out.println(coin(c,c.length-1, w));
        System.out.println(coinChangeDP(c, w));
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
