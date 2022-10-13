package A_Test;

import java.util.*;
import java.io.*;

public class Main {

	static int N, M, x, y, time;
	static int[][] map;
	static boolean[][] V;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Pipe{
		int x,y,type;

		public Pipe(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			V = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			bfs(x,y,map[x][y]);
			print(V);
			
		}

	}

	private static void print(boolean[][] v) {
		for (boolean [] data_arr : v) {
			for (boolean data : data_arr) {
				System.out.print(data + "\t");
			}
			System.out.println();
		}
	}

	private static void bfs(int x, int y, int type) {
		Queue<Pipe> q = new LinkedList<Pipe>();
		q.add(new Pipe(x, y, map[x][y]));
		V[x][y] = true;
		
		int turn = 1;
		if (turn == time) return;
		
		while(!q.isEmpty()) {
			turn++;
			if (turn > time) break;
			int size = q.size();
			
			for (int w = 0; w < size; w++) {
				Pipe temp = q.poll();
				
				int dir = temp.type;
				switch (dir) {
				// 상하좌우
				case 1:
					for (int i = 0; i < 4; i++) {
						int nx = temp.x + dx[i];
						int ny = temp.y + dy[i];
						
						if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if (V[nx][ny] == true || map[nx][ny] == 0) continue;
						
						if (i == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7 )) continue;
						if (i == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6 )) continue;
						if (i == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7 )) continue;
						if (i == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5 )) continue;
						V[nx][ny] = true;
						q.add(new Pipe(nx, ny, map[nx][ny]));
					}
					break;
					// 상하
				case 2:
					for (int i = 0; i < 2; i++) {
						int nx = temp.x + dx[i];
						int ny = temp.y + dy[i];
						
						if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if (V[nx][ny] == true || map[nx][ny] == 0) continue;
						
						if (i == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7 )) continue;
						if (i == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6 )) continue;
						V[nx][ny] = true;
						q.add(new Pipe(nx, ny, map[nx][ny]));
					}
					break;
					// 좌우
				case 3:
					for (int i = 2; i < 4; i++) {
						int nx = temp.x + dx[i];
						int ny = temp.y + dy[i];
						
						if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if (V[nx][ny] == true || map[nx][ny] == 0) continue;
						
						if (i == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7 )) continue;
						if (i == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5 )) continue;
						V[nx][ny] = true;
						q.add(new Pipe(nx, ny, map[nx][ny]));
					}
					break;
					// 상우
				case 4:
					for (int i = 0; i < 4; i++) {
						if (i == 0 || i == 3) {
							int nx = temp.x + dx[i];
							int ny = temp.y + dy[i];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
							if (V[nx][ny] == true || map[nx][ny] == 0) continue;
							
							if (i == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7 )) continue;
							if (i == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5 )) continue;
							V[nx][ny] = true;
							q.add(new Pipe(nx, ny, map[nx][ny]));
						}
					}
					break;
					// 하우
				case 5:
					for (int i = 0; i < 4; i++) {
						if (i == 1 || i == 3) {
							int nx = temp.x + dx[i];
							int ny = temp.y + dy[i];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
							if (V[nx][ny] == true || map[nx][ny] == 0) continue;
							
							if (i == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6 )) continue;
							if (i == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5 )) continue;
							V[nx][ny] = true;
							q.add(new Pipe(nx, ny, map[nx][ny]));
						}
					}
					break;
					// 하좌
				case 6:
					for (int i = 0; i < 4; i++) {
						if (i == 1 || i == 2) {
							int nx = temp.x + dx[i];
							int ny = temp.y + dy[i];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
							if (V[nx][ny] == true || map[nx][ny] == 0) continue;
							
							if (i == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6 )) continue;
							if (i == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7 )) continue;
							V[nx][ny] = true;
							q.add(new Pipe(nx, ny, map[nx][ny]));
						}
					}
					break;
					// 상좌
				case 7:
					for (int i = 0; i < 4; i++) {
						if (i == 0 || i == 2) {
							int nx = temp.x + dx[i];
							int ny = temp.y + dy[i];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
							if (V[nx][ny] == true || map[nx][ny] == 0) continue;
							
							if (i == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7 )) continue;
							if (i == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7 )) continue;
							V[nx][ny] = true;
							q.add(new Pipe(nx, ny, map[nx][ny]));
						}
					}
					break;
				}
			}
			
			
			
		}
	}

}
