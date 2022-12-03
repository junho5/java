package SWEA;

import java.util.*;
import java.io.*;

public class Solution_2112_보호필름 {
	
	static int tc;
	static int x,y,k;
	static int [][] film;
	static int [][] film_copy;
	static int ans;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			film = new int [x][y];
			film_copy = new int [x][y];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < y; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
					film_copy[i][j] = film[i][j];
				}
			}
			
			subset(0,0);
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}


	private static void subset(int row, int cnt) {
		if (ans <= cnt);
		if (row == x) {
			if(check()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		// 아무것도 안넣었을 경우
		subset(row+1,cnt);
		
		// a 주입
		for (int i = 0; i < y; i++) {
			film[row][i] = 0;
		}
		subset(row+1,cnt+1);
		
		// b 주입
		for (int i = 0; i < y; i++) {
			film[row][i] = 1;
		}
		subset(row+1,cnt+1);
		
		// 원상태
		for (int i = 0; i < y; i++) {
			film[row][i] = film_copy[row][i];
		}
		
	}
	
	private static boolean check() {
		for (int i = 0; i < y; i++) {
			boolean result = false;
			int a_cnt = 0; // 0일 경우
			int b_cnt = 0; // 1일 경우
			for (int j = 0; j < x; j++) {
				if (film[j][i] == 0) {
					a_cnt++;
					if (a_cnt >= k) {
						result = true;
						break;
					}
					b_cnt = 0;
				}else {
					b_cnt++;
					if (b_cnt >= k) {
						result = true;
						break;
					}
					a_cnt = 0;
				}
			}
			if (!result) return false;
		}
		
		return true;
	}

	private static void print(int[][] film) {
		for (int [] data_arr : film) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}


}
