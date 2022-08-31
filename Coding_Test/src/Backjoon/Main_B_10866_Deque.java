package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_10866_Deque {
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/10866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			String menu = st.nextToken();
			switch(menu) {
			case "push_back":
				int num1 = Integer.parseInt(st.nextToken());
				q.addLast(num1);
				break;
				
			case "push_front":
				int num2 = Integer.parseInt(st.nextToken());
				q.addFirst(num2);
				break;
				
			case "front":
				if (q.size() <= 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.peek());
				}
				break;
				
			case "back":
				if (q.size() <= 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.peekLast());
				}
				break;
				
			case "size":
				System.out.println(q.size());
				break;
				
			case "empty":
				boolean check = q.isEmpty();
				if (check) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
				
			case "pop_front":
				if (q.size() <= 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.pollFirst());
				}
				break;
				
			case "pop_back":
				if (q.size() <= 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.pollLast());
				}
				break;
				
			}
			
		}
		

			
	}

		



}


	
	



