package com.hemanth.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Node
class SummativeNode {
	int time, weight;
	SummativeNode left, right;
	
	public SummativeNode() {
		time = 0;
		weight = 0;
		left = null;
		left = null;
	}
	
	public SummativeNode (int w, int t){
		time = t;
		weight = w;
		left = null;
		right = null;
	}
}

//Node Tree
class NodeTree {
	private SummativeNode root;
	
	public NodeTree() {
		root = null;
	}
	
	public void construct(int weight, int time){
		root = construct(root, weight, time);
	}
	// To construct the tree
	private SummativeNode construct(SummativeNode root, int weight, int time) {
		if(root == null) {
			root = new SummativeNode(weight, time);
			return root;
		}
		SummativeNode temp = new SummativeNode(weight, time);
		SummativeNode parent = new SummativeNode();
		parent.weight = root.weight + temp.weight;
		parent.time = Math.max(root.time, temp.time);
		parent.left = root;
		parent.right = temp;
		return parent;
	}
	
	//Method to search
	public void search(int time) {
		search(root, time);
	}
	//To return the summative value
	private void search(SummativeNode root, int time) {
		if (root != null) {
			if(root.time <= time) {
				System.out.println(root.weight);
			} else if (root.time > time) {
				search(root.left, time);
			}
		}
	}
}

public class SummativeWeightBasedOnTime {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		NodeTree tree = new NodeTree();
		for (int i=0;i<input;i++) {
			int type = Integer.parseInt(br.readLine());
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			
			if (type == 1) {
				tree.construct(a, b);
			} else if (type == 2){
				tree.search(a);
			}
		}

	}

}
