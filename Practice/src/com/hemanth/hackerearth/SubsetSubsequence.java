package com.hemanth.hackerearth;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetSubsequence {

    static int max = (int) 1e12;
    static double[][] board = new double[max][max];

    public static void solve(int pos, PrintWriter out) {
        ArrayList<ArrayList<Double>> subList = new ArrayList<ArrayList<Double>>();

        ArrayList<Double> zero = new ArrayList<>();
        zero.add(1d);
        subList.add(zero);

        outer: for (int i=1;i<pos;i++) {
            ArrayList<Double> power = new ArrayList<>();
            power.add(Math.pow(3, i));
            subList.add(power);
            int t = subList.size();
            for (int j=0;j<t-1;j++) {
                ArrayList<Double> ele = new ArrayList<>();
                ele.addAll(subList.get(j));
                ele.addAll(subList.get(t-1));
                subList.add(ele);

                if (subList.size() > pos-1) {
                    break outer;
                }
            }
        }

        ArrayList<Double> resList = subList.get(pos-1);
        DecimalFormat df = new DecimalFormat("###.#");
        out.println(resList.size());
        for (int i=0;i<resList.size();i++) {
            out.print(Integer.valueOf(df.format(resList.get(i))) + " ");
        }
        out.println();
    }

    public static void solve2(int pos, PrintWriter out) {
        board[0][0] = 1;

        int i = 1;
        while (i < pos) {
            board[i][0] = Math.pow(3, i);

        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = fr.nextInt();
        for (int i=0;i<t;i++) {
            int N = fr.nextInt();
            solve(N, out);
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
