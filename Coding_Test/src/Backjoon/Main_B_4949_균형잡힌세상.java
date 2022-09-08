package Backjoon;

import java.util.*;
import java.io.*;
 
public class Main_B_4949_균형잡힌세상 {
	
	static boolean answer;
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String temp = br.readLine();
			if (temp.equals(".")) break;
			boolean flag = true;
			
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < temp.length(); i++) {
				
				if (temp.charAt(i) == '(' || temp.charAt(i) == '[') {
					stack.push(temp.charAt(i));
				}else if (temp.charAt(i) == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						flag = false;
					}else {
						stack.pop();
					}
				}else if (temp.charAt(i) == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						flag = false;
					}else {
						stack.pop();
					}
				}
				
				if (!flag) break;
				
			}
			
			if (!flag) {
				answer = false;
			}else if (stack.isEmpty()) {
				answer = true;
			}else if (!stack.isEmpty()) {
				answer = false;
			}
			
			if (answer) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
 
}