package A_Test;

import java.util.*;
import java.io.*;

public class Solution_5653_줄기세포배양 {

	static int tc;
	static int N, M, K, max_len, mid;
	static int [][] map;
	static boolean [][] V;
	static int [] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int [] dy = { 0, 0, -1, 1 }; // 상하좌우
	static List<int []> cells;
	static List<Cell> cnt_list;
	static PriorityQueue<Cell> q;
	
	static class Cell implements Comparable<Cell>{
		int x,y,time,copy_time,life,turn,wait_time;


		public Cell(int x, int y, int time, int copy_time, int life, int turn, int wait_time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.copy_time = copy_time;
			// 0은 비활성화 1은 활성화
			this.life = life;
			this.turn = turn;
			this.wait_time = wait_time;
		}


		@Override
		public int compareTo(Cell o) {
			if (this.turn == o.turn) {
				return o.copy_time - this.copy_time;
			}else {
				return this.turn - o.turn;
			}
		}

		
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/5653.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			K = Integer.parseInt(st.nextToken()); // 배양시간
			cells = new ArrayList<int[]>();
			cnt_list = new ArrayList<Solution_5653_줄기세포배양.Cell>();
			
			// map 생성 후 중앙에 세포 두기
			max_len = 1200;
			mid = max_len/2;
			
			map = new int[max_len][max_len];
			V = new boolean[max_len][max_len];
			for (int i = mid; i < mid + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = mid; j < mid + M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						// x 좌표, y 좌표, 생존시간, 생존시간복사, 생존유무, 카운트, 기다린시간
						int [] temp_arr = {i,j,map[i][j],map[i][j],0,1,0};
						cells.add(temp_arr);
					}
				}
			}
			bfs();
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(q.size()+1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs() {
		q = new PriorityQueue<>();
		for (int i = 0; i < cells.size(); i++) {
			int c_x = cells.get(i)[0];
			int c_y = cells.get(i)[1];
			int time = cells.get(i)[2];
			int copy_time = cells.get(i)[3];
			int life = cells.get(i)[4];
			int turn = cells.get(i)[5];
			int wait_time = cells.get(i)[6];
			V[c_x][c_y] = true;
			q.add(new Cell(c_x, c_y, time, copy_time, life, turn, wait_time));
		}
		
		while (!q.isEmpty()) {
			Cell temp = q.poll();
			// K 시간 지났을 경우 종료
			if (temp.turn > K) break;
			
			// 아직 비활성화되있는 상태
			if (temp.time != 0) {
				if (temp.time-1 == 0) {
					temp.life = 1;
				}
				q.add(new Cell(temp.x, temp.y, temp.time-1, temp.copy_time, temp.life, temp.turn+1, temp.wait_time));
			}else {
				// 활성화 되어있는 상태 bfs 실행
				for (int i = 0; i < dx.length; i++) {
					int n_x  = temp.x + dx[i];
					int n_y = temp.y + dy[i];
					if (n_x < 0 || n_y < 0 || n_x >= max_len || n_y >= max_len) continue;
					if (V[n_x][n_y] == true) continue;
					
					V[n_x][n_y] = true;
					map[n_x][n_y] = temp.copy_time;
					// 활성화 상태 -> 비활성화 상태로 큐 삽입
					q.add(new Cell(n_x, n_y, temp.copy_time, temp.copy_time, 0, temp.turn+1, temp.wait_time));
				}
				
				// bfs 종료 후 만약 활성화하고 기다린 시간이 time이랑 같으면 사망처리 다르면 큐 삽입
				if (++temp.wait_time != temp.copy_time) {
					temp.turn++;
					q.add(temp);
				}
			}
			
		}
	}

	private static void print(int[][] map) {
		for (int[] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%d ", data);
			}
			System.out.println();
		}
	}

}
