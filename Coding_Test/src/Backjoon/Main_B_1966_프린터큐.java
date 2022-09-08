package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1966_프린터큐  {
	
	static int N,M,cnt;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			Queue<Integer> q = new LinkedList<>();
			Queue<Integer> index = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 개수
			M = Integer.parseInt(st.nextToken()); // 궁금한 index (0~~~)
			
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			for (int j = 0; j < N; j++) {
				index.add(j);
			}
			cnt = 0;
			while(!q.isEmpty()) {
				int max = Integer.MIN_VALUE;
				
				for (int data : q) {
					if (max < data) {
						max = data;
					}
				}
				
				int range = q.size();
				for (int j = 0; j < range; j++) {
					if(q.peek() == max) {
						cnt++;
						q.remove();
						int answer = index.remove();
						if (answer == M) {
							System.out.println(cnt);
						}
//						System.out.println(answer);
						break;
					}else {
						int temp = q.remove();
						q.add(temp);
						int answer = index.remove();
						index.add(answer);
					}
					
				}
//				System.out.println(q);
//				System.out.println(index);
			}
			
			
		}
		
	}

}
