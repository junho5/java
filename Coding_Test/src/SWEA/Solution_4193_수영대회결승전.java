package SWEA;

import java.util.*;
import java.io.*;

public class Solution_4193_수영대회결승전 {
	
	static int tc;
	static int n;
	static int [][] map;
	static boolean [][] v;
	static int sx,sy,ex,ey;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	static class node{
		int x,y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/4193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			map = new int [n][n];
			v = new boolean [n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) map[i][j] = 12;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken()); // 시작 x
			sy = Integer.parseInt(st.nextToken()); // 시작 y
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken()); // 끝 x
			ey = Integer.parseInt(st.nextToken()); // 끝 y
			
			
//			print(map);
			
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(bfs(sx,sy));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int bfs(int sx, int sy) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sx, sy));
		v[sx][sy] = true;
		
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				node temp = q.poll();
				if (temp.x == ex && temp.y == ey) return time;
				
				for (int j = 0; j < dx.length; j++) {
					int mx = temp.x + dx[j];
					int my = temp.y + dy[j];
					
					if (mx < 0 || my < 0 || mx >= n || my >= n) continue;
					if (v[mx][my]==true || map[mx][my] == 1) continue;
					
					if (map[mx][my] == 0 || map[mx][my] == 10) {
						v[mx][my] = true;
						q.add(new node(mx, my));
					}else {
						q.add(new node(temp.x, temp.y));
					}
					
				}
				
			}
			time++;
			process();
			
		}
		
		
		return -1;
		
	}

	private static void process() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > 10) {
					map[i][j]--;
				}else if (map[i][j] == 10) {
					map[i][j] = 12;
				}
			}
		}
	}

	private static void print(int[][] map) {
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%3d ",data);
			}
			System.out.println();
		}
	}


}
