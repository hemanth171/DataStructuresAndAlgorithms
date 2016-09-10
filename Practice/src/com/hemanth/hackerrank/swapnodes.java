package com.hemanth.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(){
		data = 0;
		left = null;
		right = null;
	}
	
	public Node(int d){
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

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

class Swap{
	private Node root;
	private Deque<Node> insertQueue;
	private int height;
	
	public Swap(){
		root = new Node(1);
		insertQueue = new ArrayDeque<Node>();
		setDeque();
	}
	
	public void setDeque() {
		this.insertQueue.addFirst(root);
	}
	
	public void insert(String val){
		StringTokenizer st = new StringTokenizer(val);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(!(insertQueue.isEmpty())){
			insert(a, b, insertQueue.removeLast());
		}
	}
	
	public void insert(int a,int b,Node node){
		if(a != -1){
			node.left = new Node(a);
			insertQueue.addFirst(node.left);
		}
		if(b != -1){
			node.right = new Node(b);
			insertQueue.addFirst(node.right);
		}
	}
	
	public void findHeight(){
		height = findHeight(root) + 1;
		System.out.println(height);
	}
	
	public int findHeight(Node root){
		if(root == null){
			return -1;
		}
		return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	public void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
}

public class swapnodes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Swap swap = new Swap();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
			swap.insert(br.readLine());
		}
		swap.inOrder();
		swap.findHeight();
	}

}
