package com.hemanth.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	
	public BSTNode(){
		data = 0;
		left = null;
		right = null;
	}
	public BSTNode(int d){
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
	public BSTNode getLeft() {
		return left;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
}

class BST{
	private BSTNode root;
	private Deque<BSTNode> deque = new ArrayDeque<BSTNode>();
	
	public BST(){
		root = null;
	}
	
	public void insert(int data){
		root = insert(root,data);
	}
	
	public BSTNode insert(BSTNode node, int d){
		if(node == null){
			node = new BSTNode(d);
		} else {
			if(node.getData() < d){
				node.right = insert(node.right, d);
			} else {
				node.left = insert(node.left,d);
			}
		}
		return node;
	}
	
	public void countNodes(){
		System.out.println("No of nodes is: "+countNodes(root));
	}
	
	public int countNodes(BSTNode r){
		if(r == null){
			return 0;
		} else {
			int l = 1;
			l+=countNodes(r.getLeft());
			l+=countNodes(r.getRight());
			return l;
		}
	}
	
	public boolean search(int d){
		return search(root,d);
	}
	
	public boolean search(BSTNode r,int d){
		if(r != null && r.getData() == d){
			return true;
		}
		if(r != null && r.getData()<d){
			if(search(r.right,d)){
				return true;
			}
		}
		if(r != null && r.getData()>d){
			if(search(r.left,d)){
				return true;
			}
		}
		return false;
	}
	
	public void findHeight(){
		System.out.println("Height of tree is: "+findHeight(root));
	}
	
	public int findHeight(BSTNode r){
		if(r == null){
			return -1;
		}
		return Math.max(findHeight(r.getLeft()), findHeight(r.getRight())) + 1;
	}
	
	public void levelOrderTraversal(){
		levelOrderTraversal(root);
	}
	
	public void levelOrderTraversal(BSTNode r){
		if(r != null){
			System.out.print(r.getData()+" ");
			if(r.getLeft() != null){
				deque.addFirst(r.getLeft());
			}
			if(r.getRight() != null){
				deque.addFirst(r.getRight());
			}
			if(deque.isEmpty()){
				return;
			} else {
				levelOrderTraversal(deque.removeLast());
			}
		}
	}
	
	public void preOrder(){
		preOrder(root);
	}
	
	public void preOrder(BSTNode r){
		if(r != null){
			System.out.println(r.getData()+" ");
			preOrder(r.getLeft());
			preOrder(r.getRight());
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	public void inOrder(BSTNode r){
		if(r != null){
			inOrder(r.getLeft());
			System.out.println(r.getData()+" ");
			inOrder(r.getRight());
		}
	}
	
	public void postOrder(){
		postOrder(root);
	}
	
	public void postOrder(BSTNode r){
		if(r != null){
			postOrder(r.getLeft());
			postOrder(r.getRight());
			System.out.println(r.getData()+" ");
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

public class BinarySearchTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BST bt = new BST();
		char ch;
		do{
			System.out.println("1. Insert");
			System.out.println("2. Count Nodes");
			System.out.println("3. Search");
			System.out.println("4. Level Order Traversal");
			System.out.println("5. Find height of tree");
			
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1: 
					System.out.println("Enter the element to be inserted");
					//bt.insert(sc.nextInt());
					bt.insert(19);
					bt.insert(2);
					bt.insert(22);
					bt.insert(1);
					bt.insert(7);
					bt.insert(17);
					bt.insert(29);
					bt.display();
					break;
				
				case 2:
					bt.countNodes();
					break;
					
				case 3:
					System.out.println("Enter the element to be searched");
					System.out.println(bt.search(sc.nextInt()));
					break;
					
				case 4:
					bt.levelOrderTraversal();
					break;
					
				case 5:
					bt.findHeight();
					break;
				
				default:
					System.out.println("Wrong entry");
					break;
			}
			
			System.out.println("Do you want to continue:");
			ch = sc.next().charAt(0);
		} while(ch == 'y' || ch == 'Y');
	}

}
