package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1874_스택수열 {
	

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1874.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int perm = 1;
		int cnt = 0;
		boolean flag = true;
		
		while(perm <= tc) {
			int num = Integer.parseInt(br.readLine());
			cnt ++;
			
			if (stack.isEmpty()) {
				for (int i = perm; i <= num; i++) {
					stack.add(i);
					sb.append("+");
					sb.append("\n");
					perm++;
				}
				stack.pop();
				sb.append("-");
				sb.append("\n");
			}else if (stack.peek() == num) {
				stack.pop();
				sb.append("-");
				sb.append("\n");
			}else if (stack.peek() > num) {
				int temp = stack.pop();
				sb.append("-");
				sb.append("\n");
				if (temp != num) {
					flag = false;
				}
			}else if (stack.peek() < num){
				for (int i = perm; i <= num; i++) {
					stack.add(i);
					sb.append("+");
					sb.append("\n");
					perm++;
				}
				stack.pop();
				sb.append("-");
				sb.append("\n");
			}
//			System.out.println(flag);
//			System.out.println(stack);
		}
//		System.out.println(flag);
//		System.out.println(cnt);
		if (flag) {
			for (int i = cnt; i < tc; i++) {
				int compare = Integer.parseInt(br.readLine());
				if (compare != stack.pop()) {
					flag = false;
				}else {
					sb.append("-");
					sb.append("\n");
				}
			}
		}
		
		if (flag) {
			System.out.println(sb.toString());
		}else {
			System.out.println("NO");
		}
		
	}

	
}
