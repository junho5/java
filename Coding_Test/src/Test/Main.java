package Test;


import java.util.*;

import java.io.*;

public class Main {
	
	static int F, S, G, U, D;
	static boolean [] V;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/5014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 총 층 수
		S = Integer.parseInt(st.nextToken()); // 시작 위치
		G = Integer.parseInt(st.nextToken()); // 목표 위치
		U = Integer.parseInt(st.nextToken()); // 올라가는 숫자
		D = Integer.parseInt(st.nextToken()); // 내려가는 숫자
		
		V = new boolean [F+1];
		V[0] = true;
		
		
		int result = bfs(S,0);
		
		if (result >= 0 ) {
			System.out.println(result);
		}else {
			System.out.println("use the stairs");
		}


	}

	private static int bfs(int now, int cnt) {
		Queue<floor> q = new LinkedList<floor>();
		q.add(new floor(now, cnt));
		V[now] = true;
		
		while(!q.isEmpty()) {
			floor temp = q.poll();
			int index = temp.now;
			int answer = temp.cnt;
			
			if (index == G) {
				return answer;
			}
			
			if (index + U <= F && V[index + U] == false) {
				V[index+U] = true;
				q.add(new floor(index + U, answer + 1));
			}
			
			if (index - D > 0 && V[index - D] == false) {
				V[index-D] = true;
				q.add(new floor(index - D , answer + 1));
				
			}
			
		}
		return -1;
		
	}

}

class floor{
	int now,cnt;

	public floor(int now, int cnt) {
		super();
		this.now = now;
		this.cnt = cnt;
	}
	
	
}
