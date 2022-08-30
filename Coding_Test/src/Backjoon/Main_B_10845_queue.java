package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_10845_queue {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int last = 0;
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch(order) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					last = num;
					queue.add(num);
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append(-1);
						sb.append("\n");
					}else {
						sb.append(queue.peek());
						sb.append("\n");
					}
					break;
				case "size":
					sb.append(queue.size());
					sb.append("\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						sb.append(1);
						sb.append("\n");
					}else {
						sb.append(0);
						sb.append("\n");
					}
					break;
				case "pop":
					if (queue.isEmpty()) {
						sb.append(-1);
						sb.append("\n");
					}else {
						int pop_num = queue.poll();
						sb.append(pop_num);
						sb.append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						sb.append(-1);
						sb.append("\n");
					}else {
						sb.append(last);
						sb.append("\n");
					}
					break;
			}
		}
		System.out.println(sb.toString());
		
		
	}

	
}
