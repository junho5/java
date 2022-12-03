package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_17143_낚시왕 {

	static int R, C, M;
	static int x, y, s, d, z;
	static int ans;
	static Shark map[][];
	static Shark copy_map[][];
	// 상 1   하 2   우 3   좌 4
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Shark {
		int x, y, speed, dir, size;

		public Shark(int x, int y, int speed, int dir, int size) {
			super();
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/17143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // x 크기
		C = Integer.parseInt(st.nextToken()); // y 크기
		M = Integer.parseInt(st.nextToken()); // 상어 수
		map = new Shark[R][C]; // 상어 담을 배열
		ans = 0; // 최종 답

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // x 좌표
			y = Integer.parseInt(st.nextToken()); // y 좌표
			s = Integer.parseInt(st.nextToken()); // 상어 스피드
			d = Integer.parseInt(st.nextToken()); // 상어 방향
			z = Integer.parseInt(st.nextToken()); // 상어 크기
			map[x - 1][y - 1] = new Shark(x, y, s, d, z);
		}
//		print(map);

		for (int i = 0; i < C; i++) {
			catchShark(i);
//			System.out.printf("------%d번째 캐치------\n", i + 1);
//			print(map);
			move();
//			System.out.printf("------%d번째 이동------\n", i + 1);
//			print(copy_map);
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					map[j][j2] = copy_map[j][j2];
				}
				
			}
		}
		
		System.out.println(ans);

	}

	private static void move() {
		copy_map = new Shark[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) {
					int m_x = map[i][j].x;
					int m_y = map[i][j].y;
					int speed = map[i][j].speed;
					int dir = map[i][j].dir;
					int size = map[i][j].size;
//					System.out.printf("%d %d\n",m_x,m_y);
//					System.out.println(dir);
					for (int k = 0; k < speed; k++) {
						if (k==0) {
							if (m_x == 1 && dir == 1) dir = 2;
							if (m_x == R && dir == 2) dir = 1;
							if (m_y == C && dir == 3) dir = 4;
							if (m_y == 1 && dir == 4) dir = 3;
						}
						switch (dir) {
						// 상 1   하 2   우 3   좌 4
						
						case 1:
							m_x--;
							if(m_x == 1) dir = 2;
							break;
						case 2:
							m_x++;
							if(m_x == R) dir = 1;
							break;
						case 3:
							m_y++;
							if(m_y == C) dir = 4;
							break;
						case 4:
							m_y--;
							if(m_y == 1) dir = 3;
							break;
						}
					}
					if (copy_map[m_x-1][m_y-1] != null && copy_map[m_x-1][m_y-1].size > size) {
						continue;
					}
					
					copy_map[m_x-1][m_y-1] = new Shark(m_x, m_y, speed, dir, size);
//					print(copy_map);
					
				}
			}
		}
	}

	private static void catchShark(int index) {
		for (int i = 0; i < R; i++) {
			if (map[i][index] != null) {
				ans += map[i][index].size;
				map[i][index] = null;
				break;
			}
		}
	}

	private static void print(Shark[][] map) {
		for (Shark[] data_arr : map) {
			for (Shark data : data_arr) {
				if (data != null) {
					System.out.print("Shark    ");
				} else {
					System.out.print("X        ");
				}
			}
			System.out.println();
		}
	}

}
