package SWEA;

import java.util.*;
import java.io.*;

public class Solution_2382_미생물격리 {
	
	static int tc;
	static int n,time,num;
	static cell [][] map;
	static boolean [][] v;
	static PriorityQueue<cell> q;
	static int [] dx = {0,-1,1,0,0};
	static int [] dy = {0,0,0,-1,1};
	static class cell implements Comparable<cell>{
		int x,y,life,dir;

		public cell(int x, int y, int life, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.life = life;
			this.dir = dir;
		}

		@Override
		public int compareTo(cell o) {
			return o.life - this.life;
		}
		
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken()); // 가로 세로 길이 
			time = Integer.parseInt(st.nextToken()); // 격리 시간 
			num = Integer.parseInt(st.nextToken()); // 군집 개수  
			
			map = new cell [n][n];
			v = new boolean [n][n];
			q = new PriorityQueue<>();
			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				q.add(new cell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
//			System.out.println(play());
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(play());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void print(cell[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != null) {
					System.out.printf("%3d" , map[i][j].life);
				}else {
					System.out.printf("%3d" , 0);
				}
			}
			System.out.println();
		}
	}

	private static int cal() {
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != null) {
					total += map[i][j].life;
				}
			}
		}
		return total;
	}

	private static int play() {
		int total = 0;
		while(time > 0) {
			
			while(!q.isEmpty()) {
				cell temp = q.poll();
				// 셀 이동 
				int mx = temp.x + dx[temp.dir];
				int my = temp.y + dy[temp.dir];
				
				// 끝에 위치 할 경우 
				if (mx == 0 || mx ==n-1 || my == 0 || my ==n-1) {
					temp.life /= 2;
					if (temp.life == 0) continue;
				
//						끝 위치하므로 변경 상(1) 하(2) 좌(3) 우(4)
						if (temp.dir == 1 || temp.dir == 3) temp.dir++;
						else temp.dir--;
						
				}
				
				if (map[mx][my] == null) {
					map[mx][my] = new cell(mx, my, temp.life, temp.dir);
				}else {
					map[mx][my].life += temp.life;
				}
				
			}
			time--;
			total = cal();
			reset();
			
		}
		return total;
	}

	private static void reset() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == null) continue; 
				q.add(map[i][j]);
				map[i][j] = null;
			}
		}
	}
	
	


}
