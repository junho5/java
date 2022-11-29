package Test;

import java.util.*;
import java.io.*;

public class 산악구조로봇 {
	
	static int tc, N, ans;
	static int [][] map,cost;
	static boolean [][] v;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static class robot{
		int x,y;

		public robot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cost = new int[N][N];
			v = new boolean[N][N];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(0,0);
//			System.out.println(ans);
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int x, int y) {
		Queue<robot> q = new LinkedList<>();
		q.add(new robot(x, y));
		v[x][y] = true;
		cost[x][y] = 0;
		
		while(!q.isEmpty()) {
			robot temp = q.poll();
			
			// 목적지 도착시 값 비교
			if (temp.x == N-1 && temp.y == N-1) {
				ans = Math.min(ans, cost[N-1][N-1]);
			}
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int m_x = temp.x + dx[i];
				int m_y = temp.y + dy[i];
				
				// 범위가 넘어갈 경우 넘기기
				if (m_x < 0 || m_y < 0 || m_x >=N || m_y >= N) continue;
				
				// 높이가 같을 경우  -> 1
				if(map[temp.x][temp.y] == map[m_x][m_y]) {
					// 방문을 안했거나 값이 더 작을 경우
					if(!v[m_x][m_y] || cost[m_x][m_y] > cost[temp.x][temp.y] + 1) {
						v[m_x][m_y] = true;
						cost[m_x][m_y] = cost[temp.x][temp.y] + 1;
						q.add(new robot(m_x, m_y));
					}
					
				// 높이가 낮을 경우 -> 0
				}else if(map[temp.x][temp.y] > map[m_x][m_y]) {
					// 방문을 안했거나 값이 더 작을 경우
					if(!v[m_x][m_y] || cost[m_x][m_y] > cost[temp.x][temp.y]) {
						v[m_x][m_y] = true;
						cost[m_x][m_y] = cost[temp.x][temp.y];
						q.add(new robot(m_x, m_y));
					}
				// 높이가 높을 경우 -> 차의 2배
				}else if(map[temp.x][temp.y] < map[m_x][m_y]) {
					int plus = map[m_x][m_y] - map[temp.x][temp.y];
					// 방문을 안했거나 값이 더 작을 경우
					if(!v[m_x][m_y] || cost[m_x][m_y] > cost[temp.x][temp.y] + plus * 2) {
						v[m_x][m_y] = true;
						cost[m_x][m_y] = cost[temp.x][temp.y] + plus * 2;
						q.add(new robot(m_x, m_y));
					}
				}
			}
		}
	}

}
