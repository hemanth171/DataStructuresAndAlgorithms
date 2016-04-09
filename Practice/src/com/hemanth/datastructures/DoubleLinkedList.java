package com.hemanth.datastructures;

import java.util.Scanner;

public class DoubleLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		doublyLinkedList dList = new doublyLinkedList();
		char ch;
		do{
			System.out.println("1. Insert at Begining");
			System.out.println("2. Insert at End");
			System.out.println("3. Display");
			System.out.println("4. Reverse List");
			System.out.println("5. Insert At Position");
			System.out.println("6. Remove At Position");
			
			switch(sc.nextInt()){
			case 1:
				System.out.println("Enter the data to be inserted");
				int d1 = sc.nextInt();
				dList.insertAtBeg(d1);
				break;
			case 2:
				System.out.println("Enter the data to be inserted");
				int d2 = sc.nextInt();
				dList.insertAtEnd(d2);
				break;
			case 3:
				dList.display();
				break;
			case 4:
				dList.reverseList();
				break;
			case 5:
				System.out.println("Enter the data to be inserted");
				int d3 = sc.nextInt();
				System.out.println("Enter the position");
				int pos = sc.nextInt();
				if((pos > 0) && (pos <= dList.getSize())){
					dList.insertAtPosition(d3, pos);
				}
				else{
					System.out.println("Invalid position");
				}
				break;
			case 6:
				System.out.println("Enter the position to be removed");
				int position = sc.nextInt();
				dList.removAtPosition(position);
				break;
			}
			System.out.println("\nDo you want to continue (Y/N):");
			ch = sc.next().charAt(0);
		}while(ch == 'y' || ch == 'Y');
	}

}

class Node{
	int data;
	Node left;
	Node right;
	
	Node(){
		data = 0;
		left = null;
		right = null;
	}
	
	Node(int d){
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

class doublyLinkedList{
	int size;
	Node start;
	Node end;
	
	doublyLinkedList(){
		size = 0;
		start = null;
		end = null;
	}
	
	int getSize(){
		return size;
	}
	
	void insertAtBeg(int d){
		Node nptr = new Node(d);
		if(start == null){
			start = nptr;
			end = nptr;
		}
		else{
			start.setLeft(nptr);
			nptr.setRight(start);
			start = nptr;
		}
		size++;
		display();
	}
	
	void insertAtEnd(int d){
		Node nptr = new Node(d);
		if(end == null){
			start = nptr;
			end = nptr;
		}
		else{
			end.setRight(nptr);
			nptr.setLeft(end);
			end = nptr;
		}
		size++;
		display();
	}
	
	void insertAtPosition(int d,int pos){
		if(pos == 1){
			insertAtBeg(d);
		}
		else if(pos == size){
			insertAtEnd(d);
		}
		else{
			pos = pos - 1;
			Node nptr = new Node(d);
			Node tmp = start;
			for(int i=1;i<size;i++){
				if(i == pos){
					nptr.setLeft(tmp);
					tmp = tmp.getRight();
					tmp.setLeft(nptr);
					nptr.setRight(tmp);
					tmp = nptr.getLeft();
					tmp.setRight(nptr);
				}
				else{
					tmp = tmp.getRight();
				}
			}
			size++;
			display();
		}
		
	}
	
	void removAtPosition(int pos){
		pos = pos -1;
		Node tmp1 = start;
		Node tmp2;
		for(int i=1;i<size;i++){
			if(i == pos){
				tmp2 = tmp1.getRight();
				tmp1.setRight(tmp2.getRight());
				tmp2.setLeft(null);
				tmp2.setRight(null);
				tmp2 = tmp1.getRight();
				tmp2.setLeft(tmp1);
			}
			else{
				tmp1 = tmp1.getRight();
			}
		}
		size--;
		display();
	}
	
	void display(){
		if(size == 0){
			System.out.println("List is empty");
		}
		else{
			Node tmp = start;
			System.out.print(tmp.getData());
			while(tmp.getRight() != null){
				tmp = tmp.getRight();
				System.out.print("->");
				System.out.print(tmp.getData());
			}
		}
	}
	
	void reverseList(){
		if(size == 0){
			System.out.println("List is empty");
		}
		else{
			Node tmp = end;
			System.out.print(tmp.getData());
			while(tmp.getLeft() != null){
				tmp = tmp.getLeft();
				System.out.print("->");
				System.out.print(tmp.getData());
			}
		}
	}
}
