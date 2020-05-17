package com.hemanth.leetcode;

public class LastStoneWeight {

    private int[] heap;
    private int size = 0;
    private int curr = 0;

    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        this.heap = new int[stones.length];

        for (int ele: stones) {
            insertElement(ele);
        }

        while (heap[0] != -1) {
            if (heap[1] == -1 && heap[2] == -1) {
                if (heap[0] == -1) {
                    return 0;
                } else {
                    return heap[0];
                }
            }
            int nextbigIndex = maxIndex(1,2);
            if (heap[0] == heap[nextbigIndex]) {
                heap[0] = -1;
                heap[nextbigIndex] = -1;
            } else {
                int diff = heap[0] - heap[nextbigIndex];
                heap[0] = diff;
                heap[nextbigIndex] = -1;
            }
            heapify(nextbigIndex);
            heapify(0);
        }

        if (heap[0] == -1) {
            return 0;
        } else {
            return heap[0];
        }
    }

    public int maxIndex(int i, int j) {
        if (i < size && j < size) {
            if (heap[i] < heap[j]) {
                return j;
            } else {
                return i;
            }
        } else if (i < size) {
            return i;
        } else if (j < size){
            return j;
        }
        return 0;
    }

    public void heapify(int pos) {
        curr = pos;
        while (leftIndex(curr) < size) {
            if (rightIndex(curr) < size) {
                if (heap[leftIndex(curr)] < heap[rightIndex(curr)]) {
                    if (heap[curr] == heap[rightIndex(curr)]) {
                        curr = rightIndex(curr);
                    }
                    else if (heap[curr] < heap[rightIndex(curr)]) {
                        swap(heap, curr, rightIndex(curr));
                        curr = rightIndex(curr);
                    } else {
                        curr = rightIndex(curr);
                    }
                } else if (heap[leftIndex(curr)] > heap[rightIndex(curr)]) {
                    if (heap[curr] == heap[leftIndex(curr)]) {
                        curr = leftIndex(curr);
                    }
                    else if (heap[curr] < heap[leftIndex(curr)]) {
                        swap(heap, curr, leftIndex(curr));
                        curr = leftIndex(curr);
                    } else {
                        curr = leftIndex(curr);
                    }
                } else {
                    if (heap[curr] < heap[leftIndex(curr)]) {
                        swap(heap, curr, leftIndex(curr));
                        curr = leftIndex(curr);
                    } else {
                        curr = leftIndex(curr);
                    }
                }
            } else {
                if (heap[curr] == heap[leftIndex(curr)]) {
                    curr = leftIndex(curr);
                }
                else if (heap[curr] < heap[leftIndex(curr)]) {
                    swap(heap, curr, leftIndex(curr));
                    curr = leftIndex(curr);
                } else {
                    curr = leftIndex(curr);
                }
            }
        }
    }

    public int leftIndex(int pos) {
       return (2 * pos) + 1;
    }

    public int rightIndex(int pos) {
        return (2 * pos) + 2;
    }

    public void insertElement(int num) {
        heap[size++] = num;
        curr = size - 1;
        while (heap[curr] > heap[parent(curr)]) {
            swap(heap, parent(curr), curr);
        }
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

    public void swap(int[] arr, int p, int c) {
        int tmp = arr[p];
        arr[p] = arr[c];
        arr[c] = tmp;
        curr = p;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
//        int[] arr = {3,7,2};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(arr));
    }
}
