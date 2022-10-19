package A_Test;

import java.util.*;
import java.io.*;

class Solution {

	static int tc, N, max;
	static int map[][];
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<int[]> hole;
	static LinkedList<int[]> start;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input/5650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {

			hole = new ArrayList<>();
			start = new LinkedList<>();

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 5) {
						hole.add(new int[] { i, j, map[i][j] });
					} else if (map[i][j] == 0) {
						start.add(new int[] { i, j });
					}
				}
			}

			while (!start.isEmpty()) {

				int[] temp = start.poll();
				int x = temp[1];
				int y = temp[0];

				for (int i = 0; i < 4; i++) {
					int score = 0;
					int ny = y;
					int nx = x;
					int direc = i;
					while (true) {
						nx += dir[direc][1];
						ny += dir[direc][0];
						if (ny > -1 && nx > -1 && nx < N && ny < N) {
							if (map[ny][nx] == -1 || (ny == y && nx == x)) {
								break;
							} else if (map[ny][nx] > 5) {
								for (int j = 0; j < hole.size(); j++) {
									if (hole.get(j)[2] == map[ny][nx]
											&& (hole.get(j)[0] != ny || hole.get(j)[1] != nx)) {
										ny = hole.get(j)[0];
										nx = hole.get(j)[1];
										break;
									}
								}
							} else if (map[ny][nx] != 0) {
								switch (map[ny][nx]) {
								case 1: // 하 좌 1 2
									if (direc == 1) 
										direc = 3;
									else if (direc == 2)
										direc = 0;
									else if (direc == 0)
										direc = 1;
									else if (direc == 3)
										direc = 2;
									break;
								case 2: // 상우좌하
									if (direc == 1) 
										direc = 0;
									else if (direc == 2)
										direc = 1;
									else if (direc == 0)
										direc = 3;
									else if (direc == 3)
										direc = 2;
									break;
								case 3: // 상좌우하
									if (direc == 0)
										direc = 2;
									else if (direc == 1)
										direc = 0;
									else if (direc == 2)
										direc = 3;
									else if (direc == 3)
										direc = 1;
									break;
								case 4: // 하로가면 좌 우로가면 상
									if (direc == 0)
										direc = 1;
									else if (direc == 1)
										direc = 2;
									else if (direc == 2)
										direc = 3;
									else if (direc == 3)
										direc = 0;
									break;
								case 5: // 하로가면 좌 우로가면 상
									if (direc == 0)
										direc = 1;
									else if (direc == 1)
										direc = 0;
									else if (direc == 2)
										direc = 3;
									else if (direc == 3)
										direc = 2;
									break;
								}
								score++;
							}
						} else {
							score = score * 2 + 1;
							break;
						}
					} 
					if (score > max)
						max = score;
				} 
			}
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(max);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
