package A_Test;

import java.util.*;
import java.io.*;

public class Solution_2117_홈방범서비스2 {
	
	static int tc;
	static int N,M,ans;
	static int map [][];
	static boolean V [][];
	static int [] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int [] dy = { 0, 0, -1, 1 }; // 상하좌우
	
	static class House{
		int x,y;
		
		public House(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2117.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로 세로 길이
			M = Integer.parseInt(st.nextToken()); // 지불 비용
			
			map = new int [N][N];
			ans = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			print(map);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					V = new boolean [N][N];
					bfs(i,j);
				}
			}
//			System.out.println(ans);
			
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void bfs(int x, int y) {
		Queue<House> q = new LinkedList<House>();
		q.add(new House(x, y));
		V[x][y] = true;
		
		// 0 부터 시작
		int k = 0;
		int house_num = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			k ++;
			
			for (int i = 0; i < size; i++) {
				House temp = q.poll();
				if (map[temp.x][temp.y] == 1) house_num++;
				
				for (int j = 0; j < dx.length; j++) {
					int h_x = temp.x + dx[j];
					int h_y = temp.y + dy[j];
					
					if (h_x < 0 || h_y < 0 || h_x >=N || h_y >= N) continue;
					if (V[h_x][h_y] == true) continue;
					
					V[h_x][h_y] = true;
					q.add(new House(h_x, h_y));
					
				}
				
				if (cost(k) <= house_num * M && ans < house_num) {
					ans = house_num;
				}
				
			}
			
		}
		
	}

	private static int cost(int k) {
		return k * k + (k - 1) * (k - 1);
	}

	private static void print(int[][] map) {
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}


}
