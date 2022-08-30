package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_2178_미로탐색2 {

	static int N, M, cnt, index;
	static int[][] map;
	static boolean[][] V;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		map = new int[N][M];
		V = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}
		cnt = 0;
		index = 1;
		dfs(0, 0);
		
		
//		System.out.println(map[N-1][M-1]);

	}

private static void dfs(int sr, int sc) {
	V[sr][sc] = true;
	
	for (int i = 0; i < 4; i++) {
		int nr = sr+deltas[i][0];
		int nc = sc+deltas[i][1];
		
		if (nr>=0 && nr < N && nc>=0 && nc <M) {
			if (map[nr][nc] == 1 && V[nr][nc] == false) {
				cnt ++;
				index ++;
				map[nr][nc] = index;
				for (int [] data_arr : map) {
					for (int data : data_arr) {
						System.out.print(data + " ");
					}
					System.out.println();
				}
				System.out.println("=======================");
				dfs(nr,nc);
				cnt --;
				index --;
			}
			if (nr == N-1 && nc == M-1 ) {
				System.out.println(cnt);
				return;
			}
		}
		
	}
	
}
}
