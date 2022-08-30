package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_5014_스타트링크1 {

	static int F,S,G,U,D,answer;
	static boolean V [];
	static boolean flag;
	static int [] deltas;
	
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
		
		
		V = new boolean[F+1];
		deltas = new int [] {U,D};
		
		answer = bfs(S);
		
		if (answer >= 0) {
			System.out.println(answer);
		}else {
			System.out.println("use the stairs");
		}
		
	}

	private static int bfs(int start) {
		Queue<floor> q = new LinkedList<floor>();
		V[start] = true;
		q.add(new floor(start,0));
		
		while(!q.isEmpty()) {
			floor temp = q.poll();
			
			if (temp.start == G) {
				return temp.answer;
			}
			
			if (temp.start + U <= F && V[temp.start + U] == false) {
				V[temp.start + U] = true;
				q.add(new floor(temp.start + U, temp.answer+1));
			}
			
			if (temp.start - D > 0 && V[temp.start -D] == false) {
				V[temp.start - D] = true;
				q.add(new floor(temp.start - D, temp.answer+1));
			}
			
			
		}
		return -1;
		
		
	}

	
	
}

class floor{
	int start,answer;

	public floor(int start, int answer) {
		super();
		this.start = start;
		this.answer = answer;
	}
}




