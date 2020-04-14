package com.hemanth.leetcode;

import java.util.Stack;

/*
* Min Stack
*
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
*
* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.
*
* MinStack minStack = new MinStack();
* minStack.push(-2);
* minStack.push(0);
* minStack.push(-3);
* minStack.getMin();   --> Returns -3.
* minStack.pop();
* minStack.top();      --> Returns 0.
* minStack.getMin();   --> Returns -2.
*
* Input:
* ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
* [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

* Output:
* [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483646,-2147483648,null,-2147483648]

* Expected:
* [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
*
*
*/

public class MinStack {
    Stack<Integer> stack;
    int minEle;

    public MinStack() {
        stack = new Stack<>();
        minEle = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            minEle = x;
            stack.push(x);
            return;
        }
        if (x <= minEle) {
            if (x == -2147483648) {
                stack.push(x);
                minEle = x;
            } else {
                int t = (x * 2) - minEle;
                stack.push(t);
                minEle = x;
            }
        } else {
            stack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int p = stack.pop();
            if (p <= minEle) {
                int sub = minEle * 2;
                if (minEle == -2147483648) {
                    sub = -1;
                }
                minEle = sub - (p);
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            int top = stack.peek();
            if (top < minEle) {
                return minEle;
            }
            return top;
        }
        return 0;
    }

    public int getMin() {
        return minEle;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());

//        s.push(3);
//        s.push(5);
//        s.getMin();
//        s.push(2);
//        s.push(1);
//        s.getMin();
//        s.pop();
//        s.getMin();
//        s.pop();
//        s.top();

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
