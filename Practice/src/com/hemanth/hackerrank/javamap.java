package com.hemanth.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class javamap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	      int n=in.nextInt();
	      in.nextLine();
	      Map<String, Integer> map = new HashMap<String, Integer>();
	      for(int i=0;i<n;i++)
	      {
	         String name=in.nextLine();
	         int phone=in.nextInt();
	         map.put(name.toLowerCase(), phone);
	         in.nextLine();
	      }
	      System.out.println(map);
	      while(in.hasNext())
	      {
	         String s=in.nextLine();
	         if(map.containsKey(s)){
	        	 System.out.println(s+"="+map.get(s));
	         }
	         else{
	        	 System.out.println("Not found");
	         }
	      }
	}

}
