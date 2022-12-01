package Test;

import java.util.*;
import java.io.*;

public class Solution {
	
	static int tc,N,ans;
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
			map = new int [N][N];
			cost = new int [N][N];
			v = new boolean [N][N];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}
			
			bfs(0,0);
			
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int x, int y) {
		Queue<robot> q = new LinkedList<robot>();
		q.add(new robot(x, y));
		v[x][y] = true;
		cost[x][y] = 0;
		
		while(!q.isEmpty()) {
			robot temp = q.poll();
			
			if (temp.x == N-1 && temp.y == N-1) {
				ans = Math.min(ans, cost[N-1][N-1]);
			}
			
			for (int i = 0; i < 4; i++) {
				int mx = temp.x + dx[i];
				int my = temp.y + dy[i];
				
				if (mx < 0 || my < 0 || mx >= N || my >= N) continue;
				
				// 같으면 1
				if (map[temp.x][temp.y] == map[mx][my]) {
					if (!v[mx][my] || cost[mx][my] > cost[temp.x][temp.y] + 1) {
						v[mx][my] = true;
						cost[mx][my] = cost[temp.x][temp.y] + 1;
						q.add(new robot(mx, my));
					}
				// 낮으면 0
				} else if (map[temp.x][temp.y] > map[mx][my]) {
					if (!v[mx][my] || cost[mx][my] > cost[temp.x][temp.y]) {
						v[mx][my] = true;
						cost[mx][my] = cost[temp.x][temp.y];
						q.add(new robot(mx, my));
					}
				// 높으면 차의 2배
				} else if (map[temp.x][temp.y] < map[mx][my]) {
					int plus = map[mx][my] - map[temp.x][temp.y];
					if (!v[mx][my] || cost[mx][my] > cost[temp.x][temp.y] + plus * 2) {
						v[mx][my] = true;
						cost[mx][my] = cost[temp.x][temp.y] + plus * 2;
						q.add(new robot(mx, my));
					}
				}
			}
			
			
			
		}
		
	}


}
