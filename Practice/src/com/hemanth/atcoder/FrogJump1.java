package com.hemanth.atcoder;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FrogJump1 {

    public static void main(String[] args) throws IOException {
        FastReader fr =  new FastReader();
        int N = fr.nextInt();
        int[] heights = new int[N];
        int t = N;
        int i = 0;
        while (t > 0) {
            heights[i] = fr.nextInt();
            i++;
            t--;
        }
        System.out.println(frogJump(N, heights));
    }

    public static int frogJump(int N, int[] heights) {
        int[] dp = new int[N];
        Arrays.fill(dp, 0);

        for (int ind=1;ind<N;ind++) {
            int left = dp[ind -1] + Math.abs(heights[ind] - heights[ind-1]);
            int right = Integer.MAX_VALUE;
            if (ind >1) right = dp[ind - 2] + Math.abs(heights[ind] - heights[ind - 2]);

            dp[ind] = Math.min(left, right);
        }
        return dp[N-1];
    }

    public static int f(int ind, int[] heights, int[] dp) {
        if (ind == 0) return 0;

        if (dp[ind] != -1) return dp[ind];

        int left = f(ind -1, heights, dp) + Math.abs(heights[ind] - heights[ind-1]);
        int right = Integer.MAX_VALUE;
        if (ind >1) right = f(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);

        return dp[ind] = Math.min(left, right);
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
