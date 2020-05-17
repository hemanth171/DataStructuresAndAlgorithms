package com.hemanth.datastructures;

public class MaxHeap {

    private int[] heap;
    private int size;
    private int curr;

    public MaxHeap(int arrSize) {
        this.size = 0;
        this.curr = 0;
        this.heap = new int[arrSize];
    }

    public void insert(int[] arr) {
        for (int i: arr) {
            insertElement(i);
        }
    }

    public void insertElement(int num) {
        heap[size++] = num;
        curr = size - 1;
        while (heap[curr] > heap[parent(curr)]) {
            swap(heap, parent(curr), curr);
        }
    }

    public void swap(int[] arr, int p, int c) {
        int tmp = arr[p];
        arr[p] = arr[c];
        arr[c] = tmp;
        curr = p;
    }

    public int maxElement() {
        return heap[0];
    }

    public int parent(int pos) {
        if (pos == 0) {
            return 0;
        }
        if (pos % 2 == 0) {
            return (pos / 2) - 1;
        } else {
            return (pos / 2);
        }
    }

    public void print() {
        for (int ele: heap) {
            System.out.println(ele);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,17,10,84,19,6,22,9};
        MaxHeap maxHeap = new MaxHeap(arr.length);
        maxHeap.insert(arr);
        maxHeap.print();
        System.out.println(maxHeap.maxElement());
    }
}
