package com.hemanth.datastructures;

class AVLNode{
	int data;
	int height;
	AVLNode left;
	AVLNode right;
	
	public AVLNode(){
		data = 0;
		height = 0;
		left = null;
		right = null;
	}
	
	public AVLNode(int d){
		data = d;
		height = 0;
		left = null;
		right = null;
	}
}

class AVL{
	private AVLNode root;
	
	public int height(AVLNode t){
		return t == null ? -1 : t.height;
	}
	public int max(int lhs, int rhs){
		return lhs > rhs ? lhs : rhs;
	}
	
	public AVLNode insert(int x, AVLNode t){
		if(t == null){
			t = new AVLNode(x);
		}
		else if(x < t.data){
			t.left = insert(x, t.left);
			if((height(t.left) - height(t.right)) == 2){
				if(x < t.left.data){
					t = rotateWithLeftChild(t);
				} else {
					t = doubleWithLeftChild(t);
				}
			}
		}
		else if(x > t.data){
			t.right = insert(x, t.right);
			if((height(t.right) - height(t.left)) == 2){
				if(x > t.right.data){
					t = rotateWithRightChild(t);
				} else {
					t = doubleWithRightChild(t);
				}
			}
		}
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}
	
	public AVLNode rotateWithLeftChild(AVLNode k2){
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}
	
	public AVLNode rotateWithRightChild(AVLNode k1){
		AVLNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.left), k1.height) + 1;
		return k2;
	}
	
	public AVLNode doubleWithLeftChild(AVLNode k3){
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	
	public AVLNode doubleWithRightChild(AVLNode k1){
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	
	public void preOrder(){
		preOrder(root);
	}
	
	public void preOrder(AVLNode r){
		if(r != null){
			System.out.println(r.data+" ");
			preOrder(r.left);
			preOrder(r.right);
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	public void inOrder(AVLNode r){
		if(r != null){
			inOrder(r.left);
			System.out.println(r.data+" ");
			inOrder(r.right);
		}
	}
	
	public void postOrder(){
		postOrder(root);
	}
	
	public void postOrder(AVLNode r){
		if(r != null){
			postOrder(r.left);
			postOrder(r.right);
			System.out.println(r.data+" ");
		}
	}
	
	public void display(){
		System.out.print("\nPre Order:");
		preOrder();
		System.out.print("\nIn Order:");
		inOrder();
		System.out.print("\nPost Order:");
		postOrder();
	}
}

public class AVLTree {

	public static void main(String[] args) {
		

	}

}
