package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_7576_토마토 {

	static int M, N,zero;
	static int[][] map;
	static boolean[][] V;
	static List<int[]> list = new ArrayList<int[]>();
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input/7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		V = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					int[] temp = { i, j };
					list.add(temp);
				}else if (map[i][j] == 0)  {
					zero++;
				}
			}
		}
//		System.out.println(zero);
		bfs();
//		for (int [] data_arr : map) {
//			for (int data : data_arr) {
//				System.out.print(data);
//			}
//			System.out.println();
//		}
		zero_check(zero,map,0);
//		System.out.println(zero);
	}


	private static void zero_check(int zero2, int[][] map2,int answer) {
		if (zero2 > 0) {
			System.out.println(-1);
		}else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer = Math.max(answer, map2[i][j]);
				}
			}
			System.out.println(answer-1);
		}
	}


	private static void bfs() {
		Queue<tomato> mato = new LinkedList<tomato>();
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			mato.add(new tomato(x, y));
			V[x][y] = true;
		}

		while (!mato.isEmpty()) {
			tomato temp = mato.poll();
			
			for (int i = 0; i < deltas.length; i++) {
				int nx = temp.x + deltas[i][0];
				int ny = temp.y + deltas[i][1];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(V[nx][ny] == true || map[nx][ny] != 0) continue;
				
				V[nx][ny] = true;
				map[nx][ny] = map[temp.x][temp.y] + 1;
				mato.add(new tomato(nx, ny));
				zero--;
				System.out.println("===============");
				for (int [] data_arr : map) {
					for (int data : data_arr) {
						System.out.print(data);
					}
					System.out.println();
				}
				System.out.println("===============");
			}

		}

	}

}

class tomato {
	int x, y;

	public tomato(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}