package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_2178_미로탐색 {

	static int N, M;
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

		bfs(0, 0);
		
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%3d", data);
			}
			System.out.println();
		}
		
		System.out.println(map[N-1][M-1]);

	}

	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		V[x][y] = true;
		q.add(new Node(x, y));

		while (!q.isEmpty()) {
			Node temp = q.poll();
//			System.out.printf("(%d %d)",temp.x,temp.y);

			for (int i = 0; i < deltas.length; i++) {
				int dx = temp.x + deltas[i][0];
				int dy = temp.y + deltas[i][1];

				if (dx < 0 || dx >= N || dy < 0 || dy >= M)
					continue;
				if (V[dx][dy] == true || map[dx][dy] != 1)
					continue;

				V[dx][dy] = true;
				map[dx][dy] = map[temp.x][temp.y] + 1;
				q.add(new Node(dx, dy));
			}
		}
	}

}

class Node {
	int x, y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
