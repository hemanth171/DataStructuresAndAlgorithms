package com.hemanth.datastructures;

import java.util.Scanner;

class BTNode{
	int data;
	BTNode left;
	BTNode right;
	
	public BTNode(){
		data = 0;
		left = null;
		right = null;
	}
	public BTNode(int d){
		data = d;
		left = null;
		right = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BTNode getLeft() {
		return left;
	}
	public void setLeft(BTNode left) {
		this.left = left;
	}
	public BTNode getRight() {
		return right;
	}
	public void setRight(BTNode right) {
		this.right = right;
	}
}

class BT{
	private BTNode root;
	
	public BT(){
		root = null;
	}
	
	public void insert(int data){
		root = insert(root,data);
	}
	
	public BTNode insert(BTNode node, int d){
		if(node == null){
			node = new BTNode(d);
		} else {
			if(node.getRight() == null){
				node.right = insert(node.right,d);
			} else {
				node.left = insert(node.left,d);
			}
		}
		return node;
	}
	
	public void countNodes(){
		System.out.println("No of nodes is: "+countNodes(root));
	}
	
	public int countNodes(BTNode r){
		if(r == null){
			return 0;
		} else {
			int l = 1;
			l+=countNodes(r.getLeft());
			l+=countNodes(r.getRight());
			return l;
		}
	}
	
	public void preOrder(){
		preOrder(root);
	}
	
	public void preOrder(BTNode r){
		if(r != null){
			System.out.println(r.getData()+" ");
			preOrder(r.getLeft());
			preOrder(r.getRight());
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	public void inOrder(BTNode r){
		if(r != null){
			inOrder(r.getLeft());
			System.out.println(r.getData()+" ");
			inOrder(r.getRight());
		}
	}
	
	public void postOrder(){
		postOrder(root);
	}
	
	public void postOrder(BTNode r){
		if(r != null){
			postOrder(r.getLeft());
			postOrder(r.getRight());
			System.out.println(r.getData()+" ");
		}
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BT bt = new BT();
		char ch;
		do{
			System.out.println("1. Insert");
			System.out.println("2. Count Nodes");
			
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1: 
					System.out.println("Enter the element to be inserted");
					bt.insert(sc.nextInt());
					break;
				
				case 2:
					bt.countNodes();
					break;
				
				default:
					System.out.println("Wrong entry");
					break;
			}
			System.out.print("\nPre Order:");
			bt.preOrder();
			System.out.print("\nIn Order:");
			bt.inOrder();
			System.out.print("\nPost Order:");
			bt.postOrder();
			
			System.out.println("Do you want to continue:");
			ch = sc.next().charAt(0);
		} while(ch == 'y' || ch == 'Y');
	}

}
