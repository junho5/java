package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_11866_요세푸스0 {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		while(q.size() > 1) {
			for (int i = 1; i <= K; i++) {
				if (i == K) {
					int result = q.poll();
					sb.append(result);
					sb.append(", ");
				}else {
					int temp = q.poll();
					q.add(temp);
				}
			}
		}
		sb.append(q.poll());
		sb.append(">");
		
		System.out.println(sb.toString());
		
		
	}

	
}
