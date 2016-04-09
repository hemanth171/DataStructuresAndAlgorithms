package com.hemanth.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class javastack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> s = new Stack<Character>();
	      
	      while (sc.hasNext()) {
	         String input=sc.next();	         
	         for(int i=0;i<input.length();i++){
	        	 char ch = input.charAt(i);
	        	 if(ch == '(' || ch == '{' || ch == '['){
	        		 s.push(ch);
	        	 }
	        	 else if(ch == ')'){
	        		 if(!s.isEmpty()){	        			 	        		
	        		 if(s.peek() == '('){
	        			 s.pop();
	        		 }
	        		 }
	        		 else{
	        			 s.push(ch);	        			 
	        		 }
	        	 }
	        	 else if(ch == '}'){
	        		 if(!s.isEmpty()){
	        		 if(s.peek() == '{'){
	        			 s.pop();
	        		 }}
	        		 else{
	        			 s.push(ch);	        			 
	        		 }
	        	 }
	        	 else if(ch == ']'){
	        		 if(!s.isEmpty()){
	        		 if(s.peek() == '['){
	        			 s.pop();
	        		 }}
	        		 else{
	        			 s.push(ch);	        			 
	        		 }
	        	 }
	         }	         
	         if(s.isEmpty()){
	        	 System.out.println(true);
	         }
	         else{
	        	 System.out.println(false);
	         }
	         s.clear();
	         
	      }

	}

}
