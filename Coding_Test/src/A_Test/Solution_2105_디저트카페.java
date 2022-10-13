package A_Test;

import java.util.*;
import java.io.*;

public class Solution_2105_디저트카페 {
	
	static int tc;
	static int N, Max;
	static int [][] map;
	static boolean [] V;
	static int [] dx = { -1, -1, 1, 1 }; 
	static int [] dy = { -1, 1, 1, -1 }; 
	
	static class food{
		int x,y,dir,t;

		public food(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			t = map[x][y];
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			Max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					V = new boolean [101];
					food food = new food(i, j, 0);
					find(food,food);
				}
			}
			
			if (Max < 0) Max = -1;
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(Max);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void find(food start, food current) {
		if (current.dir == 4) {
			if (start.x == current.x && start.y == current.y) {
				int cnt = 0;
				for (int i = 0; i < V.length; i++) {
					if(V[i] == true) {
						cnt++;
					}
				}
				Max = Math.max(cnt, Max);
			}
			return;
		}
		
		int nx = current.x + dx[current.dir];
		int ny = current.y + dy[current.dir];
		
		if (nx < 0 || ny < 0 || nx >= N || ny >= N) return;
			if(V[map[nx][ny]] == false) {
				V[map[nx][ny]] = true;
				
				food straight = new food(nx, ny, current.dir);
				find(start,straight);
				
				food turn = new food(nx, ny, current.dir+1);
				find(start,turn);
				
				V[map[nx][ny]] = false;
			}
		}


}
