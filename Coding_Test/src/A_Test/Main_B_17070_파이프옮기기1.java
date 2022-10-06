package A_Test;

import java.util.*;


import java.io.*;

public class Main_B_17070_파이프옮기기1 {
	
	static int N,ans;
	static int [][] map;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int [N+1][N+1];
		ans = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[1][1] = 7; map[1][2] = 7;
		print(map);
		
		dfs(1,2,0);
		System.out.println(ans);
		
	}

	private static void dfs(int x, int y, int type) {
		if (x==N && y==N) {
			ans++;
			return;
		}
		
		switch (type) {
		case 0: // 파이프 가로
			// 가로 이동
			if (y+1<=N && map[x][y+1] != 1) dfs (x,y+1,0);
			break;
			
		case 1: // 파이프 세로
			// 세로 이동
			if (x+1<=N && map[x+1][y] != 1) dfs (x+1,y,1);
			break;
			
		case 2: // 파이프 대각선
			if (y+1<=N && map[x][y+1] != 1) dfs (x,y+1,0);
			if (x+1<=N && map[x+1][y] != 1) dfs (x+1,y,1);
			break;
		}
		if (x+1<=N && y+1<=N && map[x+1][y] != 1 && map[x][y+1] != 1 && map[x+1][y+1] != 1) {
			dfs(x+1,y+1,2);
			
		}
		
		
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
