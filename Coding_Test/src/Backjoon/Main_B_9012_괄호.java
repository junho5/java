package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_9012_괄호 {
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/9012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			Stack<Character> s = new Stack<>();
			char [] arr = br.readLine().toCharArray();
			
			for (int j = 0; j < arr.length; j++) {
				s.push(arr[j]);
			}
			
//			System.out.println(s);
			
			boolean flag = true;
			int index = 1;
			int check = 0;
			
			while(!s.isEmpty()) {
				char temp = s.pop();
				
				if (check < 0) {
					flag = false;
					break;
				}
				
				if (index == 1 && temp =='(') {
					flag = false; 
					break;
				}
				
				if (temp == ')') {
					check++; 
					index++;
				}
				
				if (temp == '(') {
					check--;
					index++;
					if (check > 0 && s.peek() == ')') {
						flag = false;
						break;
					}
				}
				
			}
			
			System.out.println(flag);
			
			
			
		}
		

			
	}

		



}


	
	



