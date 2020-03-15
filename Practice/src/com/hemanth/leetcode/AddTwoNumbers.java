package com.hemanth.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        BigInteger n1 = new BigInteger("0");
//        BigInteger n2 = new BigInteger("0");

//        Callable<Void> callable1 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                BigInteger n1 = sumList(l1);
//                return null;
//            }
//        };
//
//        Callable<Void> callable2 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                BigInteger n2 = sumList(l2);
//                return null;
//            }
//        };
//
//        List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
//        taskList.add(callable1);
//        taskList.add(callable2);
//
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        try
//        {
//            //start the threads and wait for them to finish
//            executor.invokeAll(taskList);
//        }
//        catch (InterruptedException ie)
//        {
//            //do something if you care about interruption;
//        }

//        Thread t1 = new Thread() {
//            BigInteger n1 = new BigInteger("0");
//          public void run() {
//              n1 = sumList(l1);
//          }
//        };
//        Thread t2 = new Thread() {
//            BigInteger n2 = new BigInteger("0");
//            public void run() {
//                n2 = sumList(l2);
//            }
//        };
//        t1.start();
//        t2.start();
////        BigInteger n1 = sumList(l1);
////        BigInteger n2 = sumList(l2);
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        CompletableFuture<BigInteger> one = CompletableFuture
                .supplyAsync(() -> sumList(l1));
        CompletableFuture<BigInteger> two = CompletableFuture
                .supplyAsync(() -> sumList(l2));

        BigInteger tot = null;
        try {
            tot = one.get().add(two.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String v = tot.toString();

        ListNode head = new ListNode(Character.getNumericValue(v.charAt(v.length()-1)));
        ListNode tail = head;
        for (int i=v.length()-2; i>=0; i--) {
            tail.next = new ListNode(Character.getNumericValue(v.charAt(i)));
            tail = tail.next;
        }
        return head;
    }

    public static BigInteger sumList(ListNode l) {
        BigInteger num = BigInteger.valueOf(l.val);
        BigInteger mul = BigInteger.valueOf(10);
        while (l.next != null) {
            l = l.next;
            int tmp = l.val;
            num = mul.multiply(BigInteger.valueOf(tmp)).add(num);
            mul = mul.multiply(new BigInteger("10"));
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}
