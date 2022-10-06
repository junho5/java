package A_Test;

import java.util.*;
import java.io.*;

public class Main_B_7576_토마토 {
	
	static int M,N,zero;
	static int [][] map;
	static boolean [][] V;
	static List<int []> mato = new ArrayList<int[]>();
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	static class Tomato{
		int x,y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		map = new int [N][M];
		V = new boolean [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					int [] temp_mato = {i,j};
					mato.add(temp_mato);
				}else if (map[i][j] == 0) {
					zero++;
				}
			}
		}
//		System.out.println("-------------  초기 맵  -------------");
//		print(map);
//		System.out.println("-------------  토마토 좌표  -------------");
//		for (int [] data_arr : mato) {
//			for (int data : data_arr) {
//				System.out.print(data);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//		System.out.println("-------------  토마토 좌표  -------------");
		
		bfs();
//		print(map);
		zero_check(zero);
	}

	private static void zero_check(int zero) {
		int ans = Integer.MIN_VALUE;
		if (zero > 0) {
			System.out.println(-1);
		}else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans = Math.max(ans, map[i][j]);
				}
			}
			System.out.println(ans-1);
		}
	}

	private static void bfs() {
		Queue<Tomato> q = new LinkedList<Main_B_7576_토마토.Tomato>();
		for (int i = 0; i < mato.size(); i++) {
			int x = mato.get(i)[0];
			int y = mato.get(i)[1];
			q.add(new Tomato(x, y));
			V[x][y] = true;
		}
		
		while(!q.isEmpty()) {
			Tomato temp = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
				if (V[nx][ny] == true || map[nx][ny] != 0) continue;
				
				V[nx][ny] = true;
				map[nx][ny] = map[temp.x][temp.y] +1;
				zero--;
				q.add(new Tomato(nx, ny));
			}
			
		}
	}
	
	
	private static void print(int[][] map) {
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%d ", data);
			}
			System.out.println();
		}
		
	}


}
