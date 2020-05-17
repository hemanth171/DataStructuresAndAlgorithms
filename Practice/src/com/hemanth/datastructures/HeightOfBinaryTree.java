package com.hemanth.datastructures;

public class HeightOfBinaryTree {

    static class BTreeNode {
        int data;
        BTreeNode left;
        BTreeNode right;

        BTreeNode() {
            this.data = 0;
        }

        BTreeNode(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    public static int heightOpt(BTreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = heightOpt(root.left);
        int rh = heightOpt(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode();
        root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.left.left.left = new BTreeNode(6);

        System.out.println(heightOpt(root));
    }
}
