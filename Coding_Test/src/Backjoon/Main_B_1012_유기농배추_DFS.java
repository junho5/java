package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1012_유기농배추_DFS {

	static int N, M, tc, num, answer, check;
	static int[][] map;
	static boolean[][] V;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<int[]> cabbage_list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			check = 0;
			answer = 0;
			cabbage_list = new ArrayList<int[]>();

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());

			map = new int[M][N];
			V = new boolean[M][N];

			for (int j = 0; j < num; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()); // 열
				int x = Integer.parseInt(st.nextToken()); // 행
				map[x][y] = 1;
				int[] temp = { x, y };
				cabbage_list.add(temp);
			}
			
			print(map);
			for (int list_num = 0; list_num < cabbage_list.size(); list_num++) {
				int x = cabbage_list.get(list_num)[0];
				int y = cabbage_list.get(list_num)[1];
				dfs(x, y);
			}
			System.out.println("======================");
			print(map);

			System.out.println(cabbage_list.size()-check);

		}

	}

	private static void dfs(int x, int y) {
		V[x][y] = true;

		for (int i = 0; i < deltas.length; i++) {
			int dx = x + deltas[i][0];
			int dy = y + deltas[i][1];

			if (dx < 0 || dx >= M || dy < 0 || dy >= N || V[dx][dy] == true || map[dx][dy] != 1) {
				continue;
			}

			map[dx][dy] = map[x][y] + 1;
			check++;
			dfs(dx,dy);
		}
	}

	private static void print(int[][] map) {
		for (int[] data_arr : map) {
			for (int data : data_arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}

	private static void print2(boolean[][] map) {
		for (boolean[] data_arr : map) {
			for (boolean data : data_arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}

}

class cabbage2 {
	int x, y;

	public cabbage2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
