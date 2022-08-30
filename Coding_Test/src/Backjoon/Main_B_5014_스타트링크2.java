package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_5014_스타트링크2 {

	static int F,S,G,U,D,answer;
	static boolean V [];
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/5014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());  // 총 층수
		S = Integer.parseInt(st.nextToken());  // 시작 위치
		G = Integer.parseInt(st.nextToken());  // 목적지
		U = Integer.parseInt(st.nextToken());  // U 층
		D = Integer.parseInt(st.nextToken());  // D 층
		
		answer = 0;
		
		V = new boolean[F+1];
		
		bfs(S);
		if (flag) {
			System.out.println(answer);
		}else {
			System.out.println("use the stairs");
		}


	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		V[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
//			System.out.print(temp + " ");
//			System.out.println(Arrays.toString(V));
			
			if (temp == G) {
				flag = true;
				return;
			}
			if (temp + U <= F && V[temp + U] == false) {
				temp += U;
				V[temp] = true;
				q.add(temp);
				answer++;
			}else if (temp - D > 0 && V[temp - D] == false) {
				temp -= D;
				V[temp] = true;
				q.add(temp);
				answer++;
			}else {
				continue;
			}
			
			
		}
		
		
	}

	
	
}




