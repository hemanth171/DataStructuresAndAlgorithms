package com.hemanth.datastructures;

//   3
// 1   2
public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        Tree segTree = new Tree(arr, arr.length);
        segTree.build(0, 0, arr.length-1);
//        segTree.print();
        int l = 1;
        int r = 3;
        System.out.println(segTree.query(0, 0, arr.length-1, l, r));
    }

    static class Tree {
        int[] tree;
        int[] arr;

        public Tree(int[] arr, int n) {
            // 2 * 2 pow (log n) -1
            this.arr = arr;
//            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
//            int max_size = 2 * (int) (Math.pow(2, x) - 1);
//            tree = new int[max_size];
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
            tree[index] = tree[2*index+1] + tree[2*index+2];
        }

        public int query(int index, int start, int end, int l, int r) {
            if (start>=l && end <=r) {
                return tree[index];
            }
            else if (start > r || end < l) return 0;
            else {
                int mid = (start + end) / 2;
                int left = query((2*index+1), start, mid, l, r);
                int right = query((2*index+2), mid+1, end, l, r);
                return (left + right);
            }
        }

        public void print() {
            for (int a: tree) {
                System.out.println(a);
            }
        }
    }
}
