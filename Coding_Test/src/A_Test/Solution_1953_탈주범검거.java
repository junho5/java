package A_Test;

import java.util.*;
import java.io.*;

public class Solution_1953_탈주범검거 {

	static int tc;
	static int N,M,X,Y,TIME,ans;
	static int[][] map;
	static boolean[][] V;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Hole> q;
	
	static class Hole{
		int x,y,dir;

		public Hole(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로
			M = Integer.parseInt(st.nextToken()); // 세로
			X = Integer.parseInt(st.nextToken()); // x 좌표
			Y = Integer.parseInt(st.nextToken()); // y 좌표
			TIME = Integer.parseInt(st.nextToken()); // 시간
			
			map = new int [N][M];
			V = new boolean [N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			print(map);
			bfs(X,Y,map[X][Y]);
			print2(V);
//			System.out.println(sumHole(V));
			
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(sumHole(V));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}


	private static int sumHole(boolean[][] v) {
		ans = 0;
		for (boolean [] data_arr : v) {
			for (boolean data : data_arr) {
				if (data == true) ans++;
			}
		}
		return ans;
	}


	private static void bfs(int x, int y, int dir) {
		q = new LinkedList<Hole>();
		q.add(new Hole(x, y, dir));
		V[x][y] = true;
		
		int turn = 1;
		if (turn == TIME) return;
		
		while(!q.isEmpty()) {
			turn++;
			if (turn > TIME) break;
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Hole temp = q.poll();
				int type = temp.dir;
				switch (type) {
				// 상하좌우
				case 1:
					for (int j = 0; j < 4; j++) {
						int h_x = temp.x + dx[j];
						int h_y = temp.y + dy[j];
						
						if (h_x < 0 || h_y < 0 || h_x >= N || h_y >= M) continue;
						if (V[h_x][h_y] == true || map[h_x][h_y] == 0) continue;
						int o_type = map[h_x][h_y];
						if (j == 0 && (o_type == 3 || o_type == 4 || o_type == 7)) continue;
						if (j == 1 && (o_type == 3 || o_type == 5 || o_type == 6)) continue;
						if (j == 2 && (o_type == 2 || o_type == 6 || o_type == 7)) continue;
						if (j == 3 && (o_type == 2 || o_type == 4 || o_type == 5)) continue;
						
						V[h_x][h_y] = true;
						q.add(new Hole(h_x, h_y, map[h_x][h_y]));
					}
					break;
				// 상하
				case 2:
					for (int j = 0; j < 2; j++) {
						int h_x = temp.x + dx[j];
						int h_y = temp.y + dy[j];
						if (h_x < 0 || h_y < 0 || h_x >= N || h_y >= M) continue;
						if (V[h_x][h_y] == true || map[h_x][h_y] == 0) continue;
						int o_type = map[h_x][h_y];
						
						if (j == 0 && (o_type == 3 || o_type == 4 || o_type == 7)) continue;
						if (j == 1 && (o_type == 3 || o_type == 5 || o_type == 6)) continue;
						
						V[h_x][h_y] = true;
						q.add(new Hole(h_x, h_y, map[h_x][h_y]));
					}
					break;
				// 좌우
				case 3:
					for (int j = 2; j < 4; j++) {
						int h_x = temp.x + dx[j];
						int h_y = temp.y + dy[j];
						if (h_x < 0 || h_y < 0 || h_x >= N || h_y >= M) continue;
						if (V[h_x][h_y] == true || map[h_x][h_y] == 0) continue;
						int o_type = map[h_x][h_y];
						
						if (j == 2 && (o_type == 2 || o_type == 6 || o_type == 7)) continue;
						if (j == 3 && (o_type == 2 || o_type == 4 || o_type == 5)) continue;
						
						V[h_x][h_y] = true;
						q.add(new Hole(h_x, h_y, map[h_x][h_y]));
					}
					break;
				// 상우
				case 4:
					for (int j = 0; j < 4; j++) {
						if (j == 0 || j == 3) {
							int h_x = temp.x + dx[j];
							int h_y = temp.y + dy[j];
							if (h_x < 0 || h_y < 0 || h_x >= N || h_y >= M) continue;
							if (V[h_x][h_y] == true || map[h_x][h_y] == 0) continue;
							int o_type = map[h_x][h_y];
							
							if (j == 0 && (o_type == 3 || o_type == 4 || o_type == 7)) continue;
							if (j == 3 && (o_type == 2 || o_type == 4 || o_type == 5)) continue;
							
							V[h_x][h_y] = true;
							q.add(new Hole(h_x, h_y, map[h_x][h_y]));
						}
					}
					break;
				// 하우
				case 5:
					for (int j = 0; j < 4; j++) {
						if (j == 1 || j == 3) {
							int h_x = temp.x + dx[j];
							int h_y = temp.y + dy[j];
							if (h_x < 0 || h_y < 0 || h_x >= N || h_y >= M) continue;
							if (V[h_x][h_y] == true || map[h_x][h_y] == 0) continue;
							int o_type = map[h_x][h_y];
							
							if (j == 1 && (o_type == 3 || o_type == 5 || o_type == 6)) continue;
							if (j == 3 && (o_type == 2 || o_type == 4 || o_type == 5)) continue;
							
							V[h_x][h_y] = true;
							q.add(new Hole(h_x, h_y, map[h_x][h_y]));
						}
					}
					break;
				// 하좌
				case 6:
					for (int j = 0; j < 4; j++) {
						if (j == 1 || j == 2) {
							int h_x = temp.x + dx[j];
							int h_y = temp.y + dy[j];
							if (h_x < 0 || h_y < 0 || h_x >= N || h_y >= M) continue;
							if (V[h_x][h_y] == true || map[h_x][h_y] == 0) continue;
							int o_type = map[h_x][h_y];
							
							if (j == 1 && (o_type == 3 || o_type == 5 || o_type == 6)) continue;
							if (j == 2 && (o_type == 2 || o_type == 6 || o_type == 7)) continue;
							
							V[h_x][h_y] = true;
							q.add(new Hole(h_x, h_y, map[h_x][h_y]));
						}
					}
					break;
				// 상좌
				case 7:
					for (int j = 0; j < 4; j++) {
						if (j == 0 || j == 2) {
							int h_x = temp.x + dx[j];
							int h_y = temp.y + dy[j];
							if (h_x < 0 || h_y < 0 || h_x >= N || h_y >= M) continue;
							if (V[h_x][h_y] == true || map[h_x][h_y] == 0) continue;
							int o_type = map[h_x][h_y];
							
							if (j == 0 && (o_type == 3 || o_type == 4 || o_type == 7)) continue;
							if (j == 2 && (o_type == 2 || o_type == 6 || o_type == 7)) continue;
							
							V[h_x][h_y] = true;
							q.add(new Hole(h_x, h_y, map[h_x][h_y]));
						}
					}
					break;
				}
			}
		
		}
	}


	private static void print(int[][] map) {
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}
	
	private static void print2(boolean[][] v) {
		for (boolean [] data_arr : v) {
			for (boolean data : data_arr) {
				System.out.print(data + "\t");
			}
			System.out.println();
		}
		
	}

}
