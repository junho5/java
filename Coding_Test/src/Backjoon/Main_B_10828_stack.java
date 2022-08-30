package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_10828_stack {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch(order) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					stack.add(num);
					break;
				case "top":
					if (stack.isEmpty()) {
						sb.append(-1);
						sb.append("\n");
					}else {
						sb.append(stack.peek());
						sb.append("\n");
					}
					break;
				case "size":
					sb.append(stack.size());
					sb.append("\n");
					break;
				case "empty":
					if (stack.isEmpty()) {
						sb.append(1);
						sb.append("\n");
					}else {
						sb.append(0);
						sb.append("\n");
					}
					break;
				case "pop":
					if (stack.isEmpty()) {
						sb.append(-1);
						sb.append("\n");
					}else {
						int pop_num = stack.pop();
						sb.append(pop_num);
						sb.append("\n");
					}
					break;
			}
		}
		System.out.println(sb.toString());
		
		
	}

	
}
